package p4;

import java.io.*;
public class App {
    public static void main(String[] args) throws Exception{
        /* https://ko.wikipedia.org/wiki/BMP_%ED%8C%8C%EC%9D%BC_%ED%8F%AC%EB%A7%B7 */
        // bmp 기준의 파일 생성
        // 파일명: aaa.bmp
        // 해상도: 100 X 100
        
        File file = new File("C:\\Temp\\aaa.bmp");
        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);

        // 헤더
        // 시그니처 BM
        dos.writeByte('B');
        dos.writeByte('M');
        // Little Endian
        // 파일 총 크기
        // 한픽셀 rgb 3바이트 * 100 * 100 + 54(14+40)
        dos.writeByte(30054 >> 0);
        dos.writeByte(30054 >> 8);
        dos.writeByte(30054 >> 16);
        dos.writeByte(30054 >> 24);
        // 예약 = 0
        dos.writeByte(0 >> 0);
        dos.writeByte(0 >> 8);
        // 예약 = 0
        dos.writeByte(0 >> 0);
        dos.writeByte(0 >> 8);
        // Raw 데이터 시작 인덱스
        dos.writeByte(54 >> 0);
        dos.writeByte(54 >> 8);
        dos.writeByte(54 >> 16);
        dos.writeByte(54 >> 24);


        // 2차 헤더 시작
        // 헤더와 크기 (40)
        dos.writeByte(40 >> 0);
        dos.writeByte(40 >> 8);
        dos.writeByte(40 >> 16);
        dos.writeByte(40 >> 24);

        // 비트맵 가로
        dos.writeByte(100 >> 0);
        dos.writeByte(100 >> 8);
        dos.writeByte(100 >> 16);
        dos.writeByte(100 >> 24);

        // 세로 크기
        dos.writeByte(100 >> 0);
        dos.writeByte(100 >> 8);
        dos.writeByte(100 >> 16);
        dos.writeByte(100 >> 24);

        // 색상 평면 수?
        dos.writeByte(1 >> 0);
        dos.writeByte(1 >> 8);

        // 픽셀당 비트수 .. 우리는 24
        dos.writeByte(24 >> 0);
        dos.writeByte(24 >> 8);

        // 압축 알고리즘
        dos.writeByte(0 >> 0);
        dos.writeByte(0 >> 8);
        dos.writeByte(0 >> 16);
        dos.writeByte(0 >> 24);

        // 원시 데이터 크기
        dos.writeByte(30000 >> 0);
        dos.writeByte(30000 >> 8);
        dos.writeByte(30000 >> 16);
        dos.writeByte(30000 >> 24);

        // 미터당 픽셀 수 세로
        dos.writeByte(30000 >> 0);
        dos.writeByte(30000 >> 8);
        dos.writeByte(30000 >> 16);
        dos.writeByte(30000 >> 24);


        dos.writeByte(30000 >> 0);
        dos.writeByte(30000 >> 8);
        dos.writeByte(30000 >> 16);
        dos.writeByte(30000 >> 24);

        dos.writeByte(30000 >> 0);
        dos.writeByte(30000 >> 8);
        dos.writeByte(30000 >> 16);
        dos.writeByte(30000 >> 24);
        
        // 사용된 중요한 색상 수?
        dos.writeByte(30000 >> 0);
        dos.writeByte(30000 >> 8);
        dos.writeByte(30000 >> 16);
        dos.writeByte(30000 >> 24);

        // Raw DATA
        for(int x = 0; x < 100; x++) {
            for(int y = 0; y < 100; y++) {
                if(x <= Math.round(Math.pow(y, 1.425))) {
                    if(x >= Math.pow(y, 1.38)) {
                        dos.writeByte(0x00);
                        dos.writeByte(0x00);
                        dos.writeByte(0xFF);
                        continue;
                    }
                    
                }
                dos.writeByte(0xFF); // B
                dos.writeByte(0xFF); // G
                dos.writeByte(0xFF); // R
            }
        }



        dos.close();
        bos.close();
        fos.close();
    }
}
