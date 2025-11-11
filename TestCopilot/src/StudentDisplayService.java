/**
 * 학생 목록 조회 기능을 담당하는 클래스
 * 
 * SRP: 이 클래스는 "학생 목록 표시"라는 하나의 책임만 가짐
 * - StudentManager에서 학생 목록을 받아 화면에 표시
 */
public class StudentDisplayService {
    // 학생 정보를 관리하는 매니저
    private StudentManager manager;

    /**
     * StudentDisplayService 생성자
     * 
     * @param manager 학생 정보를 조회할 StudentManager
     */
    public StudentDisplayService(StudentManager manager) {
        this.manager = manager;
    }

    /**
     * 모든 학생의 정보를 화면에 표시하는 메서드
     */
    public void displayAllStudents() {
        manager.displayAllStudents();
    }
}
