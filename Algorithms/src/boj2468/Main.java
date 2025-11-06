package boj2468;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr;
    private static boolean[][] isVisited;
    private static int n;
    private static int[] moveR = {1, -1, 0, 0};
    private static int[] moveC = {0, 0, 1, -1};
    private static int height = 1;


    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        int maxHeight = 1;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > maxHeight) maxHeight = arr[i][j];
            }
        }

        int maxCount = 1;
        for(height = 1; height <= maxHeight; height++) {
            isVisited = new boolean[n][n];
            int count = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    count += bfs(i, j);
                }
            }
            if(count > maxCount) maxCount = count;
        }
        
        System.out.println(maxCount);
    }

    public static int bfs(int r, int c) {
        if(isVisited[r][c] || arr[r][c] <= height) return 0;

        int count = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        isVisited[r][c] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowR = now[0];
            int nowC = now[1];

            for(int i = 0; i < 4; i++) {
                int nextR = nowR + moveR[i];
                int nextC = nowC + moveC[i];
                
                if(nextR < 0 || nextC < 0 || nextR >= n || nextC >= n) continue;
                if(arr[nextR][nextC] <= height || isVisited[nextR][nextC]) continue;

                isVisited[nextR][nextC] = true;
                q.offer(new int[]{nextR, nextC});
            }
        }

        return count;
    }
}