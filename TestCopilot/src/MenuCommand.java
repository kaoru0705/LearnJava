/**
 * 실행할 메뉴 명령을 나타내는 인터페이스
 * Command 패턴을 사용하여 메뉴 선택 시 실행할 동작을 정의
 * 
 * SRP: 이 인터페이스는 오직 "명령 실행"이라는 하나의 책임만을 가짐
 */
public interface MenuCommand {
    /**
     * 명령을 실행하는 메서드
     * 각 메뉴에 해당하는 기능을 이곳에서 수행
     * 
     * @return 프로그램을 계속 진행하면 true, 종료하면 false
     */
    boolean execute();
}
