package p3;

public class App {
    // 익명 클래스 - 사실상 람다식으로 대체된 문법
    public static void main(String[] args) {
        AAA aaa = new AAA() {
            public void test() {
                System.out.println("하하하");
            }
        };
        aaa.test();
        AAA bbb = () -> System.out.println("푸하하");
        bbb.test();
    }
}

interface AAA {
    public void test();
}

class Some implements AAA {
    public void test() {
        System.out.println("야호!!!");
    }
}