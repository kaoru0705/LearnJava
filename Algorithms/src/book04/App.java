package book04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    private static int[] solution(int[] answers) {
        int[][] pattern = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] scores = new int[3];

        for(int i = 0; i < answers.length; i++) {
            for(int j = 0; j < pattern.length; j++) {
                if(answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;
                }
            }
        }

        int maxScore = Arrays.stream(scores).max().getAsInt();

        List<Integer> rank = new ArrayList<>();
        for(int i = 0; i < scores.length; i++) {
            if(scores[i] == maxScore) {
                rank.add(i + 1);
            }
        }

        return rank.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};

        int[] rank = solution(answers);
        System.out.println(Arrays.toString(rank));
    }
}
