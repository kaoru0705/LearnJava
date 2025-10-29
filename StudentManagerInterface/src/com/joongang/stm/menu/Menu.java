package com.joongang.stm.menu;
// 1.2. Menu 클래스 (Composite 패턴)
// 다른 MenuItem 객체(하위 메뉴 또는 실행 기능)들을 포함할 수 있는 컨테이너 역할을 합니다.
// 이것이 바로 상위 메뉴와 하위 메뉴를 계층적으로 구성하는 핵심입니다.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu implements MenuItem {
    private String name;
    private List<MenuItem> items = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public Menu(String name) {
        this.name = name;
    }

    public void add(MenuItem item) {
        items.add(item);
    }
    
    @Override
    public String getName() {
        return name;
    }

    // 메뉴를 출력하고 사용자 입력을 처리하여 하위 메뉴로 이동하거나 기능을 실행
    @Override
    public void execute() {
        while (true) {
            System.out.println("\n--- [" + name + "] 메뉴 ---");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i).getName());
            }
            System.out.println("0. 이전 메뉴로 돌아가기");

            System.out.print("선택: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기

                if (choice == 0) {
                    System.out.println("[" + name + "] 메뉴에서 돌아갑니다.");
                    break; // 루프 종료 = 이전 메뉴로 복귀
                } else if (choice > 0 && choice <= items.size()) {
                    // 선택된 하위 항목의 execute() 호출 (재귀적 호출)
                    items.get(choice - 1).execute();
                } else {
                    System.out.println("⚠️ 잘못된 입력입니다. 다시 선택해주세요.");
                }
            } else {
                System.out.println("⚠️ 숫자를 입력해주세요.");
                scanner.nextLine(); // 잘못된 입력 버리기
            }
        }
    }
}
