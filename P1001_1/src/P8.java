public class P8 {
    public static void main(String[] args) {
        // break, continue

        int sum = 0;
        for(int i = 1; i <= 10; i++) {
            if(i%3 == 0){
                continue;
            }
            sum += i;
        }

        System.out.println(sum);
    }
}
