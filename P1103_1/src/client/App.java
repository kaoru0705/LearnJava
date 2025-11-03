package client;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("클라이언트 시작");

        System.out.println("닉네임을 입력해 주세요 > ");
        String nickname = scanner.nextLine();

        System.out.println("서버에 접속을 시도합니다...");
        try(Socket socket = new Socket("172.30.1.71", 7777)) {
            System.out.println("서버에 접속 성공...");

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(nickname);

        } catch(Exception e) {
            e.printStackTrace();
        }


        System.out.println("클라이언트 종료");
        scanner.close();
    }
}
