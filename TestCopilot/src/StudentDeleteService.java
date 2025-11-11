import java.util.Scanner;

/**
 * 학생 삭제 기능을 담당하는 클래스
 * 
 * SRP: 이 클래스는 "학생 삭제"라는 하나의 책임만 가짐
 * - 사용자 입력 받기
 * - 입력 유효성 검사
 * - StudentManager를 통한 학생 삭제
 */
public class StudentDeleteService {
    // 학생 정보를 관리하는 매니저
    private StudentManager manager;
    
    // 사용자 입력을 받기 위한 Scanner
    private Scanner scanner;

    /**
     * StudentDeleteService 생성자
     * 
     * @param manager 학생을 삭제할 StudentManager
     * @param scanner 사용자 입력을 받을 Scanner
     */
    public StudentDeleteService(StudentManager manager, Scanner scanner) {
        this.manager = manager;
        this.scanner = scanner;
    }

    /**
     * 사용자로부터 입력받아 학생을 삭제하는 메서드
     */
    public void deleteStudent() {
        System.out.println("\n========== 학생 삭제 ==========");
        
        // 사용자로부터 삭제할 학생의 이름 입력받기
        String name = inputStudentName();
        if (name == null) return;

        // StudentManager를 통해 학생 삭제
        manager.deleteStudent(name);
        System.out.println();
    }

    /**
     * 사용자로부터 학생 이름을 입력받는 메서드
     * 
     * @return 유효한 이름, 오류 시 null
     */
    private String inputStudentName() {
        System.out.print("삭제할 학생 이름: ");
        String name = scanner.nextLine().trim();

        // 이름이 비어있는지 확인
        if (name.isEmpty()) {
            System.out.println("✗ 이름은 비워둘 수 없습니다.\n");
            return null;
        }

        return name;
    }
}
