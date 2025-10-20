package p10;

public class App {
    public static void main(String[] args) {
        // 유닛은
        // 탱크(강력하고 비싼), SCV(전투에 능하지 않음), 마린(싸지만 빠르게 이동, 빠른 공격)이 존재한다.
        // 모든 유닛은 이동, 공격, 멈추기 기능이 있다.
        // 각 유닛은 자신만의 이동 알고리즘이 있고, 공격 알고리즘이 있다.
        // 유닛의 종류와 상관없이 6개의 유닛을 부대지정해서 한 번에 이동, 공격, 멈출 수 있다.
        Unit[] unitList = new Unit[6];
        unitList[0] = new Tank();
        unitList[1] = new Marine();
        unitList[2] = new SCV();
        unitList[3] = new Marine();
        unitList[4] = new Tank();
        unitList[5] = new SCV();

        // 아래가 핵심... 상속 - 다형성 - 오버라이딩
        // Runtime 시점에서 forEach문으로 분기된다. 
        for(Unit unit: unitList) {
            unit.move();
            unit.attack();
            unit.stop();
            System.out.println();
        }

    }
}

// abstract 추상 클래스, 상속만을 위한 정의
// 인스턴스 생성 불가능
abstract class Unit {
    int hp;
    int ap;
    int speed;
    
    abstract void move();
    abstract void attack();

    // 오버라이딩 불가능
    final void stop() {
        System.out.println("유닛의 로직으로 멈춥니다.");
    }
}

class Tank extends Unit{
    Tank() {
        hp = 100;
        ap = 20;
        speed = 10;
    }

    void move() {
        System.out.println("탱크만의 로직으로 " + speed + "만큼 이동합니다.");
    }
    void attack() {
        System.out.println("탱크만의 로직으로 " + ap + "만큼 공격합니다.");
    }
}

class Marine extends Unit{
    Marine() {
        hp = 50;
        ap = 5;
        speed = 5;
    }
    void move() {
        System.out.println("마린만의 로직으로 " + speed + "만큼 이동합니다.");
    }
    void attack() {
        System.out.println("마린만의 로직으로 " + ap + "만큼 공격합니다.");
    }
}

class SCV extends Unit{
    SCV() {
        hp = 30;
        ap = 1;
        speed = 1;
    }
    void move() {
        System.out.println("SCV만의 로직으로 " + speed + "만큼 이동합니다.");
    }
    void attack() {
        System.out.println("SCV만의 로직으로 " + ap + "만큼 공격합니다.");
    }
}