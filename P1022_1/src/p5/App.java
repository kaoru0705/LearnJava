package p5;

public class App {
    public static void main(String[] args) {
        BBB bbb = new Some();
        bbb.test(3);
        BBB bbb2 = (a) -> System.out.println(a);
        bbb2.test(5);
        
        // Method Reference
        //이건 “System.out 객체의 println 메서드를 BBB의 test(int)와 연결해라”라는 뜻이에요.
        BBB bbb3 = System.out::println;
        bbb3.test(7);
    }
}

interface BBB {
    public void test(int a);
}

class Some implements BBB {
    public void test(int a) {
        System.out.println(a);
    }
}
