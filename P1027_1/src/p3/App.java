package p3;

public class App {
    public static void main(String[] args) {
        // 예외 처리 - 사실상 정말 중요한 문법 - 프로그램 안정성 확보
        // 기능이 구현 가능한 상태(실력)에서 그 다음으로 가장 중요한 

        // 런타임 에러 (문법 에러 아님)
        // 개발자는 모든 예외를 알 수 없으며 에러가 났다고 해서 프로그램을 종료시킬 수는 없다.
        int a = 10;
        int b = 0;
        
        try {
            System.out.println("로직 1");
            System.out.println(a / b);
            System.out.println("로직 2");
        } catch(Exception e) {
            System.out.println("에러가 났어요. 다만 프로그램이 뻗어버리지 않습니다.");
            // 실력있는 개발자의 차이 catch를 얼마나 잘 고민해서 다루는가
            // 쉬운 케이스: 사용자에게 알려준다.
            // 복잡한 케이스: 에러를 복구하는 코드
        }

        System.out.println("프로그램 끝");
    }
}
