package boj11724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class App {
    private static int n;
    private static int m;
    private static boolean[] isVisited;
    private static ArrayList<Integer>[] list;


    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        isVisited = new boolean[n + 1];
        list = new ArrayList[n + 1];

        for(int i = 1; i <= m; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        int count = 0;
        for(int i = 1; i < n; i++) {
            if(list[i].isEmpty() || isVisited[i]) continue;
            dfs(i);
        }

    }

    private static int dfs(int start) {
        int count = 0;
        Stack<Integer> s = new Stack<>();
        s.push(start);

        while(!s.isEmpty()) {
            
        }

        return count;
    }
}
