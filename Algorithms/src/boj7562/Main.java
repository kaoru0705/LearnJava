package boj7562;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static boolean[][] isVisited;
    private static int[][] chess;
    private static int i;
    private static int chessSize;
    private static int[] moveR = {2, 1, 2, 1, -2, -1, -2, -1};
    private static int[] moveC = {1, 2, -1, -2, 1, 2, -1, -2};


    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int caseCount = Integer.parseInt(br.readLine());

        List<Integer> countList = new ArrayList<>();
        for(int i = 0; i < caseCount; i++) {
            chessSize = Integer.parseInt(br.readLine());
            chess = new int[chessSize][chessSize];
            isVisited = new boolean[chessSize][chessSize];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] startPositon = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};

            st = new StringTokenizer(br.readLine());
            int[] endPosition = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};

            countList.add(bfs(startPositon, endPosition));
        }
        
        for(int count: countList) {
            System.out.println(count);
        }

    }

    private static int bfs(int[] startPosition, int[] endPosition) {
        if(startPosition[0] == endPosition[0] && startPosition[1] == endPosition[1]) return 0;
        int count = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(startPosition);
        isVisited[startPosition[0]][startPosition[1]] = true;

        while(!q.isEmpty()) {
            count++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int curR = cur[0];
                int curC = cur[1];

                for(int moveIndex = 0; moveIndex < 8; moveIndex++) {
                    int nextR = curR + moveR[moveIndex];
                    int nextC = curC + moveC[moveIndex];

                    if(nextR == endPosition[0] && nextC == endPosition[1]) return count;
                    if(nextR < 0 || nextC < 0 || nextR >= chessSize || nextC >= chessSize) continue;
                    if(isVisited[nextR][nextC]) continue;

                    q.offer(new int[]{nextR, nextC});
                    isVisited[nextR][nextC] = true;
                }
            }
            

        }


        return count;
    }
}
