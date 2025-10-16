package P5;

public class App {
    public static void main(String[] args) {
        Test t1 = new Test();

    }
}

class Test {
    private static int a;
    private int b;

    public void test1(AAA a) {

    }
    private static void test2() {};
}

class AAA {
    BBB b = new BBB(); // composition - lifecycle이 같음
    CCC c;  // aggregation - lifecycle이 다름

    public void aaa() {
        BBB b = new BBB();
    }
}

class BBB {

}

class CCC {

}