package boj1463;

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
        int arr[] = new int[n + 1];
        Arrays.fill(arr, 1000000);
        arr[1] = 0;
        if(n >= 2) arr[2] = 1;
        if(n >= 3) arr[3] = 1;

        for(int i = 4; i <= n; i++){
            int indexDiv2 = (i % 2 == 0) ? arr[i / 2] : 1000000;
            int indexDiv3 = (i % 3 == 0) ? arr[i / 3] : 1000000;
            int indexMinus1 = arr[i - 1];

            arr[i] = min(indexDiv2, indexDiv3, indexMinus1) + 1;
        }

        System.out.println(arr[n]);
    }

    public static int min(int c1, int c2, int c3) {
        int result = Math.min(c1, c2);
        result = Math.min(result, c3);
        return result;
    }
}
