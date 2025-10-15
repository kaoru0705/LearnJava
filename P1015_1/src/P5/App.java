package P5;

public class App {
    public static void main(String[] args) {
        // api
        int r1 = Math.min(3, 5);
        int randomNumber = (int)(Math.random() * 6) + 1;

        // "안녕하세요"는 주소다. 내부적으로는 배열이고 Byte type으로 저장된다.
        String str = "안녕하세요";

        // 요즘엔 이렇게 쓰는 사람들도 꽤 있다.
        "반갑".equals(str);

        System.out.println("abcdefghijklmnopqrstuvwxyz".toUpperCase());

        System.out.println(randomNumber);
    }
}