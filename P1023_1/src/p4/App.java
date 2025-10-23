package p4;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Object = 사실 얘는 의미없는데 중요함
        // 모든 클래스의 최상위 부모(조상)

        Object a1 = new AAA();
        Object a2 = new Scanner("");
        Object a3 = "asdada";

        // 자동으로 wrapper class로 변환
        a3 = 13;
        a3 = "faifje";
        // 자동으로 wrapper class로 변환
        a3 = true;

        List<Object> list = new ArrayList<>();

        AAA ref1 = new AAA();
        ref1.a = 10;
        AAA ref2 = new AAA();
        ref2.b = 30;

        // hash값 출력
        // 사실 Object 내부에 있는 toString()을 호출한다
        System.out.println(ref1);
        System.out.println(ref2);
    }
}

class AAA {
    int a;
    int b;

    public String toString() {
        // 로그용으로 오버라이딩하는 것을 일반적으로 추천함. 사실 나중에 롬복이 다 해줌
        return String.format("{a=%d, b=%d}", a, b);
    }
}