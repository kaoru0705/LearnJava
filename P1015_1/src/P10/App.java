package P10;

public class App {
    public static void main(String[] args) {
        StudentsDto s1 = new StudentsDto();
        s1.setName("철수");
        System.out.println(s1.getName());
    }
}

// Dto = 기능 없음. 데이터 묶는 용도의 클래스
class StudentsDto {
    private String name;
    private int age;
    private int score;
    // setter - write 권한
    // getter - read 권한
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }
}