package book08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class App {

    private static boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] charArr = s.toCharArray();

        for(char c : charArr) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty() || stack.pop() == c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean answer = solution(st.nextToken());

        System.out.println(answer);
    }   
}
