public class P5 {
    public static void main(String[] args) {
        // 산술 연산자

        byte v1 = 10 + 20;
        byte v2 = 30;
        // byte v3 = v1 + v2; // 바이트는 int로 promotion이 돼서 연산을 한다. mismatch from int to byte 137page
        // byte v3 = (byte)v1 + (byte)v2; // 이래도 더할 때 int로 연산한다.
        byte v3 = (byte)(v1 + v2);

        {
            int a = 10;
            double b = 20.0;
            int c = (int)(a + b);
        }

        {
            int a = 10;
            long b = 20L;
            long c = a + b;
        }

        {
            int a = 10;
            // 보통 분모쪽에 casting한다.
            double b = a / (double)3;
        }

        {
            // 정수는 0으로 나눌 수 없다...
            // int a = 10/0; // exception
            
            // 수학적으로는 말이 안 되지만 Infinity로 출력
            double a = 10 / 0.0;
            System.out.println(a);
            float b = 10 / 0.0f;
            System.out.println(b);

            // NaN (Not a Number)
            double c = 0.0/0.0;
            System.out.println(c);
        }

        {
            // 연산자는 우선 순위가 있다.
            int a = - 1 + 2 * 3 + 4;
        }

    }
}
