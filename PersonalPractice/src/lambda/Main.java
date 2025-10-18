package lambda;

interface MyInterface1 {
    public void method(int a, int b);
}

interface MyInterface2 {
    public void method(int a);
}

interface Myinterface3 {
    public int method(int a, int b);
}


public class Main {
    public static void main(String[] args) {
        MyInterface1 f1, f2, f3;
        MyInterface2 f4;
        
        // 람다식 기본형
        f1 = (int a, int b) -> {System.out.println(a + b);};
        f1.method(3, 4);
        
        // 매개변수의 자료형을 생략한 람다식
        f2 = (a, b) -> {System.out.println(a + b);};
        f2.method(5, 6);

        // 메소드 본체의 실행문이 하나이므로 {}를 생략한 람다식
        f3 = (a, b) -> System.out.println(a + b);
        f3.method(7, 8);


        // 매개변수가 하나이므로 ()를 생략한 람다식
        f4 = a -> System.out.println(a);
        f4.method(9);

        Myinterface3 f5, f6;
        // f5 = (a, b) -> return a + b;
        f5 = (a, b) -> {return a + b;};
        System.out.println(f5.method(3, 4));

        f6 = (a, b) -> a + b;
        System.out.println(f6.method(5, 6));
    }
}