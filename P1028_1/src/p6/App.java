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

        // 키값의 hashCode를 이용해서 배열 인덱스를 결정한다. 따라서 O(1)
        // 만일 인덱스가 같을 경우(충돌할 경우) 링크드 리스트로 관리 최악이면 O(n) 
        // java8부터는 노드가 8개 이상일 경우 Tree로 관리한다고 한다. O(log n)
        // sha hash 알고리즘 LSH 알고리즘
        System.out.println("철수".hashCode() % 16);
        System.out.println(Integer.valueOf(42).hashCode());
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
