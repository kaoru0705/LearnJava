package dfsbfs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class App {
    static boolean[] visited;
    static ArrayList<Integer>[] lists;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int v, e, start;
        v = Integer.parseInt(scanner.next());
        e = Integer.parseInt(scanner.next());
        start = Integer.parseInt(scanner.next());
        scanner.nextLine();

        visited = new boolean[v + 1];
        lists = new ArrayList[v + 1];

        for(int i = 1; i <= v; i++) {
            lists[i] = new ArrayList<>();
        }

        for(int i = 1; i <= e; i++) {
            int v1 = Integer.parseInt(scanner.next());
            int v2 = Integer.parseInt(scanner.next());
            scanner.nextLine();

            lists[v1].add(v2);
            lists[v2].add(v1);
            lists[v1].sort((a, b) -> a - b);
            lists[v2].sort((a, b) -> a - b);
        }

        dfs(start);
        System.out.println();

        visited = new boolean[v + 1];
        // dfs1(start);
        bfs(start);
    }

    public static void dfs(int visit) {
        if(visited[visit]) return;

        visited[visit] = true;
        System.out.print(visit + " ");
        for(Integer value : lists[visit]) {
            dfs(value);
        }
    }

    public static void bfs(int visit) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(visit);

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(!visited[cur]) {
                visited[cur] = true;
                System.out.print(cur + " ");
            }

            for(Integer value : lists[cur]) {
                if(!visited[value]) {
                    q.offer(value);
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
            
    //         if(!visited[cur]) {
    //             System.out.print(cur + " ");
    //         }
    //         visited[cur] = true;

    //         for(Integer value : lists[cur]) {
    //             if(!visited[value]) {
    //                 stack.push(value);
    //             }
    //         }
    //     }
    // }
}