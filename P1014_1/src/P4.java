import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Worker w1 = new Worker("철수");
        Worker w2 = new Worker("영희");

        w1.test1();
        w2.test1();

        w2.test2(3, 1);

        int aaa = w1.test2(5, 7);
        
        if( aaa != -1) {
            System.out.println(aaa);
        }

        w1.test3("안녕하세요!");
        w1.test3();

        System.out.println("프로그램 종료");
    }
}

class Worker {
    String name;
    int money;

    // 속성만 힙메모리에 들어간다. 
    // method, 생상자 등은 다른 메모리 영역

    Worker(String name) {
        this.name = name;
    }

    // method 일반적으로 동사 카멜케이스
    void test1() {
        // 실행될 코드...
        System.out.println("test1 호출됨");
    }

    int test2(int a, int b) {

        if(a < 0 || b < 0) {
            System.out.println("음수는 허용되지 않습니다.");
            return -1;
        }

        System.out.println("test2 호출됨");

        return a + b;
    }
    // method overloading 반환값만 같다.
    // 컴파일러는 사실상 다른 메소드로 본다.

    void test3(String text) {
        if(text.contains("바보")) {
            System.out.println("비속어는 사용할 수 없습니다.");
            return;
        }
        System.out.println(text);
    }

    void test3() {
       System.out.println("아무 문자라도 적길 바랍니다.");
    }
}