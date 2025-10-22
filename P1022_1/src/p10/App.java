package p10;

import java.util.*;

public class App {
    public static void main(String[] args) {
        // 여기가 Service 내부 코드라는 가정
        // Repository에서 getList() 호출했다.
        // 근데 Repository에서는 StudentEntity로 결과를 줬다.
        // 다시 Controller로 배열을 리턴해야하는데, StudentDto 배열로 리턴해야 한다.

        List<StudentEntity> entitieList = new ArrayList<>();
        entitieList.add(new StudentEntity("한조", 30, 99));
        entitieList.add(new StudentEntity("김철수", 30, 99));
        entitieList.add(new StudentEntity("김영희", 30, 99));
        entitieList.add(new StudentEntity("길동", 30, 99));

        // 위에처럼 Repository에서 배열을 Service에 전달했다.
        // 문제: StudentEntity -> StudentDto로 변환해라
        
        // 옛날 코드에선 이렇게도 많이 보인다.
        // List<StudentDto> dtoList = new ArrayList<>();
        // for(StudentEntity entity : entitieList) {
        //     // StudentDto studentDto = entity.toDto();
        //     StudentDto studentDto = StudentDto.fromEntity(entity);
        //     dtoList.add(studentDto);
        // }


        // dtoList를 리턴...
        // stream api는 람다식이 공식
        // List<StudentDto> dtoList = entitieList.stream()
        //     .map(StudentDto::fromEntity)
        //     .toList();
        List<StudentDto> dtoList = entitieList.stream()
            .map(e->StudentDto.fromEntity(e))
            .toList();
        List<StudentDto> dtoList2 = entitieList.stream()
            .filter(entity -> entity.getName().startsWith("김"))
            .map(entity -> StudentDto.fromEntity(entity))
            .toList();

        double average = dtoList.stream()
                    .filter(dto -> dto.getName().length() <= 3)
                    .mapToInt(dto -> dto.getScore())
                    .filter(score -> score >= 50)
                    .distinct() // 중복 배제
                    .average().getAsDouble();
        // Consumer 입력 있음 리턴 없음
        // Function 입력 있음 리턴 있음
        // Supplier 입력 없음 리턴 있음
        // Predicate 입력 있음 리턴 boolean
        
    }
}

// 똑같은 형태의 Dto가 4개
// 프론트엔드에서 Controller로 가져오는 Dto 등등 포함

// 원칙적으로 Dto는 특정 Layer 내에서만 써야 한다.
// Controller - Service 간에 사용될 구조
class StudentDto {
    private String name;
    private int age;
    private int score;

    // 변환용 method 만들기
    // Entity -> Dto 변환 (보통은 to보다 from을 조금 더 선호)
    // 정적 팩토리 메서드
    public static StudentDto fromEntity(StudentEntity entity) {
        return new StudentDto(entity.getName(), entity.getAge(), entity.getScore());
    }


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
    public int getScore() {
        return score;
    }
}


// Service - Repository 간에 사용될 구조
class StudentEntity {
    private String name;
    private int age;
    private int score;

    public StudentEntity(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    // 변환용 method 만들기
    // Entity -> Dto 변환 메서드
    public StudentDto toDto() {
        return new StudentDto(name, age, score);
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
    public int getScore() {
        return score;
    }
}