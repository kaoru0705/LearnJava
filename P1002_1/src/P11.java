public class P11 {
    // 소수 판별 문제
    // 2 ~ 100 사이의 소수를 출력하세요.

    public static void main(String[] args) {
        for(int number = 2; number <= 100; number++) {
            boolean isPrime = true;
            for(int x = 2; x <= number / 2; x++) {
                if(number % x == 0) {
                    isPrime = false;

                }
            }
            if(isPrime) {
                System.out.print(number + " ");
            }
        }
    }
}