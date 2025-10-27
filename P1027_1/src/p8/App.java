package p8;

public class App {
    public static void main(String[] args) {
        // Integer.parseInt(String s, int radix) radix는 진수
        Integer.parseInt("10", 16);
    }
}

class Test {
    public void test() {
        try {
            new SumCalculator().sum(0, 19);
        } catch (SumCalculatorException e) {

        }
    }
}
class SumCalculator {
    public int sum(int a, int b) throws SumCalculatorException {
        if(b < a) {
            // checked Exception은 try catch를 사용하지 않으면 에러다. 허나 method 뒤에 throws SumCalculatorException 이걸 붙이면 호출한 쪽으로 넘길 수 있다.
            // file system, network, database는 checked라 무조건 try catch를 써줘야 한다.
            throw new SumCalculatorException();
        }
        int sum = 0;
        for(int i = a; i <= b; i++) {
            sum += i;
        }
        return sum;
    }
}

class SumCalculatorException extends Exception {}