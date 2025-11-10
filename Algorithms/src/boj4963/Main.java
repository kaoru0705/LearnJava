package boj4963;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int w;
    private static int h;
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int[] moveR = {1, -1, 1, 1, -1, -1, 0, 0};
    private static int[] moveC = {0, 0, 1, -1, 1, -1, 1, -1};


    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        List<Integer> countList = new ArrayList<>();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;

            map = new int[h][w];
            isVisited = new boolean[h][w];

            for(int r = 0; r < h; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < w; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            for(int r = 0; r < h; r++) {
                for(int c = 0; c < w; c++) {
                    count += bfs(r, c);
                }
            }

            countList.add(count);

        }

        for(int count : countList) {
            System.out.println(count);
        }
    }

    private static int bfs(int r, int c) {
        if(map[r][c] == 0 || isVisited[r][c]) return 0;
        int count = 1;
        isVisited[r][c] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];

            for(int i = 0; i < 8; i++) {
                int nextR = curR + moveR[i];
                int nextC = curC + moveC[i];

                if(nextR < 0 || nextC < 0 || nextR >= h || nextC >= w ) continue;
                if(isVisited[nextR][nextC] || map[nextR][nextC] == 0) continue;

                isVisited[nextR][nextC] = true;
                count = 1;
                q.offer(new int[]{nextR, nextC});
            }
        }

        return count;
    }
}
