public class P2 {
    public static void main(String[] args) {
        // 변수의 사용범위 scope
        
        int a = 10;
        {
            int b = 20;
            {
                int c = 30;
            }
            int d = 40;
        }
        int e = 50;
        int f = 60;

        // 지역 변수는 Stack에 쌓인다. 블록내에서 선언된 변수는 블록이 끝날 때 즉시 소멸된다.
        
    }
}
