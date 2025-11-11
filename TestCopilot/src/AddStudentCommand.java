/**
 * 학생 추가 메뉴를 선택했을 때 실행되는 명령
 * 
 * SRP: 이 클래스는 "학생 추가 명령 실행"만을 담당
 */
public class AddStudentCommand implements MenuCommand {
    // 학생 추가 기능을 담당하는 서비스
    private StudentAddService addService;

    /**
     * AddStudentCommand 생성자
     * 
     * @param addService 학생을 추가할 서비스
     */
    public AddStudentCommand(StudentAddService addService) {
        this.addService = addService;
    }

    /**
     * 학생 추가 명령을 실행하는 메서드
     * 
     * @return 항상 true (프로그램 계속 진행)
     */
    @Override
    public boolean execute() {
        addService.addStudent();
        return true;
    }
}
