package boj2583;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int M;
    private static int N;
    private static int K;
    private static int[][] arr;
    private static boolean[][] isVisited;
    private static int[] moveY = {0, 0, 1, -1};
    private static int[] moveX = {1, -1, 0, 0};


    public static void main(String[] args) throws Exception{
        List<Integer> sectionList = new ArrayList<>();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        isVisited = new boolean[M][N];

        for(int i = 0 ; i < K ; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            for(int y = startY; y < endY; y++) {
                for(int x = startX; x < endX; x++) {
                    arr[y][x] = 1;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                int sectionSize = bfs(i, j);
                if(sectionSize > 0) {
                    count++;
                    sectionList.add(sectionSize);
                }
            }
        }

        sectionList.sort((a, b) -> a - b);
        System.out.println(count);
        sectionList.forEach((sectionSize) -> System.out.print(sectionSize + " "));
    }

    private static int bfs(int y, int x) {
        if(isVisited[y][x] || arr[y][x] == 1) return 0;
        int sectionSize = 1;
        isVisited[y][x] = true;
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{y, x});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curY = cur[0];
            int curX = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int nextY = curY + moveY[i];
                int nextX = curX + moveX[i];
                
                if(nextY < 0 || nextY >= M || nextX < 0 || nextX >= N) continue;
                if(isVisited[nextY][nextX] || arr[nextY][nextX] == 1) continue;
                
                q.offer(new int[]{nextY, nextX});
                isVisited[nextY][nextX] = true;
                sectionSize++;
            }
        }

        return sectionSize;
    }
}
