package boj11403;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Integer>[] list;
    private static int[][]graph;
    private static int size;

    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        size = Integer.parseInt(br.readLine());

        graph = new int[size][size];
        list = new ArrayList[size];
        for(int i = 0; i < size; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < size; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
    }
}
