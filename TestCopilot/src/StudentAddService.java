import java.util.Scanner;

/**
 * 학생 추가 기능을 담당하는 클래스
 * 
 * SRP: 이 클래스는 "학생 추가"라는 하나의 책임만 가짐
 * - 사용자 입력 받기
 * - 입력 유효성 검사
 * - StudentManager를 통한 학생 추가
 */
public class StudentAddService {
    // 학생 정보를 관리하는 매니저
    private StudentManager manager;
    
    // 사용자 입력을 받기 위한 Scanner
    private Scanner scanner;

    /**
     * StudentAddService 생성자
     * 
     * @param manager 학생을 추가할 StudentManager
     * @param scanner 사용자 입력을 받을 Scanner
     */
    public StudentAddService(StudentManager manager, Scanner scanner) {
        this.manager = manager;
        this.scanner = scanner;
    }

    /**
     * 사용자로부터 입력받아 새로운 학생을 등록하는 메서드
     */
    public void addStudent() {
        System.out.println("\n========== 학생 등록 ==========");
        try {
            // 학생 이름 입력받기
            String name = inputName();
            if (name == null) return;

            // 학생 나이 입력받기
            int age = inputAge();
            if (age == -1) return;

            // 학생 점수 입력받기
            double score = inputScore();
            if (score == -1) return;

            // 검증된 정보로 학생 등록
            Student student = new Student(name, age, score);
            manager.addStudent(student);
            System.out.println();
        } catch (NumberFormatException e) {
            System.out.println("✗ 나이와 점수는 숫자로 입력해주세요.\n");
        }
    }

    /**
     * 사용자로부터 학생 이름을 입력받는 메서드
     * 
     * @return 유효한 이름, 오류 시 null
     */
    private String inputName() {
        System.out.print("이름: ");
        String name = scanner.nextLine().trim();

        // 이름이 비어있는지 확인
        if (name.isEmpty()) {
            System.out.println("✗ 이름은 비워둘 수 없습니다.\n");
            return null;
        }

        // 같은 이름의 학생이 이미 등록되어 있는지 확인
        if (manager.findStudentByName(name) != null) {
            System.out.println("✗ 이미 등록된 학생입니다.\n");
            return null;
        }

        return name;
    }

    /**
     * 사용자로부터 학생 나이를 입력받는 메서드
     * 
     * @return 유효한 나이, 오류 시 -1
     */
    private int inputAge() {
        System.out.print("나이: ");
        try {
            int age = Integer.parseInt(scanner.nextLine().trim());
            
            if (age < 0) {
                System.out.println("✗ 나이는 0 이상이어야 합니다.\n");
                return -1;
            }
            
            return age;
        } catch (NumberFormatException e) {
            System.out.println("✗ 나이는 숫자로 입력해주세요.\n");
            return -1;
        }
    }

    /**
     * 사용자로부터 학생 점수를 입력받는 메서드
     * 
     * @return 유효한 점수, 오류 시 -1
     */
    private double inputScore() {
        System.out.print("점수: ");
        try {
            double score = Double.parseDouble(scanner.nextLine().trim());
            
            if (score < 0 || score > 100) {
                System.out.println("✗ 점수는 0~100 사이의 값이어야 합니다.\n");
                return -1;
            }
            
            return score;
        } catch (NumberFormatException e) {
            System.out.println("✗ 점수는 숫자로 입력해주세요.\n");
            return -1;
        }
    }
}
