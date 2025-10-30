package boj2667;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static int[][] array;
    private static boolean[][] isVisited;
    private static int n;
    private static int[] moveX = {1, -1, 0, 0};
    private static int[] moveY = {0, 0, 1, -1};


    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        n = Integer.parseInt(br.readLine());

        array = new int[n][n];
        isVisited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                array[i][j] = str.charAt(j) - '0';
            }
        }

        List<Integer> countList = new ArrayList<>();
        int totalCount = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int count = bfs(i, j);
                if(count != 0) {
                    totalCount++;
                    countList.add(count);
                }
            }
        }
        countList.sort((a, b) -> a - b);

    }

    public static int bfs(int x, int y) {
        if(isVisited[x][y] || array[x][y] == 0) return 0;
        int count = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x , y});
        isVisited[x][y] = true;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++) {
                int nextX = nowX + moveX[i];
                int nextY = nowY + moveY[i];
                
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
                if(array[nextX][nextY] == 0 || isVisited[nextX][nextY]) continue;

                isVisited[nextX][nextY] = true;
                q.offer(new int[]{nextX, nextY});
                count++;
            }
        }


        return count;
    }
}
