package P6;

public class App {
    public static void main(String[] args) {
        Car car1 = new Car();
        Person person1 = new Person();

        person1.setCar(car1);

        Person person2 = new Person();
        person2.setCar(car1);

    }
}

class Person {
    Eye leftEye = new Eye(); // composition
    Eye rightEye = new Eye();
    Car car; // aggregation

    // DI = Dependency Injection Code(생성자 주입)
    // Person(Car car) {
    //     this.car = car;
    // }

    // DI = 의존 주입 코드 (세터 주입)
    void setCar(Car car) {
        this.car = car;
    }
}

class Eye {

}

class Car {

}
