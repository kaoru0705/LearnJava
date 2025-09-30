public class P7 {
    public static void main(String[] args) {
        {
            // double로 연산하면 안되는 이유 (귀찮거나 적당히는 해도 됨)
            int apple = 1;
            double piece = 0.1;
            int count = 7;

            double result = apple - (piece * count);
            System.out.println(result);
        }

        {
            // 세밀한 계산 시에는 정수로 계산한다. (double 최소한으로 사용한다.)
            int weight = 10;
            int apple = 1 * weight;
            int piece = (int)(0.1 * weight);
            int count = 7;
            int result = apple - (piece * count);
            double result2 = result/(double)weight;
        }
    }
}
