public class P1 {
    public static void main(String[] args) {
        // 지역 변수는 스택에 쌓인다.
        int a = 10;
        int b = 20;

        Repository studentInfo = new Repository();

        studentInfo.studentCount = 5;
        studentInfo.nameList = new String[studentInfo.studentCount];
        studentInfo.ageList = new int[studentInfo.studentCount];
        studentInfo.scoreList = new int[studentInfo.studentCount];
        

        System.out.println("안녕하세요!!");
    }
}

// 클래스 정의 문법 Class Declaration
// 첫 글자 반드시 대문자 규칙
// 클래스는 문법적으로만 논리적이다.
// 정의만으로는 메모리 상에 존재하지 않는다.
// 클래스도 넓은 의미로 자료구조
// class명 변수명(변수 선언 문법) = new class명()(인스턴스 생성 문법)
// class든 배열이든 인스턴스 생성을 안 하고 변수를 선언만 하는 것은 메모리 공간을 차지하지 않는다. 반면에 c계열은? 선언만으로 메모리 공간 차지



class Repository {
    // 속성 property - 멤버변수 - 인스턴스 변수(인스턴스 생성 시에 생성되는 변수들)
    // 속성에서는 변수 선언만 가능 분기 루프, print 등은 못 씀
    // 초기화할 목적으로 사용하는 건 가능 int a = (int)Math.random() > 19 ? 0 : 1;

    // int a = 70; 인스턴스 생성 시 초기화
    int studentCount;
    String nameList[];
    int ageList[];
    int scoreList[];

    // 생성자 constructor

    // 기능 function method behaviour
}
