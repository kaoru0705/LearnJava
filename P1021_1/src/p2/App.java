package p2;

public class App {
    public static void main(String[] args) {
        // 자바문법의 interface = 클래스 간에 상호작용하기 위한 표준 정의
        
        // 입출력 담당... 코드
        // 입출력 담당과 클래스 만드는 담당이 따로라면?
        // 여태까지는 클래스를 만들고 그걸로 호출했다. 하지만 동시에 개발하고 구현 담당이 구현하는 데 시간이 오래 걸린다면?
        // 입출력 담당이 자기 할일을 끝내려면 모조(CalculatorMock)로 구현하고 임시로 사용한다.
        // 구현 담당이 완료하면 모듈을 교체하면 된다.
        int valueA = 40;
        int valueB = 70;
        Calculator calculator = new CalculatorMock();
        int result = calculator.sum(valueA, valueB);
        System.out.println(result);

    }
}

interface Calculator {
    public int sum(int a, int b);
}

class CalculatorMock implements Calculator {
    public int sum(int a, int b) {
        return 70;
    }
}

// Impl 많이 쓰는 표현 - 특정 인터페이스를 구현한 클래스
class CalculatorImpl implements Calculator {
    public int sum(int a, int b) {
        int sum = 0;
        for(int i = a ; i <= b; i++) {
            sum += i;
        }
        return sum;
    }
}