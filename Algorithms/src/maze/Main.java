package maze;

import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// 최단 거리는 BFS가 효율적 DFS는 너무 깊이 들어간다.
public class Main {
    private static int[][] maze;
    private static boolean[][] isVisited;
    private static int n;
    private static int m;
    private static int[] moveR = {1, -1, 0, 0};
    private static int[] moveC = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        isVisited = new boolean[n][m];

        for(int r = 0; r < n; r++) {
            String s = br.readLine();

            for(int c = 0; c < m; c++) {
                maze[r][c] = s.charAt(c) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(maze[n-1][m-1]);
    }

    public static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{r, c});
        isVisited[r][c] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];

            for(int i = 0; i < 4; i++) {
                int nextR = curR + moveR[i];
                int nextC = curC + moveC[i];

                if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) continue;
                if(isVisited[nextR][nextC] || maze[nextR][nextC] == 0) continue;

                isVisited[nextR][nextC] = true;
                maze[nextR][nextC] = maze[curR][curC] + 1;

                q.offer(new int[]{nextR, nextC});
            }
        }
    }
}
