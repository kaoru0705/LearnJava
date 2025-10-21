package polymorphism.solution02;

public class AppleSpeaker implements Speaker {
    public void soundUp() {
        System.out.println("애플 스피커 소리를 키운다.");
    }
    public void soundDown() {
        System.out.println("애플 스피커 소리를 줄인다.");
    }
}
