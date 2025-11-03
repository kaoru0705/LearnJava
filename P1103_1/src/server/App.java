package server;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) {
        System.out.println("[서버 로그] 서버 시작...");

        try(ServerSocket serverSocket = new ServerSocket(7777)) {
            while(true) {
                Socket socket = serverSocket.accept();  // 클라이언트 접속 대기

                // 첫 번째 전달 받은 문자열은 닉네임이다: Protocol (네트워크 데이터 규칙)

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String nickname = dis.readUTF();

                ClientInfoDto clientInfoDto = new ClientInfoDto(nickname, socket);
                ClientInfoListManager.list.add(clientInfoDto);

                ServerReceiveMessageThread serverReceiveMessageThread = new ServerReceiveMessageThread(clientInfoDto);
                serverReceiveMessageThread.start();

                
                
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("[서버 로그] 서버 종료...");

    }
}
