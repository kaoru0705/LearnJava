public class P9 {
    public static void main(String[] args) {
        // 단축 배정 연산자, 증감 연산자 : 대부분은 산술
        int a = 10;

        a = a + 1;
        a += 1;
        a++;
        a--;

        int b = 10;
        b = b + 3;
        b += 3;

        int c = 10;
        c = c - 7;
        c -= 7;

        int f = 3;
        f++;
        ++f;
        
        // +가 Sequence Point 실제로 쓸 일은 없지만.
        int r1 = 7 + f++ + ++f;
        System.out.println(r1);
    }
}
