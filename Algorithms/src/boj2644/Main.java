package boj2644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Integer>[] relativeList;
    private static boolean[] isVisited;
    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nCount = Integer.parseInt(st.nextToken());
        relativeList = new ArrayList[nCount + 1];
        isVisited = new boolean[nCount + 1];

        for(int i = 1; i < nCount + 1; i++) {
            relativeList[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int targetN1 = Integer.parseInt(st.nextToken());
        int targetN2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            relativeList[n1].add(n2);
            relativeList[n2].add(n1);
        }

        int eCount = bfs(targetN1, targetN2);
        System.out.println(eCount);
    }

    private static int bfs(int targetN1, int targetN2) {
        int eCount = 0;
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(targetN1);
        isVisited[targetN1] = true;
        while(!q.isEmpty()) {
            int curN = q.poll();
            for(int n : relativeList[curN]) {
                if(isVisited[n]) continue;
                q.offer(n);
                isVisited[n] = true;
                if(n == targetN2) {
                    eCount++;
                    return eCount;
                }
            }
            eCount++;
        }

        return -1;
    }
}
