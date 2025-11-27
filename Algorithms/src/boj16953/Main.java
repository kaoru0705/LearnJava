package boj16953;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int routeCount = bfs(start, end);
    }

    private static int bfs(int start, int end) {
        int routeCount = 0;
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(start);
        while(!q.isEmpty()) {
            routeCount++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int position = q.poll();
                int twicePosition = position * 2;
                int addOnePosition = position * 10 + 1;
                if(addOnePosition == end || twicePosition == end) {
                    return routeCount;
                }
                if(twicePosition < end) {
                    q.offer(twicePosition);
                }
                if(addOnePosition < end) {
                    q.offer(addOnePosition);
                }
            }
        }

        return routeCount;
    }
}
