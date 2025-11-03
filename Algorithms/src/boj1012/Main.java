package boj1012;

import java.io.*;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr;
    private static boolean[][] isVisited;
    private static int n;
    private static int m;
    private static int k;
    private static int[] moveX = {1, -1, 0, 0};
    private static int[] moveY = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            
            arr = new int[n][m];
            isVisited = new boolean[n][m];

            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                arr[y][x] = 1;
            }

            for(int y = 0; y < n; y++) {
                for(int x = 0; x < n; x++) {
                    int count = 0;
                    if(!isVisited[y][x] && arr[y][x] == 1) {
                        count = bfs(y, x);
                    }
                    if(count != 0) {
                        System.out.println(count);
                    }
                }
            }
        }
    }

    public static int bfs(int startY, int startX) {
        Queue<int []> q = new ArrayDeque<>();
        q.offer(new int[]{startY, startX});
        int count = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curY = cur[0];
            int curX = cur[1];

            for(int i = 0; i < 4; i++) {
                int nextY = curY + moveY[i];
                int nextX = curX + moveX[i];

                if(nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) continue;
                if(isVisited[nextY][nextX] || arr[nextY][nextX] == 0) continue;

                q.offer(new int[]{nextY, nextX});
                isVisited[nextY][nextX] = true;
                count++;
            }
        }

        return count;
    }
}
