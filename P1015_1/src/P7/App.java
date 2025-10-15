package P7;

public class App {
    public static void main(String[] args) {
        Test.qqqq();
    }
}

class Test {
    int c;
    static int a;
    static int b;
    // 웬만하면 static을 사용하지 마라. 메모리관리 주의할 필요 있다.
    static void qqqq() {
        System.out.println("qqqq");
    }
}
