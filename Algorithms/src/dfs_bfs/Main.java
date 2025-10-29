package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isVisited;
    static ArrayList<Integer>[] lists;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

        int v, e, start;
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        isVisited = new boolean[v + 1];
        lists = new ArrayList[v + 1];

        for(int i = 1; i <= v; i++) {
            lists[i] = new ArrayList<>();
        }

        for(int i = 1; i <= e; i++) {
            st = new StringTokenizer(bf.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            lists[v1].add(v2);
            lists[v2].add(v1);
        }

        // 정렬
        for(int i = 1; i <= v; i++) lists[i].sort((a, b) -> a - b);

        dfs(start);
        System.out.println();

        isVisited = new boolean[v + 1];
        // dfs1(start);
        bfs(start);
    }

    public static void dfs(int visit) {
        if(isVisited[visit]) return;

        isVisited[visit] = true;
        System.out.print(visit + " ");
        for(Integer next : lists[visit]) {
            dfs(next);
        }
    }

    public static void bfs(int visit) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(visit);
        isVisited[visit] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");

            for(Integer next : lists[cur]) {
                if(!isVisited[next]) {
                    q.offer(next);
                    isVisited[next] = true;
                }
            }
        }
    }

    // 아무래도 stack이므로 나중값을 먼저 깊이 탐색할 것이다.
    // 따라서 재귀로 구한 것과는 순서가 다르다.
    // public static void dfs1(int visit) {
    //     Stack<Integer> stack = new Stack<>();

    //     stack.push(visit);

    //     while(!stack.isEmpty()) {
    //         int cur = stack.pop();
            
    //         if(!isVisited[cur]) {
    //             System.out.print(cur + " ");
    //             isVisited[cur] = true;
    //         }

    //         for(Integer next : lists[cur]) {
    //             if(!isVisited[next]) {
    //                 stack.push(next);
    //             }
    //         }
    //     }
    // }
}