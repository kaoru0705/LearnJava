package polymorphism.solution;

public class User {

    public void watchTv() {
        System.out.println("사용자의 티비 시청 시작!!");
        // tv to SamsungTv, LgTv => Interface Realization 관계
        // 인터페이스를 통해 모듈 교체식으로 바꿨다.
        // 허나 User와 SamsungTv는 아직도 Dependency관계
        Tv tv = new SamsungTv();
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
        System.out.println("사용자의 티비 시청 끝!!");
    }
}