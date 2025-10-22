package stream11_28;
// 최종처리를 하는 종료연산에는 1. counting 2. matching 3. collecting이 있다.
// 1. counting
// max(), min(), average()는 Optional class의 객체로 리턴하기 때문에 getAsInt() getAsDouble() getAsLong() 메소드를 사용해야 한다.ㅈ
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        long count = Arrays.stream(intArray)
                            .filter(n -> n % 2 == 0)
                            .count();
        System.out.println("2의 배수의 개수 : " + count);

        long sum = Arrays.stream(intArray)
                            .filter(n -> n % 2 == 0)
                            .sum();
        System.out.println("2의 배수의 합 : " + sum);
        long max = Arrays.stream(intArray)
                            .max()
                            .getAsInt();
        System.out.println("최대값 : " + max);
        long min = Arrays.stream(intArray)
                            .min()
                            .getAsInt();
        System.out.println("최소값 : " + min);
        double avg = Arrays.stream(intArray)
                            .average()
                            .getAsDouble();
        System.out.println("2의 배수의 합 : " + avg);
    }
}
