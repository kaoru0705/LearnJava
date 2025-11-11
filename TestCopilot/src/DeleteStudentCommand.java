/**
 * 학생 삭제 메뉴를 선택했을 때 실행되는 명령
 * 
 * SRP: 이 클래스는 "학생 삭제 명령 실행"만을 담당
 */
public class DeleteStudentCommand implements MenuCommand {
    // 학생 삭제 기능을 담당하는 서비스
    private StudentDeleteService deleteService;

    /**
     * DeleteStudentCommand 생성자
     * 
     * @param deleteService 학생을 삭제할 서비스
     */
    public DeleteStudentCommand(StudentDeleteService deleteService) {
        this.deleteService = deleteService;
    }

    /**
     * 학생 삭제 명령을 실행하는 메서드
     * 
     * @return 항상 true (프로그램 계속 진행)
     */
    @Override
    public boolean execute() {
        deleteService.deleteStudent();
        return true;
    }
}
