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
    }
}
