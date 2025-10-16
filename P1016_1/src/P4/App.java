package P4;

public class App {
    public static void main(String[] args) {
        SomeComponent sc = SomeComponent.getInstance();

        sc.func();
    }
}
// Component = 기능 위주의 클래스... 대부분의 경우 한번만 생성... 재활용

// 싱글톤
// 한번만 객체 생성
// Dto, Vo = 데이터 구조의 클래스... 많이 자주 생성됨
// Math, System 클래스 등은 전부 스테틱이라 생성자를 private으로 해서 인스턴스 생성을 못 하게 막았다.
class SomeComponent{
    // 싱글톤 패턴 코드 생성패턴
    // private static SomeComponent instance = null;
    // public static SomeComponent getInstance() {
    //     if(instance == null) {
    //         instance = new SomeComponent();
    //     }
    //     return instance;
    // }
    // private SomeComponent() {}
    private static final SomeComponent instance = new SomeComponent();
    public static SomeComponent getInstance() {
        return instance;
    }
    private SomeComponent() {}


    // 실제 기능
    public void func() {
        System.out.println("기능이 실행됩니다.");
    }
    
}
