package polymorphism.solution;

public class User {

    public void watchTv() {
        System.out.println("사용자의 티비 시청 시작!!");
        Tv tv = new SamsungTv();
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
        System.out.println("사용자의 티비 시청 끝!!");
    }
}