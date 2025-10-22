package stream11_04;
import java.util.stream.*;
import java.util.Arrays;
// util.stream은 입출력 스트림과는 다른 것으로 내부 반복을 지원한다.

public class App {
    public static void main(String[] args) {
        People[] peoArray = new People[3];
        peoArray[0] = new People();
        peoArray[0].name = "홍길동";
        peoArray[0].age = 30;
        peoArray[1] = new People();
        peoArray[1].name = "이순신";
        peoArray[1].age = 40;
        peoArray[2] = new People();
        peoArray[2].name = "김유신";
        peoArray[2].age = 50;

        Stream<People> peoStream = Arrays.stream(peoArray);
        peoStream.forEach(e -> System.out.println("name : " + e.name + ", age : " + e.age));

    }
}

class People {
    String name;
    int age;
}
