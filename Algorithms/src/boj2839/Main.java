package boj2839;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        Arrays.fill(arr, 5000);

        if(n >= 3) arr[3] = 1;

        if(n >= 5) arr[5] = 1;


        for(int i = 6; i <= n; i++) {
            arr[i] = Math.min(arr[i - 5], arr[i - 3]) + 1;
        }

        if(arr[n] >= 5000) {
            System.out.println(-1);
        }else {
            System.out.println(arr[n]);
        }
    }
}
