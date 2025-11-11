import java.util.Scanner;

/**
 * 메뉴 시스템 전체를 관리하는 클래스
 * 
 * SRP: 이 클래스는 "메뉴 관리"만을 담당
 * - 메뉴 구조 생성
 * - 메뉴 표시
 * - 사용자 입력에 따른 메뉴 선택 및 실행
 */
public class MenuManager {
    // 메뉴 구조의 루트 (메인 메뉴)
    private MenuGroup rootMenu;
    
    // 사용자 입력을 받기 위한 Scanner
    private Scanner scanner;

    /**
     * MenuManager 생성자
     * 메뉴 구조를 생성하고 초기화
     * 
     * @param scanner 사용자 입력을 받을 Scanner
     * @param manager 학생 정보를 관리하는 StudentManager
     * @param fileManager 파일 저장/로드를 담당하는 StudentFileManager
     */
    public MenuManager(Scanner scanner, StudentManager manager, StudentFileManager fileManager) {
        this.scanner = scanner;
        // 메뉴 구조 생성
        this.rootMenu = buildMenu(manager, fileManager);
    }

    /**
     * 메뉴 구조를 생성하는 메서드
     * 트리 형태의 메뉴를 구성
     * 
     * @param manager 학생 정보를 관리하는 StudentManager
     * @param fileManager 파일 저장/로드를 담당하는 StudentFileManager
     * @return 생성된 메뉴 구조 (루트 MenuGroup)
     */
    private MenuGroup buildMenu(StudentManager manager, StudentFileManager fileManager) {
        // 메인 메뉴 생성
        MenuGroup mainMenu = new MenuGroup("========== 메뉴 ==========", null);

        // Service 객체 생성
        StudentAddService addService = new StudentAddService(manager, scanner);
        StudentDeleteService deleteService = new StudentDeleteService(manager, scanner);
        StudentUpdateService updateService = new StudentUpdateService(manager, scanner);
        StudentDisplayService displayService = new StudentDisplayService(manager);

        // Command 객체 생성
        MenuCommand addCommand = new AddStudentCommand(addService);
        MenuCommand deleteCommand = new DeleteStudentCommand(deleteService);
        MenuCommand updateCommand = new UpdateStudentCommand(updateService);
        MenuCommand displayCommand = new DisplayStudentCommand(displayService);
        MenuCommand exitCommand = new ExitCommand(fileManager, manager);

        // MenuItem 생성 및 메뉴에 추가
        mainMenu.addChild(new MenuItem("1", "학생 등록", addCommand));
        mainMenu.addChild(new MenuItem("2", "학생 삭제", deleteCommand));
        mainMenu.addChild(new MenuItem("3", "학생 정보 수정", updateCommand));
        mainMenu.addChild(new MenuItem("4", "학생 목록 조회", displayCommand));
        mainMenu.addChild(new MenuItem("5", "프로그램 종료", exitCommand));

        return mainMenu;
    }

    /**
     * 메뉴를 화면에 표시하고 사용자 입력을 받아 해당 메뉴를 실행하는 메서드
     * 
     * @return 프로그램을 계속 진행하면 true, 종료하면 false
     */
    public boolean showMenuAndExecute() {
        // 메뉴 전체 표시
        rootMenu.display(0);
        
        // 사용자로부터 선택번호 입력받기
        System.out.print("선택: ");
        String choice = scanner.nextLine().trim();

        // 입력된 선택번호에 해당하는 메뉴 찾기
        Menu selectedMenu = rootMenu.findMenuById(choice);

        // 메뉴를 찾지 못한 경우
        if (selectedMenu == null) {
            System.out.println("✗ 올바른 선택이 아닙니다. 다시 시도하세요.\n");
            return true; // 프로그램 계속 진행
        }

        // 찾은 메뉴 실행
        return selectedMenu.execute();
    }
}
