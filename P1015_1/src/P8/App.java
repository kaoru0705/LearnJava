package P8;

public class App {
    public static void main(String[] args) {
        Test t1 = new Test();
        t1.a = 10;
    }
}

// 접근 제한자 - 캡슐화, 정보의 은닉
class Test {
    // 일반적으로 public, priate을 쓴다.
    public int a;   // 어디서나 접근 가능
    private int d;  // 중요 같은 클래스 내에서만 접근 가능
    protected int b; // 같은 패키지 내부 혹은 다른 패키지의 자식클래스는 접근 가능
    int c; // 같은 패키지 내부에서만 가능

    public void qqqq() {
        a = 10;
        d = 10;
    }
    

}
