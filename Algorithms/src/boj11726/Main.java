package boj11726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int firstE = 1;
        int secondE = 2;
        int targetE = 0;
        for(int i = 3; i <= n; i++) {
            targetE = (firstE + secondE) % 10007;
            firstE = secondE;
            secondE = targetE;
        }

        if(n <= 3)
            System.out.println(n);
        else System.out.println(targetE);

    }
}
