package boj1003;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int countZero;
    private static int countOne;
    public static void main(String[] args) throws Exception{
        int[][] arr = new int[41][2];
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        List<Integer> list = new ArrayList<>();
        int t = Integer.parseInt(st.nextToken());

        arr[0][0] = 1;
        arr[1][1] = 1;

        for(int i = 2; i <= 40; i++) {
            arr[i][0] = arr[i-2][0] + arr[i-1][0];
            arr[i][1] = arr[i-2][1] + arr[i-1][1];
        }

        for(int i = 1; i <= t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            list.add(n);
        }

        for(int i : list){
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
        
    }
}
