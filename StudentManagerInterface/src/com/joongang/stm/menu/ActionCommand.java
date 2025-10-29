package com.joongang.stm.menu;

// 1.3. ActionCommand 클래스 (실제 기능)
// 실제로 데이터를 처리하는 가장 낮은 레벨의 메뉴 항목입니다. 이는 MenuItem을 구현하며, execute() 메서드에 실제 로직이 들어갑니다.

public class ActionCommand implements MenuItem {
    private String name;
    private Runnable action; // 실행할 실제 로직 (Lambda 사용 가능)

    public ActionCommand(String name, Runnable action) {
        this.name = name;
        this.action = action;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        System.out.println(">> 기능 실행: " + name);
        action.run(); // 실제 로직 실행
    }
}