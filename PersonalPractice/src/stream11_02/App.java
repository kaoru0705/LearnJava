package stream11_02;

import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        System.out.println(IntStream.rangeClosed(1, 100).sum());
        System.out.println(IntStream.rangeClosed(1, 100).average().getAsDouble());
        System.out.println(IntStream.rangeClosed(1, 100).min().getAsInt());
        System.out.println(IntStream.rangeClosed(1, 100).max().getAsInt());
    }
}