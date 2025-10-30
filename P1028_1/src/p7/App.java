package p7;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class App {
    public static void main(String[] args) throws Exception {
        String text = "안녕하세요!!";
        // 비트코인에서도 쓰는 알고리즘
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digest = md.digest(text.getBytes(StandardCharsets.UTF_8));

        // 보기 쉽게 문자열로 변환
        StringBuilder stringBuilder = new StringBuilder();
        for(byte b : digest) {
            stringBuilder.append(String.format("%02x", b));
        }
        System.out.println(stringBuilder.toString());

    }
}
