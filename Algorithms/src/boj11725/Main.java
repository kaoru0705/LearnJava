package boj11725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList <Integer>[] list;
    private static boolean[] isVisited;
    private static int[] parent;
    
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        isVisited = new boolean[n+1];
        parent = new int[n+1];

        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }

        bfs(1);

        for(int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        isVisited[start] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int e: list[cur]) {
                if(!isVisited[e]) {
                    isVisited[e] = true;
                    q.offer(e);
                    parent[e] = cur;
                }
            }
        }
    }
}