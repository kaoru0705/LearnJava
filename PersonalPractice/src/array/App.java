package array;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        int[] arr = new int[100_000_000];

        for(int i = 0; i < 100_000_000; i++) {
            arr[i] = (int)(Math.random() * 1000) + 1;
        }

        int max = Arrays.stream(arr).min().getAsInt();

        System.out.println(max);

    }
}
