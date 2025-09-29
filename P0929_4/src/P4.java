public class P4 {
    public static void main(String[] args) {
        // 기본 타입(primitive type) 종류
        // 정수: byte(8 bit), short, int, long

        byte a = 10; // 8bit(물리적 전기적 신호 단위) = 1byte(메모리 생성 단위) -128 ~ 127
        short b = 10; // 16bit = 2byte -32768 ~ 32767
        int c = 10; // 32bit = 4byte -2147483648 ~ 2147483647
        long d = 10; // 64bit = 8byte

        // 10을 담을 때 byte가 효율적일까? 아니다. 실질적으로 int를 쓴다. 20억 이상의 값을 다룰 때는 long사용
        // 연산의 기본은 int다.

        // integerLiteral = 정수를 표현하는 문법적 방식
        int e = 10; // 10, 0xFF integerLiteral
        e = 0xFF;
        e = '안';
        long f = 10000000000L;

    }
}
