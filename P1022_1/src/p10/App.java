package p10;

public class App {
    public static void main(String[] args) {
        
    }
}

// Controller - Service 간에 사용될 구조
class StudentDto {
    private String name;
    private int age;
    private int score;

    public StudentDto(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    public int getscore() {
        return score;
    }
}


// Service - Repository 간에 사용될 구조
class StudentEntity {
    private String name;
    private int age;
    private int score;
}