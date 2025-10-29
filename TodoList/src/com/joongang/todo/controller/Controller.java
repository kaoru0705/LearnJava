package com.joongang.todo.controller;

import com.joongang.todo.service.Service;
import com.joongang.todo.util.IoManager;

// 현재: 전체 흐름을 담당한다.
// 나중에 스프링에서는 사용자 입출력 담당 (최전방)
public class Controller {
    
    private Service service = new Service();    // composition

    public void run() {
        welcome();

        while(true) {
            showMenu();
            String command = selectCommand();

            if(isExitCommand(command)) {
                break;
            }
            processCommand(command);
            pause();
        }
        bye();
    }

    private void welcome() {
        IoManager.println("********************************");
        IoManager.println("         TodoList        ");
        IoManager.println("          version3              ");
        IoManager.println("          2025.10.29            ");
        IoManager.println("********************************");
    }

    private void bye() {
        IoManager.println("프로그램이 종료됩니다.");
        IoManager.println("이용해주셔서 감사합니다.");
    }

    private void showMenu() {
        IoManager.println("[ 메뉴 ]");
        IoManager.println("1. 할 일 추가");
        IoManager.println("2. 전체 목록 보기");
        IoManager.println("3. 완료 처리");
        IoManager.println("4. 미완료만 보기");
        IoManager.println("5. 완료만 보기");
        IoManager.println("6. 제목 키워드 검색");
        IoManager.println("7. 삭제");
        IoManager.println("0. 프로그램 종료");
    }

    private String selectCommand() {
        String command = IoManager.input("선택 > ");
        return command;
    }

    // gpt한테 물어볼 때 주석 포함해서 물어보면 더 잘 대답한다.
    private boolean isExitCommand(String command) {
        return command.equals("0");
    }

    // method 위치 잡는 것도 가독성에 중요
    private void processCommand(String command) {
        if(command.equals("1")) {
            service.addStudent();
        } else if(command.equals("2")) {
            service.displayList();
        } else if(command.equals("3")) {
            service.UpdateIsCompleteByTodoAndDate();
        } else if(command.equals("4")) {
            service.displayByInComplete();
        } else if(command.equals("5")) {
            service.displayByComplete();
        } else if(command.equals("6")) {
            service.displayByTodo();
        } else if(command.equals("7")) {
            service.removeByTodoAndDate();
        }
        else {
            IoManager.println("잘못된 명령을 입력하셨습니다.");
            IoManager.println("다시 입력해주세요.");
        }
    }

    // 추상화 레벨을 맞췄다.
    private void pause()  {
        IoManager.pause();
    }
}