public class P8 {
    public static void main(String[] args) {
        // type mismatch -> promotion(자동타입변환), casting
        // byte < short < int < long < float < double
        byte a = 10;
        int b = 20;
        boolean c = true;

        // a = c;
        // c = a;

        // a = b; // Syntax Error mismatch from int to byte 정보의 손실이 발생하기 때문에 큰 범위에서 작음 범위로 못 들어감.
        b = a; // implicit type casting(묵시적 형변환), promotion
        a = (byte)b; // explicit type casting(명시적 형변환) - 논리적 확신이 들 때만 사용. 절대 좋은 코드가 아니다.

        // double v1 = 10; // type mismatch promotion으로 허용이지만 정수 리터럴을 실수에 넣을 필요가 없다.
        double v1 = 10.0;
        int v2 = (int)30.0;

        float f1 = 10.0f;
        long f2 = 9012830180183L;
        f1 = f2; // 4byte float이어도 long보다 우선순위가 높다.
        //f2 = f1; // mismatch from float to long

        int t1 = 65;
        char t2 = 65;
        char t3 = 'a';

        // println은 타입마다 다르게 실행한다.
        System.out.println(t1);
        System.out.println(t2);
        System.out.println((int)t3);
    }
}
