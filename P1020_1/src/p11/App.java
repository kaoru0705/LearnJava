package p11;

public class App {
    public static void main(String[] args) {
        // interface - 추상화의 끝!
        AAA aaa = new QWER();
        aaa.foo();
        aaa.test();

        System.out.println(AAA.SOME_VALUE);
        AAA.qqqqq();
    }
}

interface AAA {
    // 추상 메소드만 선언할 수 있다.
    // 무조건 public abstract test();
    // public test(); // 대부분 public은 붙인다.
    void test();
    void foo();

    // public static final int SOME_VALUE = 10;
    int SOME_VALUE = 10;
    // static은 구현해야 됨
    public static void qqqqq() {
        System.out.println("EEEE");
    }
    
    default void yyyy() {
        System.out.println("FFFF");
    }
}

class QWER implements AAA {
    @Override
    public void test() {
        System.out.println("시험");
    }
    @Override
    public void foo() {
        System.out.println("foo");
    }
}

