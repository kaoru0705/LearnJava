package p3;

public class App {
    public static void main(String[] args) {
        // SOLID 원칙
        // 클래스 설계를 위하 5가지 원칙

        // SRP: 단일 책임 원칙
        // OCP: 개방 폐쇠 원칙 - 기능의 확장은 열려있고 수정에는 닫혀있어야 한다.
        // LSP: 리스코프 치환 원칙 - 주입 클래스가 바뀌었어도... 기대하는 결과는 같아야한다.
        // ISP: 인터페이스 분리 원칙 - 거대한 인터페이스 만들지 말고, 잘 쪼개라
        // DIP: 의존 역전 원칙 - 오전 내내 한 얘기
    }
}
interface Flyable {

}

interface Runnable {

}

class Duck implements Flyable, Runnable {

}