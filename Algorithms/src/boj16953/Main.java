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
        System.out.println(routeCount);
    }

    private static int bfs(int start, int end) {
        int routeCount = 1;
        Queue<Long> q = new ArrayDeque<>();

        q.offer((long)start);
        while(!q.isEmpty()) {
            routeCount++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                long position = q.poll();
                long twicePosition = position * 2;
                long appendOnePosition = position * 10 + 1;

                if(appendOnePosition == end || twicePosition == end) {
                    return routeCount;
                }
                if(twicePosition < end) {
                    q.offer(twicePosition);
                }
                if(appendOnePosition < end) {
                    q.offer(appendOnePosition);
                }
            }
        }

        return -1;
    }
}
