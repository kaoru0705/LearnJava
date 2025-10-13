import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        // 주제: 학생 정보 관리 프로그램
        // 기능: 학생 정보 등록, 목록, 삭제, 수정...
        Scanner scanner = new Scanner(System.in);

        // 환영 인사
        // sout tab으로 System.out.println()을 만들 수 있다.
        System.out.println("=============================");
        System.out.println("     학생 관리 프로그램 v1     ");
        System.out.println("          개발자: 강동훈    ");
        System.out.println("=============================");


        String[] nameList = new String[5];
        int[] ageList = new int[5];
        int[] scoreList = new int[5];

        int count = 0;

        while(true) {
            System.out.println("****메뉴****");
            System.out.println("1. 학생 정보 등록");
            System.out.println("2. 학생 정보 목록");
            System.out.println("3. 학생 정보 검색");
            System.out.println("4. 학생 정보 삭제");
            System.out.println("5. 학생 정보 수정");
            System.out.println("0. 프로그램 종료");

            System.out.print("명령어 입력 >");
            String command = scanner.nextLine();

            if(command.equals("0")) {
                System.out.println("학생 관리 프로그램을 종료합니다.");
                break;
            }

            if(command.equals("1")) {
                System.out.println("[테스트 로그] 학생 등록 로직 수행");

                if (count == nameList.length) {
                    String[] newNameList = new String[count * 2];
                    int[] newAgeList = new int[count * 2];
                    int[] newScoreList = new int[count * 2];

                    for(int copyIndex = 0; copyIndex < count; copyIndex++) {
                        newNameList[copyIndex] = nameList[copyIndex];
                        newAgeList[copyIndex] = ageList[copyIndex];
                        newScoreList[copyIndex] = scoreList[copyIndex];
                    }

                    nameList = newNameList;
                    ageList = newAgeList;
                    scoreList = newScoreList;
                }

                System.out.print("이름 입력 > ");
                String name = scanner.nextLine();

                while(name.equals("")) {
                    System.out.print("이름에 제대로된 문자열을 입력하세요. > ");
                    name = scanner.nextLine();
                }
                nameList[count] = name;

                System.out.print("나이 입력 > ");

                // String strAge = null;
                // while(true)
                // {   
                //     boolean isIntger = true;

                //     strAge = scanner.nextLine();
                //     for (int strIndex = 0 ; strIndex < strAge.length(); strIndex++) {
                //         if(strAge.charAt(strIndex) < '0' || strAge.charAt(strIndex) > '9') {
                //             isIntger = false;
                //             System.out.print("나이를 다시 입력하세요. > ");
                //             break;
                //         }
                //     }

                //     if(strAge.length() != 0 && isIntger == true) {
                //         break;
                //     }
                // }
                // ageList[count] = Integer.parseInt(strAge);

                // String strAge = scanner.nextLine();
                while (!scanner.hasNextInt()) {
                    System.out.println("숫자를 입력하세요.");
                    System.out.print("나이 입력 > ");
                    scanner.nextLine();
                }
                ageList[count] = Integer.parseInt(scanner.nextLine());

                System.out.print("점수 입력 > ");
                while (!scanner.hasNextInt()) {
                    System.out.println("숫자를 입력하세요.");
                    System.out.print("점수 입력 > ");
                    scanner.nextLine();
                }
                scoreList[count] = Integer.parseInt(scanner.nextLine());

                count++;
            } else if(command.equals("2")) {
                System.out.println("[테스트 로그] 학생 목록 로직 수행");
                for(int index = 0; index < count; index++) {
                    System.out.println("학생의 이름: " + nameList[index] + " 나이: " + ageList[index] + " 점수: " + scoreList[index]);
                }
            } else if(command.equals("3")) {
                System.out.println("[테스트 로그] 학생 검색 로직");
                System.out.print("검색할 학생의 이름: > ");
                String searchName = scanner.nextLine();
                int searchCount = 0;
                System.out.println("이름이 " + searchName + "인 학생은 ");
                for(int searchIndex = 0; searchIndex < count; searchIndex++) {
                    if(nameList[searchIndex].equals(searchName)) {
                        System.out.println("\t나이: " + ageList[searchIndex] + " 점수: " + scoreList[searchIndex]);
                        searchCount++;
                    }
                }
                if(searchCount == 0) {
                    System.out.println("등록된 학생이 없습니다.");
                } else {
                    System.out.println("으로 " + searchCount + "명 존재합니다.");
                }
            } else if(command.equals("4")) {
                System.out.println("[테스트 로그] 학생 삭제 로직");
                System.out.print("삭제할 이름은? > ");
                String deletedName = scanner.nextLine();
                boolean isDelete = false;
                boolean isCancel = false;
                for (int nameIndex = 0; nameIndex < count; nameIndex++) {
                    if(nameList[nameIndex].equals(deletedName)) {
                        System.out.print("삭제할 이름을 찾았습니다.\n마지막으로 묻습니다. 정말 삭제하시겠습니까? (Y/N) > ");
                        String guest = scanner.nextLine();
                        while(!guest.equals("n") && !guest.equals("N") && !guest.equals("y") && !guest.equals("Y")) {
                            System.out.print("(Y/N) 중 하나를 입력하세요. > ");
                            guest = scanner.nextLine();
                        }
                        if(guest.equals("n") || guest.equals("N")) {
                            System.out.println("삭제하지 않기로 했습니다.");
                            isCancel = true;
                            break;
                        }
                    }

                    if(nameList[nameIndex].equals(deletedName)) {
                        for(int deletedIndex = nameIndex; deletedIndex < count - 1; deletedIndex++) {
                            nameList[deletedIndex] = nameList[deletedIndex + 1];
                            ageList[deletedIndex] = ageList[deletedIndex + 1];
                            ageList[deletedIndex] = scoreList[deletedIndex + 1];
                        }
                        nameIndex--;
                        System.out.println("삭제되었습니다.");
                        count--;
                        isDelete = true;
                    }
                }

                if(!isDelete && !isCancel) {
                    System.out.println("존재하지 않는 이름입니다.");
                }
            } else if(command.equals("5")) {
                System.out.println("[테스트 로그] 학생 정보 수정 로직");
            } else {
                System.out.println("번호를 잘못 입력하셨습니다.");
                System.out.println("다시 입력 바랍니다.");
                continue;
            }

            System.out.println("계속 입력하시려면 enter를 눌러주세요.");
            scanner.nextLine();
        }

        scanner.close();
    }
}
