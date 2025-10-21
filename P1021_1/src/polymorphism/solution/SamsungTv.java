package polymorphism.solution;

public class SamsungTv implements Tv{
    public void powerOn() {
        System.out.println("삼성 티비 전원을 켠다.");
    }
    public void powerOff() {
        System.out.println("삼성 티비 전원을 끈다.");
    }
    public void volumeUp() {
        System.out.println("삼성 티비 볼륨을 올린다.");
    }
    public void volumeDown() {
        System.out.println("삼성 티비 볼륨을 내린다.");
    }
}
