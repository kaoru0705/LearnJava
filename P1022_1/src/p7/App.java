package p7;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        List<StudentDto> list = new ArrayList<>();
        // 내부적으로는 10자리 배열
        StudentDto s = new StudentDto();
        s.setName("한조");
        s.setAge(30);
        s.setScore(99);
        list.add(s);
        StudentDto s1 = new StudentDto();
        s1.setName("바이");
        s1.setAge(29);
        s1.setScore(95);
        list.add(s1);
        // 이것도 많이 씀
        for(StudentDto element : list) {
            System.out.println(element.getName());
        }
        // Steam API - 람다식 사용
        // consumer abstract method one parameter return void
        list.forEach((student) -> System.out.println(student.getName()));
        
        Iterator <StudentDto> iterator = list.iterator();
        while(iterator.hasNext()) {
            StudentDto studentDto = iterator.next();
            System.out.println(studentDto.getName());
        }

        
    }
}

class StudentDto {
    private String name;
    private int age;
    private int score;

    public StudentDto() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
