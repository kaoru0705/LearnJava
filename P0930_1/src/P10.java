public class P10 {
    public static void main(String[] args) {
        // 논리 연산자 && || !
        // 피연산자는 boolean, 결과도 boolean
        int a = 10;
        int b = 20;

        // 앞에 연산만 먼저 보고 오른쪽은 실행도 안 한다. or 일 때 앞쪽이 true이면 후자는 연산할 필요가 없다.
        boolean r1 = a > 5 && b > 5; // and operator && || 
        boolean r2 = a > 5 || b > 5; // or operator

        // ! 단항 연산자가 보통 많이 빠름
        boolean r3 = !(a > 5) || b > 5;

    }
}
