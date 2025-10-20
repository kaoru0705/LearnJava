package p8;

public class App {
    public static void main(String[] args) {
        // 다형성 polymorphism
        // 특정 타입의 변수는 특정타입을 상속받는 모든 형태의 타입을 변수로 받을 수 있다.
        AAA a1 = new BBB(); // AAA타입이지만 BBB의 인스턴스 Upcasting
        a1.test();
        // a1.b1 = 10; // compile error 자손의 기능을 사용 못 함

        // instanceof opeartor
        if(a1 instanceof BBB) {
            BBB tempB = (BBB)a1; // 캐스팅 가능. 상속 관계일 경우에만 Downcasting
            tempB.test();
        }


    
        
    }
}

class AAA {
    int a1;
    int a2;

    void test() {
        System.out.println("AAA");
    }
}

class BBB extends AAA {
    int b1;
    int b2;

    void test() {
        System.out.println("BBB");
    }
}