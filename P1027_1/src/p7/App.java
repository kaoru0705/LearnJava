package p7;

public class App {
    public static void main(String[] args) {
        // throw
        int result = 0;
        try {
                result = new SumCalculator().sum(75, 100);
                System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(result);
        System.out.println("프로그램 종료!!");
    }
}

class SumCalculator {
    public int sum(int a, int b){
        if(b > a) {
            // uncheckedException인 RuntimeException은 unchecked이기 때문에 try catch를 안 써도 된다.
            throw new RuntimeException("b는 a보다 클 수 없어");
        }

        int sum = 0;
        for(int i = a; i <= b; i++) {
            sum += i;
        }
        return sum;
    }
}