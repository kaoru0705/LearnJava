package p4;

import java.util.Arrays;

// Lambda
public class App {
    public static void main(String[] args) {
        
        // Lambda식이 4줄이나 있을 거면 그냥 따로 클래스로 구현을 해라
        // 무조건 한 줄로 만든 코드만 파라미터가 많아도 안 쓰는 게 좋다.
        AAA a2 = (a, b) -> a + b;
        System.out.println(a2.test(4, 7));

        // 람다식 - 하나의 추상 메소드가 있을 때 가능
        // 익명 클래스는 가능하지만 익명 클래스는 아무도 안 씀


    }
}

interface AAA {
    public int test(int a, int b);
}