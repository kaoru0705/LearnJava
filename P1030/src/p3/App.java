package p3;

import java.io.*;

public class App {
    public static void main(String[] args) throws Exception{
        // 파일 로드
        File file = new File("C:\\Temp\\aaa.dat");

        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(bis);

        System.out.println(dis.readInt());
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readUTF());

        dis.close();
        bis.close();
        fis.close();

    }
}
