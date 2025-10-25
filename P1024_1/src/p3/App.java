package p3;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        // int value = (int)(Math.random() * 100) + 1;
        // seed가 같으면 같은 값 같은 패턴의 값이다.
        Random random = new Random(1000);

        // 0 ~ 1 사이에 0.5가 가장 많이 나오는 메서드
        random.nextGaussian();

        int value = random.nextInt(100) + 1;

        System.out.println(value);


    }
}
