package polymorphism.solution02;

public class LgTv implements Tv{
    private Speaker speaker;

    public LgTv(Speaker speaker) {
        this.speaker = speaker;
    }

    public void powerOn() {
        System.out.println("엘지 티비 전원을 켠다.");
    }
    public void powerOff() {
        System.out.println("엘지 티비 전원을 끈다.");
    }
    public void volumeUp() {
        speaker.soundUp();
    }
    public void volumeDown() {
        speaker.soundDown();
    }
}
