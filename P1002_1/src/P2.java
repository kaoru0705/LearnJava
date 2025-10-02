public class P2 {
    public static void main(String[] args) {
        // 배열
        int a = 10;
        int b = 20;
        // new int[10]은 heap에 쌓인다.
        // 모든 변수는 stack에 쌓이고 기본 타입과 참조 타입으로 나뉜다.
        // 기본 타입을 제외한 모든 타입은 참조 타입이다.
        // scores 자체는 참조 타입 '변수'이므로 stack에 있으며 heap 영역에 메모리 주소를 참조하고 있다. 201p

        int[] scores = new int[10];
        // [] 배열 접근 연산자 다른 접근 연산자로 .이 있다. 
        scores[0] = 77;
        scores[5] = 99;
        scores[10] = 99;

        // heap 영역에 속한 메모리를 아무도 참조하지 않는다면 garbage가 되고, garbage collector가 제거한다.
        // 따라서 java에서는 delete가 존재하지 않는다.
    }
}
