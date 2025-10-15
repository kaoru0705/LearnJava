package P6;

public class App {
    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = new Test();
        t1.a = 10;
        t2.a = 20;

        System.out.println(Test.c);
        System.out.println(Test.c);
    }
}

class Test {
    int a;
    int b;
    // 인스턴스 생성과 상관없이 존재한다. 메모리 소멸 안됨 class를 unload하면 가능
    static int c = 32; // 클래스 변수


}

class Ex {
    void qqqq() {
        System.out.println(Test.c);
    }
}