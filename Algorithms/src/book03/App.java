package book03;

import java.util.Arrays;
import java.util.HashSet;

public class App {

    private static int[] solution(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                hs.add(arr[i] + arr[j]);    // 처음엔 TreeSet으로 했으나 추가할 때마다 정렬이 되니 이게 낫다. -> 아니다 Big-O는 둘 다 동일하다.
            }
        }

        return hs.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    public static void main(String[] args) {
        int[] arr = {5, 0, 2, 7};

        arr = solution(arr);

        System.out.println(Arrays.toString(arr));
    }
}
