package p5;

public class App {
    public static void main(String[] args) {
        // Wrapper 클래스
        // 편하게 사용 가능하지만 사용 시 주의를 요함
        // Wrapper 클래스로 연산만 하지 말자... 아주 적은 연산은...
        // 장점: null을 가질 수 있다.

        int a = 10;
        Integer b = 20; // 박싱
        int c = b; // 언박싱

        // 클래스는 생성 cost가 세다
        Integer qq = 10;
        // 언박싱을 하고 더하고 또 새로운 메모리에 생성한다.
        qq = qq + 20; // 문제 많음
        System.out.println(qq);

        // 이건 선넘네
        for(Integer i = 0; i < 10; i++) {

        }

        ///////////////////////////////////////
        /// 
        Byte byte1 = 20;
        Short short1 = 20;
        Integer integer1 = 30;
        Long long1 = 40L;
        Float float1 = 3.14f;
        Double double1 = 3.14;
        Character character1 = 'a';
        Boolean boolean1 = true;

        // 1이 박싱되고 Integer로 들어감
        Object aaa = 1;
    }
}
