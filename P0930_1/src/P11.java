public class P11 {
    // 비트 연산자
    // 연산 최적화 -> C언어 선택
    // 현재 메모리가 부족한 시대가 아님

    // 비트연산자: & | ^ ~ >> >>> << <<<

    public static void main(String[] args) {
        int a = 1;
        // arithmetic shift 음수면 1로 채움
        // logical shift 무조건 0으로 채움
        a = a >>> 1;
        System.out.println(a);

        int isMan =     0b00000001;     // 남자
        int isAdult =   0b00000010;     // 성인
        int isStudent = 0b00000100;     // 학생

        int person = 0;

        person = person | isAdult;
        person = person | isStudent;    // 101;

        if((person & isMan) == isMan) {
            System.out.println("남자입니다.");
        } else {
            System.out.println("여자입니다.");
        }

        {
            // 이미지...
            // FHD = 1920 * 1080
            // 24bit
            int pixel1 = 0xFF0000;

            // 16bit 00000 000000 00000
            int pix = 0b1100101101101101;
            int red = 0b1111100000000000;
            int pixRed = 0;
            pixRed = (pix & red) >> 11;

            //setRedLight(pixRed);
        }
    }
    
}
