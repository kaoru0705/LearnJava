package P12;

import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        final int a = 10;
        final String databaseIp = "211.222.111.222";

        int answer = 0;
        HashSet <Integer> primeSet = new HashSet <>();
        int nums[] = {999, 1000, 1001};
        int loopCount = 0;
        for(int x = 0; x < nums.length - 2; x++) {
            for(int y = x + 1; y < nums.length - 1; y++) {
                for(int z = y + 1; z < nums.length; z++) {
                    int sumThreeNums = nums[x] + nums[y] + nums[z];
                    System.out.println(sumThreeNums);
                    boolean isPrime = true;
                    loopCount++;
                    for(int divison = 2; divison <= sumThreeNums / 2; divison++) {
                        if(sumThreeNums % divison == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if(isPrime && !primeSet.contains(sumThreeNums)) {
                        primeSet.add(sumThreeNums);
                        answer++;
                    }
                }
            }
        }

        System.out.println(loopCount + " " + answer);


    }
}

// final 
class Test {
    static final String name = "ddd";
}