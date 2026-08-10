package book02;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class App {
    /* stream 기억 안 날 때 */
    private static int[] solution(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for(int i : arr) {
            set.add(i);
        }

        int[] result = new int[set.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = set.pollFirst();
        }

        return result;
    }
    /* 답지 */
    private static int[] solution2(int[] arr) {
        /* 
         *  클래스명::정적메서드
            클래스명::인스턴스메서드
            객체명::인스턴스메서드
            클래스명::new
         */
        Integer[] result = Arrays.stream(arr).distinct().boxed().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder());
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

    private static int[] solution3(int[] arr) {

        Integer[] result = Arrays.stream(arr).boxed()
            .distinct()
            .sorted(Collections.reverseOrder())
            .toArray(Integer[]::new);

        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 1, 9};
        
        arr = solution2(arr);

        System.out.println(Arrays.toString(arr));
    }
}
