public class P5 {
    public static void main(String[] args) {
        // 실수 타입: float, double(실제 사용)
        // 정밀도 차이, double이 더 정밀하게 값을 담을 수 있다.
        // double이 기본
        // 사실상 연산을 위해서라면, int나 long으로 변환해서 연산해야 한다.

        double a = 10.3; // 64bit = 8byte
        // Type mismatch
        //float b = 10.3;
        float b = 10.3f; // 32bit = 4byte

        double c = 0.123456789123456789;
        float d = 0.123456789123456789f;
        System.out.println(c);
        System.out.println(d);

        // 실수 리터럴
        double e = 3e-27;
        System.out.println(e);
    }
}
