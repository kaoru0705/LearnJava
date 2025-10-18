package kdh.stm.process;

import java.util.ArrayList;
import java.util.List;

import kdh.stm.dto.StudentDto;
import kdh.stm.util.IoManager;
import kdh.stm.service.Service;

public class Process {
    private Service service = new Service();

    public void setProcess(boolean isProcess) {
        introduceStm();

        while (isProcess) {
            displayMenu();

            String command = selectCommand();
            if (isExitCommand(command)) {
                break;
            }
            process(command);
            pause();
        }

        endStm();
    }

    private void process(String command) {

        if (command.equals("1")) {
            service.createStudentDto();
        } else if (command.equals("2")) {
            service.displayAllList();
        } else if (command.equals("3")) {
            service.searchStudentDto();
        } else if (command.equals("4")) {
            service.deleteStudentDto();
        } else if (command.equals("5")) {
            service.updateStudentDto();
        } else {
            IoManager.println("번호를 잘못 입력하셨습니다.");
            IoManager.println("다시 입력 바랍니다.");
        }
    }

    private String selectCommand() {
        return IoManager.input("명령어 입력 >");
    }

    private boolean isExitCommand(String command) {
        return command.equals("0");
    }

    private void introduceStm() {
        IoManager.println("=============================");
        IoManager.println("     학생 관리 프로그램 v2     ");
        IoManager.println("          개발자: 강동훈    ");
        IoManager.println("=============================");
    }

    private void displayMenu() {
        IoManager.println("****메뉴****");
        IoManager.println("1. 학생 정보 등록");
        IoManager.println("2. 학생 정보 목록");
        IoManager.println("3. 학생 정보 검색");
        IoManager.println("4. 학생 정보 삭제");
        IoManager.println("5. 학생 정보 수정");
        IoManager.println("0. 프로그램 종료");
    }

    private void endStm() {
        IoManager.println("학생 관리 프로그램을 종료합니다.");
    }

    private void pause() {
        IoManager.input("계속 입력하시려면 enter를 눌러주세요.");
    }
}
