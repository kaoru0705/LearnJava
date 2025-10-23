package q1;

public class App {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(3, 1, 2);
    }
}

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int number = 1;
        int sign = 1;
        int[][] arr = new int[n / w ][w];
        int[] numLocation = new int[2];
        for(int i = 0; i < arr.length; i++) {
            int j = (sign > 0) ? 0 : w - 1;
            int count = 0;
            while(count < w) {
                arr[i][j] = number;
                if(number == num) {
                    numLocation[0] = i;
                    numLocation[1] = j;
                }
                if(number == n) break;
                number++;
                j += sign;
                count++;
            }
            sign *= -1;
        }
        for(int i = numLocation[0]; i < arr.length; i++) {
            if(arr[i][numLocation[1]] != 0) answer++;
        }

        System.out.println(answer);
        return answer;
    }
}
