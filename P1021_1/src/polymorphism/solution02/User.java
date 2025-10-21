package polymorphism.solution02;

public class User {
    private Tv tv;

    // 생성자 주입 혹은 세터 주입 일반적으로 둘 중 하나만 사용
    // DI 의존 주입(생성자 주입) 가능하게 하는 코드
    public User(Tv tv) {
        this.tv = tv;
    }

    // // DI 의존 주입(세터 주입) 가능하게 하는 코드
    // public void setTv(Tv tv) {
    //     this.tv = tv;
    // }

    public void watchTv() {
        System.out.println("사용자의 티비 시청 시작!!");

        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
        System.out.println("사용자의 티비 시청 끝!!");
    }
    // Dependency Injection parameter로 의존 주입
    // public void watchTv(Tv tv) {
    //     System.out.println("사용자의 티비 시청 시작!!");

    //     tv.powerOn();
    //     tv.volumeUp();
    //     tv.volumeDown();
    //     tv.powerOff();
    //     System.out.println("사용자의 티비 시청 끝!!");
    // }
}