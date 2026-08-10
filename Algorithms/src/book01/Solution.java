package book01;

import java.util.Arrays;

public class Solution {

    private static int[] solution(int[] arr) {

        Arrays.sort(arr);

        return arr;
    }

    private static int[] solution2(int[] arr) {

        int[] cloned = arr.clone();
        Arrays.sort(cloned);

        return cloned;
    }

    public static void main(String[] args) {
        int[] org1 = {4, 2, 3, 1, 5};
        int[] sorted1 = solution(org1);

        System.out.println(Arrays.toString(org1));
        System.out.println(Arrays.toString(sorted1));

        int[] org2 = {4, 2, 3, 1, 5};
        int[] sorted2 = solution2(org2);

        System.out.println(Arrays.toString(org2));
        System.out.println(Arrays.toString(sorted2));

    }
}
