/**
 * 학생 정보를 저장하고 관리하는 클래스
 * 학생의 기본 정보(이름, 나이, 점수)를 속성으로 가짐
 */
public class Student {
    // 학생의 이름을 저장하는 변수
    private String name;
    
    // 학생의 나이를 저장하는 변수
    private int age;
    
    // 학생의 점수를 저장하는 변수 (소수점 포함)
    private double score;

    /**
     * Student 생성자
     * 새로운 학생 객체를 만들 때 이름, 나이, 점수를 초기화함
     * 
     * @param name 학생의 이름
     * @param age 학생의 나이
     * @param score 학생의 점수
     */
    public Student(String name, int age, double score) {
        // 매개변수로 받은 name 값을 이 객체의 name에 저장
        this.name = name;
        
        // 매개변수로 받은 age 값을 이 객체의 age에 저장
        this.age = age;
        
        // 매개변수로 받은 score 값을 이 객체의 score에 저장
        this.score = score;
    }

    /**
     * 학생의 이름을 반환하는 메서드 (getter)
     * 외부에서 학생의 이름을 읽을 때 사용함
     * 
     * @return 학생의 이름
     */
    public String getName() {
        // name 변수에 저장된 학생의 이름을 반환
        return name;
    }

    /**
     * 학생의 이름을 설정하는 메서드 (setter)
     * 외부에서 학생의 이름을 변경할 때 사용함
     * 
     * @param name 설정할 새로운 이름
     */
    public void setName(String name) {
        // 매개변수로 받은 name을 이 객체의 name에 저장
        this.name = name;
    }

    /**
     * 학생의 나이를 반환하는 메서드 (getter)
     * 외부에서 학생의 나이를 읽을 때 사용함
     * 
     * @return 학생의 나이
     */
    public int getAge() {
        // age 변수에 저장된 학생의 나이를 반환
        return age;
    }

    /**
     * 학생의 나이를 설정하는 메서드 (setter)
     * 외부에서 학생의 나이를 변경할 때 사용함
     * 
     * @param age 설정할 새로운 나이
     */
    public void setAge(int age) {
        // 매개변수로 받은 age를 이 객체의 age에 저장
        this.age = age;
    }

    /**
     * 학생의 점수를 반환하는 메서드 (getter)
     * 외부에서 학생의 점수를 읽을 때 사용함
     * 
     * @return 학생의 점수
     */
    public double getScore() {
        // score 변수에 저장된 학생의 점수를 반환
        return score;
    }

    /**
     * 학생의 점수를 설정하는 메서드 (setter)
     * 외부에서 학생의 점수를 변경할 때 사용함
     * 
     * @param score 설정할 새로운 점수
     */
    public void setScore(double score) {
        // 매개변수로 받은 score를 이 객체의 score에 저장
        this.score = score;
    }

    /**
     * 학생의 모든 정보를 하나의 문자열로 만드는 메서드
     * println()으로 객체를 출력할 때 이 메서드가 자동으로 호출됨
     * 
     * @return "이름: OOO, 나이: XX, 점수: XX.X" 형태의 문자열
     */
    @Override
    public String toString() {
        // String.format()을 사용하여 학생 정보를 예쁘게 포맷팅
        // %s = 문자열(이름), %d = 정수(나이), %.1f = 소수점 1자리까지의 실수(점수)
        return String.format("이름: %s, 나이: %d, 점수: %.1f", name, age, score);
    }
}
