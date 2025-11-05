package boj11724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
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

        for(int i = 1; i <= n; i++) {
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
        for(int i = 1; i <= n; i++) {
            if(isVisited[i]) continue;
            if(list[i].isEmpty()) count++;
            count += dfs(i);
        }

        System.out.println(count);

    }

    private static int dfs(int i) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(i);

        while(!stack.isEmpty()) {
            int now = stack.pop();

            for(int e : list[now]) {
                if(isVisited[e]) continue;
                stack.push(e);
                isVisited[e] = true;
                count = 1;
            }
        }

        return count;
    }
}
