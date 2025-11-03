package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ServerReceiveMessageThread extends Thread {
    
    private final ClientInfoDto clientInfoDto;

    public ServerReceiveMessageThread(ClientInfoDto clientInfoDto) {
        this.clientInfoDto = clientInfoDto;
    }

    @Override
    public void run() {

        try (clientInfoDto.socket){
            String helloMessage = clientInfoDto.nickname + "님이 접속하셨습니다.";
            broadcast(helloMessage);

            DataInputStream dis = new DataInputStream(clientInfoDto.socket.getInputStream());

            while(true) {
                
                String message = dis.readUTF(); // A로부터 메세지 수신 대기
                
                // 브로드 캐스팅.. A를 포함한 모든 접속자에게 메시지 전달
                String forSendMessage = clientInfoDto.nickname + "] ";
                forSendMessage += message;
                broadcast(forSendMessage);

            }


        } catch (Exception e) {
            // 접속 종료 대비
            ClientInfoListManager.list.remove(clientInfoDto);
            String message = clientInfoDto.nickname + "님이 퇴장하셨습니다.";
            broadcast(message);
        }
    }

    private void broadcast(String message) {
        // 브로드 캐스팅.. A를 포함한 모든 접속자에게 메시지 전달
        System.out.println("[서버 로그] " + message);
        for(ClientInfoDto element : ClientInfoListManager.list) {
            try {
                DataOutputStream dos = new DataOutputStream(element.socket.getOutputStream());

                dos.writeUTF(message);

            } catch (Exception e) {
                System.out.println("[서버 예외] 설마 이거 발생하지 않겠지?!!!!!");
            }
        }
    }
}
