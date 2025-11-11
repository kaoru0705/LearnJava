/**
 * 단일 메뉴 항목을 나타내는 클래스
 * 컴포지트 패턴: Menu 인터페이스를 구현하는 Leaf 노드
 * 
 * SRP: 이 클래스는 "메뉴 항목 실행"만을 담당
 * - 메뉴 정보 저장
 * - 메뉴 표시
 * - 메뉴 실행
 */
public class MenuItem implements Menu {
    // 메뉴 항목의 선택번호 (예: "1", "2", "2-1" 등)
    private String id;
    
    // 메뉴 항목의 이름 (사용자에게 보여지는 텍스트)
    private String name;
    
    // 이 메뉴를 선택했을 때 실행할 명령
    private MenuCommand command;

    /**
     * MenuItem 생성자
     * 
     * @param id 메뉴 항목의 ID
     * @param name 메뉴 항목의 이름
     * @param command 메뉴 선택 시 실행할 명령
     */
    public MenuItem(String id, String name, MenuCommand command) {
        this.id = id;
        this.name = name;
        this.command = command;
    }

    /**
     * 메뉴 항목을 화면에 표시하는 메서드
     * 
     * @param depth 트리 구조에서의 깊이 (들여쓰기 표현)
     */
    @Override
    public void display(int depth) {
        // depth에 따라 들여쓰기 추가
        String indent = getIndent(depth);
        
        // ID와 이름을 함께 출력
        // 예: "1. 학생 등록"
        System.out.println(indent + id + ". " + name);
    }

    /**
     * 깊이에 따라 들여쓰기 문자열을 생성하는 도우미 메서드
     * 
     * @param depth 깊이
     * @return 들여쓰기 문자열
     */
    private String getIndent(int depth) {
        // depth가 0이면 빈 문자열, 1이면 "  ", 2이면 "    " 등
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append("  ");
        }
        return indent.toString();
    }

    /**
     * 메뉴를 선택했을 때 실행되는 메서드
     * 저장된 command 객체의 execute() 메서드를 호출
     * 
     * @return 프로그램을 계속 진행하면 true, 종료하면 false
     */
    @Override
    public boolean execute() {
        // 이 메뉴에 등록된 명령을 실행
        // command.execute()의 결과를 그대로 반환
        return command.execute();
    }

    /**
     * 메뉴 항목의 ID를 반환하는 메서드
     * 사용자의 입력이 이 ID와 일치할 때 실행됨
     * 
     * @return 메뉴의 ID
     */
    @Override
    public String getId() {
        return id;
    }
}
