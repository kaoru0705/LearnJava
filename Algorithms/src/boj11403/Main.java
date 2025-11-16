package boj11403;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Integer>[] list;
    private static int[][]graph;
    private static int size;

    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        size = Integer.parseInt(br.readLine());

        graph = new int[size][size];
        list = new ArrayList[size];
        for(int i = 0; i < size; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < size; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    list[i].add(j);
                }
            }
        }

        for(int i = 0; i < size; i++) {
            bfs(i);
        }

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.print(graph[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void bfs(int listIndex) {
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(listIndex);
        boolean[] isVisited = new boolean[size];

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int e : list[cur]) {
                if(isVisited[e]) continue;
                isVisited[e] = true;
                q.offer(e);
                graph[listIndex][e] = 1;
            }
        }
    }
}
