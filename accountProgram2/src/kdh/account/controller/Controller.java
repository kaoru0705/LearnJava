package kdh.account.controller;

import kdh.account.service.*;
import kdh.account.util.*;

public class Controller {
    private Service service = new Service();

    public void process() {
        introduce();
        while(true) {
            displayMenu();
            String command = InOutSystem.strInput("선택할 기능을 골라주세요. > ");
            if(isExitCommand(command)) break;
            run(command);

            pause();

        }

        goodBye();
        
    }

    private void introduce() {
        InOutSystem.println("안녕하세요. 가계부 프로그램입니다.");
        InOutSystem.println("==============================");
    }

    private void displayMenu() {
        InOutSystem.println("1. 거래 등록 (수입/지출)");
        InOutSystem.println("2. 거래 목록 및 합계");
        InOutSystem.println("3. 거래 삭제");
        InOutSystem.println("4. 카테고리별 합계");
        InOutSystem.println("5. 금액 내림차순 보기");
        InOutSystem.println("6. 검색(메모 키워드)");
        InOutSystem.println("7. 종료");
        InOutSystem.println("==============================");
    }

    private boolean isExitCommand(String command) {
        return command.equals("7");
    }

    private void run(String command) {
        if(command.equals("1")) {
            service.addTransaction();
        } else if(command.equals("2")) {
            service.displayTransactionList();
        } else if(command.equals("3")) {
            service.deleteTransaction();
        } else if(command.equals("4")) {
            
        } else if(command.equals("5")) {
            
        } else if(command.equals("6")) {
            
        } else {
            InOutSystem.println("잘못된 커맨드");
            InOutSystem.println("다시 입력하시기 바랍니다.");
        }
    }

    private void goodBye() {
        InOutSystem.println("프로그램이 종료되었습니다. 안녕히 계세요.");
    }

    private void pause() {
        InOutSystem.input("계속 하시려면 enter를 입력하세요");
    }
}