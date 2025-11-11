/**
 * 학생 정보 수정 메뉴를 선택했을 때 실행되는 명령
 * 
 * SRP: 이 클래스는 "학생 정보 수정 명령 실행"만을 담당
 */
public class UpdateStudentCommand implements MenuCommand {
    // 학생 정보 수정 기능을 담당하는 서비스
    private StudentUpdateService updateService;

    /**
     * UpdateStudentCommand 생성자
     * 
     * @param updateService 학생 정보를 수정할 서비스
     */
    public UpdateStudentCommand(StudentUpdateService updateService) {
        this.updateService = updateService;
    }

    /**
     * 학생 정보 수정 명령을 실행하는 메서드
     * 
     * @return 항상 true (프로그램 계속 진행)
     */
    @Override
    public boolean execute() {
        updateService.updateStudent();
        return true;
    }
}
