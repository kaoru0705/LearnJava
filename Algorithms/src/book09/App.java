package book09;

import java.util.ArrayDeque;

public class App {
    private static String solution(int decimal) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        while(decimal > 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();


    }
    public static void main(String[] args) {
        solution(12345);
    }
}
