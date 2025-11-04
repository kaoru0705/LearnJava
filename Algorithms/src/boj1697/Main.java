package boj1697;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isVisited = new boolean[100001];
    static int n;
    static int k;

    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());

        if(n == k) {
            System.out.println(0);
            return;
        }

        dfs(n);
    }

    private static void dfs(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);
        isVisited[n] = true;

        int count = 0;

        while(!q.isEmpty()) {
            count++;
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                int position = q.poll();
                if(position - 1 == k || position + 1 == k || position * 2 == k) {
                    System.out.println(count);
                    return;
                }
                if(position - 1 >= 0 && !isVisited[position - 1]) {
                    q.offer(position - 1);
                    isVisited[position - 1] = true;
                }
                if(position + 1 <= 100000 && !isVisited[position + 1]) {
                    q.offer(position + 1);
                    isVisited[position + 1] = true;
                }
                if(position * 2 <= 100000 && !isVisited[position * 2]) {
                    q.offer(position * 2);
                    isVisited[position * 2] = true;
                }
            }

        }
    }
}
