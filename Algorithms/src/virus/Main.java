package virus;

import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.*;

public class Main {
    private static boolean[] isVisited;
    private static ArrayList<Integer>[] lists;
    private static int count = 0;
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        
        lists = new ArrayList[v+1];
        isVisited = new boolean[v+1];

        for(int i = 1; i <= v; i++) {
            lists[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            lists[n].add(m);
            lists[m].add(n);
        }        
        dfs(1);
        System.out.println(count-1);
    }

    private static void dfs(int visit) {
        if(isVisited[visit]) return;

        isVisited[visit] =  true;
        count++;
        for(int i : lists[visit]) {
            dfs(i);
        }
    }
}
