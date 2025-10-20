package p9;

public class App {
    public static void main(String[] args) {
        AAA aaa = new BBB();
        aaa.test();
    }
}

class AAA {
    void test() {
        System.out.println("AAA의 test 호출됨");
    }
}

class BBB extends AAA {
    // 오버라이딩 - 메서드 재정의 ... 상속받은 메서드의 형태 그대로 정의
    void test() {
        System.out.println("AAA의 test 호출됨");
    }
}