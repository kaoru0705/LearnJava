package p11;

import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        // 1부터 100까지의 수 중 3의 배수는 제외하고 합을 구해보자
        int arr[] = IntStream.rangeClosed(1, 100)
            .filter(x -> x % 3 != 0)
            .toArray();
        for(int a: arr) {
            System.out.println(a);
        }

        // 가독성은 좋지만 성능은 그냥 for문이랑 비교해봐야 된다.
        double sum = IntStream.rangeClosed(1, 100)
            .filter(x -> x%3!=0)
            .sum();

    }
}
