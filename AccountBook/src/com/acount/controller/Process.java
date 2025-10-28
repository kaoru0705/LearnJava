package com.acount.controller;

import com.account.service.*;
import com.account.util.IoManager;;

public class Process {
    private service service = new service();

    public void setProcess(boolean isProcess) {
        introduceAccount();

        while (isProcess) {
            displayMenu();

            String command = selectCommand();
            if (isExitCommand(command)) {
                break;
            }
            process(command);
            pause();
        }

        endAccount();
    }

    private void process(String command) {

        if (command.equals("1")) {
            service.createAccountDto();
        } else if (command.equals("2")) {
            service.displayAllList();
        } else if (command.equals("3")) {
            service.deleteAccountDto();
        } else if (command.equals("4")) {
            service.displayByCategory();
        } else if (command.equals("5")) {
            service.displayByDesceneding();
        } else if (command.equals("6")) {
            service.displayByMemo();
        } else {
            IoManager.println("번호를 잘못 입력하셨습니다.");
            IoManager.println("다시 입력 바랍니다.");
        }
    }

    private String selectCommand() {
        return IoManager.input("명령어 입력 >");
    }

    private boolean isExitCommand(String command) {
        return command.equals("7");
    }

    private void introduceAccount() {
        IoManager.println("=============================");
        IoManager.println("     가계부 프로그램 v2     ");
        IoManager.println("          개발자: 강동훈    ");
        IoManager.println("=============================");
    }

    private void displayMenu() {
        IoManager.println("****메뉴****");
        IoManager.println("1. 거래 등록 (수입/지출)");
        IoManager.println("2. 거래 목록 및 합계");
        IoManager.println("3. 거래 삭제");
        IoManager.println("4. 카테고리별 합계");
        IoManager.println("5. 금액 내림차순 보기");
        IoManager.println("6. 검색(메모 키워드)");
        IoManager.println("7. 종료");
        IoManager.println("==============================");
    }

    private void endAccount() {
        IoManager.println("가계부 관리 프로그램을 종료합니다.");
    }

    private void pause() {
        IoManager.input("계속 입력하시려면 enter를 눌러주세요.");
    }
}
