/**
 * 메뉴 항목의 공통 인터페이스
 * 컴포지트 패턴을 구현하여 단일 항목(MenuItem)과 그룹(MenuGroup)을 동일하게 취급
 */
public interface Menu {
    /**
     * 메뉴를 화면에 표시하는 메서드
     * 
     * @param depth 트리 구조에서의 깊이 (들여쓰기 표현)
     */
    void display(int depth);

    /**
     * 사용자가 선택했을 때 실행되는 메서드
     * 
     * @return 프로그램을 계속 진행하면 true, 종료하면 false
     */
    boolean execute();

    /**
     * 메뉴 항목의 ID를 반환하는 메서드
     * 사용자의 입력이 이 ID와 일치할 때 실행됨
     * 
     * @return 메뉴의 ID (선택번호)
     */
    String getId();
}
