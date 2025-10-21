package polymorphism.solution02;

public class SonySpeaker implements Speaker{
    public void soundUp() {
        System.out.println("소니 스피커 소리를 키운다.");
    }
    public void soundDown() {
        System.out.println("소니 스피커 소리를 줄인다.");
    }
}
