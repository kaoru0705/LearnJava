package stream11_29;

import java.util.*;
// Matching
// nonMatch는 모두 만족하지 못하면 true
public class App {
    public static void main(String[] args) {
        int[] intArray = {1, 1, 1};
        boolean result = false;

        result = Arrays.stream(intArray)
                        .anyMatch(n -> n%2 == 0);
        System.out.println("적어도 하나는 2의 배수인가? " + result);

        result = Arrays.stream(intArray)
                        .allMatch(n -> n%2 == 0);
        System.out.println("모두 2의 배수인가? " + result);

        result = Arrays.stream(intArray)
                        .noneMatch(n -> n%2 == 0);
        System.out.println("모두 2의 배수가 아닌가? " + result);
    }
}
