public class P8 {
    public static void main(String[] args) {
        // break, continue

        int sum = 0;
        for(int i = 1; i <= 10; i++) {
            if(i%3 == 0) continue;
            sum += i;
        }
        System.out.println(sum);

        // while
        int sum2 = 0;
        int i2 = 1;
        while (i2 <= 10) {
            if(i2 % 3 == 0) {
                i2++;
                continue;
            }
            sum2 += i2;
            i2++;
        }
        System.out.println(sum2);
    }
}
