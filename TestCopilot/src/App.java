import java.util.Scanner;

/**
 * 학생관리 프로그램의 메인 클래스
 * 
 * SRP: 이 클래스는 "프로그램 초기화 및 메인 루프 실행"만을 담당
 * - 필요한 객체들을 생성
 * - 파일 로드
 * - 메뉴 루프 실행
 */
public class App {
    /**
     * 프로그램의 시작점
     * main() 메서드가 프로그램이 실행될 때 가장 먼저 호출됨
     * 
     * @param args 프로그램 실행 시 전달받는 명령줄 인자
     * @throws Exception 예외가 발생할 수 있음을 나타냄
     */
    public static void main(String[] args) throws Exception {
        // 프로그램 시작 메시지 출력
        System.out.println("========== 학생관리 프로그램 ==========\n");

        // 1. 필요한 객체들 생성
        // Scanner: 사용자 입력을 받기 위한 도구
        Scanner scanner = new Scanner(System.in);
        
        // StudentManager: 학생 정보를 관리하는 매니저
        StudentManager manager = new StudentManager();
        
        // StudentFileManager: 파일 저장/로드를 담당하는 매니저
        StudentFileManager fileManager = new StudentFileManager();

        // 2. 프로그램 시작 시 파일에서 이전에 저장된 학생 정보 로드
        fileManager.loadStudents(manager);
        System.out.println();

        // 3. MenuManager 생성 (메뉴 구조 초기화)
        MenuManager menuManager = new MenuManager(scanner, manager, fileManager);

        // 4. 메뉴 루프: 사용자가 프로그램을 종료할 때까지 반복
        // showMenuAndExecute()가 true를 반환하면 계속 진행
        // false를 반환하면 루프 종료 (프로그램 종료)
        while (menuManager.showMenuAndExecute()) {
            // 메뉴가 실행되고 난 후 다시 메뉴를 표시
        }

        // 5. Scanner 닫기 (리소스 해제)
        scanner.close();
    }
}
