/**
 * 학생 목록 조회 메뉴를 선택했을 때 실행되는 명령
 * 
 * SRP: 이 클래스는 "학생 목록 조회 명령 실행"만을 담당
 */
public class DisplayStudentCommand implements MenuCommand {
    // 학생 목록 표시 기능을 담당하는 서비스
    private StudentDisplayService displayService;

    /**
     * DisplayStudentCommand 생성자
     * 
     * @param displayService 학생 목록을 표시할 서비스
     */
    public DisplayStudentCommand(StudentDisplayService displayService) {
        this.displayService = displayService;
    }

    /**
     * 학생 목록 조회 명령을 실행하는 메서드
     * 
     * @return 항상 true (프로그램 계속 진행)
     */
    @Override
    public boolean execute() {
        displayService.displayAllStudents();
        return true;
    }
}
