package book06;

import java.util.Arrays;
import java.util.HashMap;

public class App {
    private static int[] solution(int N, int[] stages) {
        int[] challenger = new int[N + 2];
        for(int stage: stages) {
            challenger[stage]++;
        }

        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        for(int i = 1; i <= N; i++) {
            if(challenger[i] == 0) {
                fails.put(i, 0.0);
            } else {
                fails.put(i, challenger[i] / total);
                total -= challenger[i];
            }
        }

        return fails.entrySet().stream().sorted((o1, o2) -> 
        o1.getValue().equals(o2.getValue()) ? Integer.compare(o1.getKey(), o2.getKey()) :
        Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
    public static void main(String[] args) {
        int[] answer = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});

        System.out.println(Arrays.toString(answer));
    }
}
