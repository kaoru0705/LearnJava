import java.util.Scanner;
public class P1 {
    public static void main(String[] args) {
        // 배열
        // 실질적으로는 컬렉션을 쓰기 때문에 잘 쓰지 않는다.

        // Stack memory에 저장되는 데이터는 초기화가 안된다.
        // int a;
        // System.out.println(a);

        // Heap에 저장되는 데이터는 정수면 0, 소수는 0.0 boolean은 false등 최대한 부정적인 값으로 초기화된다.
        int[] scores = new int[10];

        scores[0] = 77;
        scores[5] = 99;

        System.out.println(scores[3]);
        System.out.println(scores[5]);

        // Runtime Error Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 11 out of bounds for length 10
        // System.out.println(scores[11]);

    }
}