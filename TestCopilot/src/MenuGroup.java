/**
 * 메뉴 그룹을 나타내는 클래스
 * 컴포지트 패턴: 여러 개의 Menu를 포함할 수 있는 컨테이너 역할
 * 
 * SRP: 이 클래스는 "메뉴 그룹 관리"만을 담당
 * - 자식 메뉴 추가/제거
 * - 자식 메뉴 검색
 * - 메뉴 그룹 표시
 */

import java.util.ArrayList;
import java.util.List;

public class MenuGroup implements Menu {
    // 그룹의 이름 (예: "메인 메뉴", "학생 관리 메뉴")
    private String name;
    
    // 그룹이 아닌 단일 항목에만 부여되는 ID
    // 그룹은 ID가 없음 (자식을 선택하므로)
    private String id;
    
    // 이 그룹에 포함된 모든 메뉴 (항목과 그룹을 포함할 수 있음)
    private List<Menu> children;

    /**
     * MenuGroup 생성자
     * 
     * @param name 그룹의 이름
     * @param id 그룹의 ID (일반적으로 null, 자식 메뉴가 ID를 가짐)
     */
    public MenuGroup(String name, String id) {
        this.name = name;
        this.id = id;
        // 새로운 ArrayList를 생성하여 자식 메뉴를 저장할 준비
        this.children = new ArrayList<>();
    }

    /**
     * 자식 메뉴를 이 그룹에 추가하는 메서드
     * 
     * @param menu 추가할 메뉴 (MenuItem 또는 MenuGroup)
     */
    public void addChild(Menu menu) {
        children.add(menu);
    }

    /**
     * 특정 ID를 가진 메뉴를 찾는 메서드 (재귀적으로 검색)
     * 
     * @param id 찾을 메뉴의 ID
     * @return 찾은 메뉴, 없으면 null
     */
    public Menu findMenuById(String id) {
        // 이 그룹의 모든 자식을 순회
        for (Menu child : children) {
            // 현재 자식의 ID와 찾는 ID가 같으면 반환
            if (child.getId().equals(id)) {
                return child;
            }
            
            // 자식이 MenuGroup이면 재귀적으로 검색
            if (child instanceof MenuGroup) {
                Menu found = ((MenuGroup) child).findMenuById(id);
                if (found != null) {
                    return found;
                }
            }
        }
        
        // 찾지 못했으면 null 반환
        return null;
    }

    /**
     * 메뉴 그룹을 화면에 표시하는 메서드
     * 자식 메뉴들도 함께 표시
     * 
     * @param depth 트리 구조에서의 깊이 (들여쓰기 정도)
     */
    @Override
    public void display(int depth) {
        // depth에 따라 들여쓰기 추가
        String indent = getIndent(depth);
        
        // 그룹 이름 출력 (그룹 레벨에서는 선택번호 없음)
        System.out.println(indent + name);
        
        // 각 자식 메뉴를 depth + 1 레벨로 표시
        for (Menu child : children) {
            child.display(depth + 1);
        }
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
     * 메뉴 그룹은 실행할 명령이 없음
     * 사용자는 그룹을 선택하는 것이 아니라 그룹 내의 항목을 선택
     * 
     * @return 항상 true (프로그램 계속 진행)
     */
    @Override
    public boolean execute() {
        System.out.println("✗ 이 메뉴는 선택할 수 없습니다. 하위 메뉴를 선택하세요.");
        return true;
    }

    /**
     * 메뉴 그룹의 ID 반환
     * 그룹은 일반적으로 ID를 가지지 않으므로 null 반환
     * 
     * @return 그룹의 ID (null)
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * 이 그룹의 자식 메뉴 목록을 반환하는 메서드
     * 메뉴 순회 시 사용됨
     * 
     * @return 자식 메뉴 리스트
     */
    public List<Menu> getChildren() {
        return children;
    }
}
