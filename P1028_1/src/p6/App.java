package p6;
import java.util.Map;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        Map<String, StudentDto> map = new HashMap<>();

        map.put("한조", new StudentDto("한조"));
        map.put("영희", new StudentDto("영희"));
        map.put("철수", new StudentDto("철수"));

        StudentDto s = map.get("한조");
    }
}

class StudentDto {
    private String name;
    private int age;
    private int score;

    StudentDto(String name) {
        this.name = name;
    }
}
