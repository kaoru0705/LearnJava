package kdh.stm;

import java.util.*;
import kdh.stm.util.IoManager;

public class App {
    public static void main(String[] args) throws Exception {
        // 주제: 학생 정보 관리 프로그램
        // 기능: 학생 정보 등록, 목록, 삭제, 수정...

        IoManager.println("=============================");
        IoManager.println("     학생 관리 프로그램 v2     ");
        IoManager.println("          개발자: 강동훈    ");
        IoManager.println("=============================");

        List<String> nameList = new ArrayList<>();
        List<Integer> ageList = new ArrayList<>();
        List<Integer> scoreList = new ArrayList<>();

        int count = 0;

        while (true) {
            IoManager.println("****메뉴****");
            IoManager.println("1. 학생 정보 등록");
            IoManager.println("2. 학생 정보 목록");
            IoManager.println("3. 학생 정보 검색");
            IoManager.println("4. 학생 정보 삭제");
            IoManager.println("5. 학생 정보 수정");
            IoManager.println("0. 프로그램 종료");

            String command = IoManager.input("명령어 입력 >");

            if (command.equals("0")) {
                IoManager.println("학생 관리 프로그램을 종료합니다.");
                break;
            }

            if (command.equals("1")) {
                IoManager.println("[테스트 로그] 학생 등록 로직 수행");

                String name = IoManager.strInput("이름 입력 > ");

                nameList.add(name);

                ageList.add(IoManager.integerInput("나이 입력 > "));

                scoreList.add(IoManager.integerInput("점수 입력 > "));

                count++;
            } else if (command.equals("2")) {
                System.out.println("[테스트 로그] 학생 목록 로직 수행");
                for (int index = 0; index < count; index++) {
                    System.out.println("학생의 이름: " + nameList.get(index) + " 나이: " + ageList.get(index) + " 점수: "
                            + scoreList.get(index));
                }
            } else if (command.equals("3")) {
                IoManager.println("[테스트 로그] 학생 검색 로직");
                String searchName = IoManager.strInput("검색할 학생의 이름: > ");
                int searchCount = 0;
                IoManager.println("이름에 " + searchName + "이(가) 포함되는 학생은 ");
                for (int searchIndex = 0; searchIndex < count; searchIndex++) {
                    if (nameList.get(searchIndex).contains(searchName)) {
                        IoManager.println("\t이름: " + nameList.get(searchIndex) + " 나이: "
                                + ageList.get(searchIndex) + " 점수: " + scoreList.get(searchIndex));
                        searchCount++;
                    }
                }
                if (searchCount == 0) {
                    IoManager.println("등록된 학생이 없습니다.");
                } else {
                    IoManager.println("으로 총 " + searchCount + "명 있습니다.");
                }
            } else if (command.equals("4")) {
                IoManager.println("[테스트 로그] 학생 삭제 로직");
                String deletedName = IoManager.strInput("삭제할 이름은? > ");
                boolean isDelete = false;
                boolean isCancel = false;
                for (int nameIndex = 0; nameIndex < count; nameIndex++) {
                    if (nameList.get(nameIndex).equals(deletedName)) {
                        String guest = IoManager.YesOrNoInput();

                        if (guest.toUpperCase().equals("N") || guest.toUpperCase().equals("NO")) {
                            IoManager.println("삭제하지 않기로 했습니다.");
                            isCancel = true;
                            break;
                        }
                    }

                    if (nameList.get(nameIndex).equals(deletedName)) {
                        nameList.remove(nameIndex);
                        ageList.remove(nameIndex);
                        scoreList.remove(nameIndex);
                        nameIndex--;
                        IoManager.println("삭제되었습니다.");
                        count--;
                        isDelete = true;
                    }
                }

                if (!isDelete && !isCancel) {
                    IoManager.println("존재하지 않는 이름입니다.");
                }
            } else if (command.equals("5")) {
                IoManager.println("[테스트 로그] 학생 정보 수정 로직");
            } else {
                IoManager.println("번호를 잘못 입력하셨습니다.");
                IoManager.println("다시 입력 바랍니다.");
                continue;
            }

            IoManager.input("계속 입력하시려면 enter를 눌러주세요.");
        }
    }
}