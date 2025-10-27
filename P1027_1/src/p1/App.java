package p1;

public class App {
    public static void main(String[] args) {
        // 재너릭
        StudentDto<Integer, String> s1 = new StudentDto<>();
        // StudentDto2 s2 = new StudentDto2();
        // s2.score = "13";
        // s2.score = 313;

        // int value = (Integer)s2.score;
    }
}

class StudentDto<N extends Number, T>{
    String name;
    int age;
    T score;

    public T test(T value) {
        T result = null;
        return result;
    }
}

// class StudentDto2 {
//     String name;
//     int age;
//     Object score;
// }