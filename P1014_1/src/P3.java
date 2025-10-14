public class P3 {
    public static void main(String[] args) {
        System.out.println("프로그램 시작");
        // 먼저 스택에 s1이 들어간다. 힙메모리에 Student1이 생성되고 생성자가 실행된다. 그다음 s1이 그 메모리를 가리킨다.

        Student1 s1 = new Student1("철수", 20, 70);
        Student1 s2 = new Student1("영희", 10, 90);
        Student1 s3 = new Student1("길동", 10);        

        
        System.out.println(s1.name);
        System.out.println(s2.name);
        System.out.println(s3.score);

        System.out.println("프로그램 끝");

    }
}

class Student1 {
    String name;
    int age;
    int score = 65;

    // Constructor 생성자 - 일반적으로는 초기화 목적
    // 요즘 코드 스타일은 생성자를 안 쓰는 게 트렌드
    Student1(String name, int age , int score) {
        System.out.println("매개변수 3개짜리 호출됨");
        // this keyword
        // this 그메모리 그 힙영역의 메모리
        this.name = name;
        this.age = age;
        this.score = score;
    }

    Student1(String name, int age) {
        this(name, age , 0);
        System.out.println("매개변수 2개짜리 호출됨");
        
    }

}