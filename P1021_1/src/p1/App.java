package p1;

public class App {
    public static void main(String[] args) throws Exception {
        // Walkable에 의존하면 하위 클래스로 교체하기 쉽다.
        // 그러나 Duck 같은 다중 구현은 Duck에 의존할 수밖에 없다.
        Walkable walker = new Person();
        walker.walk();
        Duck duck = new Duck();
        duck.walk();
        duck.fly();
    }
}

interface Flyable {
    public void fly();
}

interface Walkable {
    public void walk();
}

class Person implements Walkable {
    public void walk() {
        System.out.println("사람의 로직으로 걷습니다.");
    }
}

class Duck implements Flyable, Walkable {
    public void fly() {
        System.out.println("오리는 로직으로 날아갑니다.");
    }
    public void walk() {
        System.out.println("오리는 로직으로 걷습니다.");
    }
}