package boj9095;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        List<Integer> nList = new ArrayList<>();
        // arr-3 + arr-2 + arr-1 = arr
        int[] arr = new int[11];

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for(int i = 4; i <= 10; i++) {
            arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
        }

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            nList.add(n);
        }

        for(int n : nList) {
            System.out.println(arr[n]);
        }
        
    }
}
