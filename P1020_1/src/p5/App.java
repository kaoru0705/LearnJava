package p5;

public class App {
    public static void main(String[] args) {
        // 상속 - 다형성 - 오버라이딩 => 하나라도 모르면 전부 모르는 것 대표표현이 다형성
        // 문법 의도: 결합도를 낮춘다. Decoupling => 컴포넌트를 조립으로 하자
        // 저번 코드는 Controller와 Service의 결합도가 너무 높다. 상황에 따라 다른 Service를 사용한다면?
        // 상속 - 다형성 - 오버라이딩 => 인터페이스(자바의 꽃)

        AAA ref1 = new AAA();
        ref1.a1 = 10;

        BBB ref2 = new BBB();
        ref2.a1 = 10;
        ref2.b1 = 10;

        CCC ref3 = new CCC();
        ref3.a1 = 10;
        ref3.c1 = 10;

        DDD ref4 = new DDD();
        ref4.a1 = 10;
        ref4.b1 = 10;
        ref4.d1 = 10;
    }
}

class AAA {
    int a1;
    int a2;
    void testA() {

    }
}

// BBB Generalization to AAA
class BBB extends AAA {
    int b1;
    int b2;
}

class CCC extends AAA {
    int c1;
    int c2;
}

class DDD extends BBB {
    int d1;
    int d2;
}