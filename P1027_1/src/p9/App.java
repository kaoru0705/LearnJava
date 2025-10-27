package p9;

import java.io.FileOutputStream;
import java.net.Socket;

public class App {
    public static void main(String[] args) {
        int value = Integer.parseInt("19");
        // try {
        //     // 언젠가 배울 개념 AOP
        //     // unhandled exception이 나오면 try catch 
        //     FileOutputStream fileOutputStream = new FileOutputStream("C:/aaa/bbb.text");
        //     Socket socket = new Socket("111.111.111.111", 8000);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // try with Resources AutoClosable을 상속받은 것들만 가능
        try(FileOutputStream fileOutputStream = new FileOutputStream("C:/aaa/bbb.text")) {

        } catch(Exception e) {

        }
    }
}
