public class P1 {
    public static void main(String[] args) {
        // 조건문 
        System.out.println("코드1");
        System.out.println("코드2");
        System.out.println("코드3");
        System.out.println("코드4");

        // System과 int는 같은 색이지만 System은 문법이 아니다.
        // 실무에서 변수에 값을 집어넣는 사례는 없다(상수를 제외하고)
        //int value = 30;

        int value = 30;
        // java에서는 문법적으로 들여쓰기가 중요하지 않다. 이런식으로 실행해도 문법오류를 발생시키지 않는다.
        // if(value > 10)
        //     System.out.println(value + "가 10보다 클 때 쓸 로직들...1");
        //     System.out.println(value + "가 10보다 클 때 쓸 로직들...2");



        // Java에서는 조건에 무조건 Boolean을 써야 한다. 다른 언어는 됨.
        // if(value) {

        // }
        // if 한 줄이면 간결하게 할 수 있지만 그래도 중괄호를 써라 엄청나게 짧으면 if(value > 10) a = 10; 가능

        if(value > 10) {
            System.out.println(value + "가 10보다 클 때 쓸 로직들...1");
        } else {
            System.out.println(value + "가 10보다 작을 때 쓸 로직들...1");
        }

        int a[][] = {{-1, -1}, {1, 1}};
        int width = (int)(Math.pow(Math.sqrt(Math.pow(a[0][0] - a[1][0], 2) + Math.pow(a[0][1] - a[1][1], 2)), 2));

        System.out.println(width);

        System.out.println("프로그램 종료");
    }
}
