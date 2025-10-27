package p9;

import java.io.FileOutputStream;
import java.net.Socket;

public class App {
    public static void main(String[] args) {
        int value = Integer.parseInt("19");
        try {
            // 언젠가 배울 개념 AOP
            // unhandled exception이 나오면 try catch 
            Socket socket = new Socket("111.111.111.111", 8000);
            FileOutputStream fileOutputStream = new FileOutputStream("C:/aaa/bbb.text");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
