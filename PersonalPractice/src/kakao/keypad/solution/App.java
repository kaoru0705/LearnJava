package kakao.keypad.solution;

public class App {
    public static void main(String[] args) {
        int numbers[] = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        Solution s = new Solution();
        System.out.println(s.solution(numbers, hand));
    }
}

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] callNumber= {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
        int[] leftPos = {3, 0};
        int[] rightPos = {3, 2};
        for(int num: numbers) {
            for(int x = 0; x < callNumber.length; x++) {
                for(int y = 0; y < callNumber[x].length; y++) {
                    if(num == callNumber[x][y]) {
                        if(num % 3 == 0 && num != 0) {
                            rightPos[0] = x;
                            rightPos[1] = y;
                            answer += "R";
                        } else if(num == 1 || num == 4 || num == 7) {
                            leftPos[0] = x;
                            leftPos[1] = y;
                            answer += "L";
                        } else {
                            int rightDistance = getDistance(rightPos[0], x) + getDistance(rightPos[1], y);
                            int leftDistance = getDistance(leftPos[0], x) + getDistance(leftPos[1], y);
                            if(rightDistance > leftDistance) {
                                leftPos[0] = x;
                                leftPos[1] = y;
                                answer += "L";
                            } else if(rightDistance < leftDistance) {
                                rightPos[0] = x;
                                rightPos[1] = y;
                                answer += "R";
                            } else {
                                if(hand == "right") {
                                    rightPos[0] = x;
                                    rightPos[1] = y;
                                    answer += "R";
                                } else {
                                    leftPos[0] = x;
                                    leftPos[1] = y;
                                    answer += "L";
                                }
                            }
                            
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    private int getDistance(int start, int end) {
        return (int)Math.abs((double)start - end);
    }
}