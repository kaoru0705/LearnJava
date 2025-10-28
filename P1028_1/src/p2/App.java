package p2;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<StudentDto> list = new ArrayList<>();

        // ArrayList에서 삽입 삭제는 주의를 요함.
    }
}

class StudentDto {
    StudentDto(String name) {
        this.name = name;
    }

    String name;
    int age;
    int score;
}
