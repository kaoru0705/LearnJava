package p2;

public class App {
    public static void main(String[] args) {
        //클래스 설계를 잘하려면 클래스를 만드는 사람과 사용하는 사람을 구분해야 한다.
        // 점수랑 나이를 바꿔서 입력한다면?
        // 요즘 프레임워크는 생성자가 없는 경우가 있다고 한다.
        // StudentDto s1 = new StudentDto("한조", 30, 99);
        // 그래서 setter getter를 선호하는 경우가 있다.
        // 허나 요즘에는 또 불변객체를 만드는 게 좋다고 getter setter를 안 쓰는 사람도 있다.

        // 그래서 Builder pattern (여러 디자인 패턴 중 하나)
        // 허나 현실적으로는 사용하기 힘들었지만 Spring에서 @Builder로 요즘은 많이 쓴다.
        StudentDto s1 = StudentDto.builder()
            .name("한조")
            .age(30)
            .score(99)
            .build();
    }
}

class StudentDto {
    private String name;
    private int age;
    private int score;

    private StudentDto(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.score = builder.score;
    }

    // public StudentDto(String name, int age, int score) {
    //     this.name = name;
    //     this.age = age;
    //     this.score = score;
    // }

    

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private int age;
        private int score;
        
        private Builder() {}

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        public Builder score(int score) {
            this.score = score;
            return this;
        }
        public StudentDto build() {
            return new StudentDto(this);
        }

    }



}
