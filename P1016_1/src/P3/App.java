package P3;

public class App {
    public static void main(String[] args) {
        // 클래스 설계 원칙
        // 캡슐화(정보의 은닉), 응집도를 높인다.
        
        // SOLID
        // SRP - Single Responsibility Principle 단일 책임 원칙
        // 하나의 클래스는 하나의 역할만 해야하고, 하나의 메소드는 하나의 기능만 해야 된다.
        // 하나의 메서드는 3줄 이상이면 의심해야 한다. - 현실적으로는 그렇지만 의심해라.

        SumCalculator s = new SumCalculator();
        s.showResult(2, 8);

        
    }
}

class SumCalculator {

    public void showResult(int start, int end) {
        int result = calculate(start , end);
        printResult(result);
    }

    private void printResult(int result) {
        System.out.println("결과: " + result);
    }

    private int calculate(int start, int end) {
        int sum = 0;
        for(int i = start; i <= end; i++) {
            // boolean isMultipleOfThree = i%3==0;
            if(!isMultipleOfThree(i)) {
                sum = accumulate(sum, i);
            }
        }
        return sum;
    }

    private int accumulate(int sum, int i) {
        return sum += i;
    }

    private boolean isMultipleOfThree(int num) {
        return num%3 == 0;
    }
}