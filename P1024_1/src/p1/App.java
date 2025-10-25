package p1;

public class App {
    public static void main(String[] args) {
        // Wrapper
        int a = 11;
        // 상당히 많은 개발자가 Integer를 많이 쓴다.
        // 연산에는 불리하지만 생각보다 웹개발자는 산술연산을 안 한다.
        // 많은 산술연산은 데이터베이스에서 처리한다.
        Integer b = 20;

        System.out.println(Integer.toBinaryString(132));
        
        // 강사님은 String.valueOf 를 더 선호한다.
        // String result = String.valueOf(10);
        // String result = Integer.toString(10);

        // 1bit 수 구하기
        System.out.println(Integer.bitCount(a));
    }
}
