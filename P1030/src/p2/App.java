package p2;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class App {
    public static void main(String[] args) throws Exception{
        // 파일 입출력
        // 목표: 데이터를 파일에 저장할 수 있다.

        int a = 0xAABBCCDD;

        File file = new File("C:\\Temp\\aaa.dat");

        FileOutputStream fos = new FileOutputStream(file);
        // buffer에 담았다가 저장
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);

        dos.writeInt(10);
        dos.writeInt(16);
        dos.writeUTF("안녕하세요");
        dos.writeUTF("반갑습니다");

        // Big Endian
        // fos.write(a >> 24);
        // fos.write(a >> 16);
        // fos.write(a >> 8);
        // fos.write(a >> 0);

        // Little Endian
        // fos.write(a >> 0);
        // fos.write(a >> 8);
        // fos.write(a >> 16);
        // fos.write(a >> 24);

        // 10초 사이에 파일을 삭제하려고 한다면? 열려있으므로 불가능
        // Thread.sleep(10000);

        dos.close();
        bos.close();
        fos.close();
    }
}
