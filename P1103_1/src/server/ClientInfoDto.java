package server;

import java.net.Socket;

public class ClientInfoDto {
    public String nickname;
    public Socket socket;


    public ClientInfoDto(String nickname, Socket socket ) {
        this.nickname = nickname;
        this.socket = socket;
    }
}
