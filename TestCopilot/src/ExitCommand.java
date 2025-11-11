/**
 * 프로그램 종료 메뉴를 선택했을 때 실행되는 명령
 * 
 * SRP: 이 클래스는 "프로그램 종료 명령 실행"만을 담당
 */
public class ExitCommand implements MenuCommand {
    // 프로그램 종료 시 저장할 파일 매니저
    private StudentFileManager fileManager;
    
    // 현재 등록된 학생 정보를 관리하는 매니저
    private StudentManager manager;

    /**
     * ExitCommand 생성자
     * 
     * @param fileManager 데이터를 저장할 파일 매니저
     * @param manager 학생 정보를 관리하는 매니저
     */
    public ExitCommand(StudentFileManager fileManager, StudentManager manager) {
        this.fileManager = fileManager;
        this.manager = manager;
    }

    /**
     * 프로그램 종료 명령을 실행하는 메서드
     * 
     * @return false를 반환하여 프로그램 종료를 신호
     */
    @Override
    public boolean execute() {
        // 프로그램 종료 전에 학생 정보를 파일에 저장
        fileManager.saveStudents(manager);
        System.out.println();
        System.out.println("프로그램을 종료합니다.");
        
        // false를 반환하여 메뉴 루프를 종료
        return false;
    }
}
