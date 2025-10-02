import java.util.Scanner;
public class Casino {
    public static void main(String[] args) {
        // 카지노
        // 초기 자본은 1000원을 준다.
        // 총 n개의 게임 중 골라서 게임을 진행 가능. 배팅이 가능하다.
        // 홀짝, 가위바위보, 단순 로또, 업앤다운
        // 퇴장을 하거나, 모든 돈을 잃으면 게임이 끝난다.
        int coin = 1000;

        Scanner scanner = new Scanner(System.in);

        System.out.println("***********************************");
        System.out.println("*               중앙 카지노             *");
        while(true) {
            System.out.println("다음 중 진행할 게임을 선택하세요.");
            System.out.println("1. 홀짝");
            System.out.println("2. 가위바위보");
            System.out.println("3. 로또");
            System.out.println("4. 업앤다운");
            System.out.println("0. 끝내기");
            System.out.print("선택 > ");
            String command = scanner.nextLine();
            // 왜 0과 1을 else if 잇지 않았나? 개념이 달라서 구분한다.
            if (command.equals("0")) {
                break;
            }
            if (command.equals("1")) {
                System.out.println("------- 홀짝 게임 -------");
                System.out.print("배팅액 입력(남은 돈:"+coin+") > ");
                int bet = Integer.parseInt(scanner.nextLine());
                
                coin -= bet;

                System.out.println("홀 혹은 짝을 선택해주세요 > ");
                System.out.println("1. 홀");
                System.out.println("2. 짝");
                System.out.print("입력 > ");
                String even = scanner.nextLine();
                
                int result = (int)(Math.random() * 2) + 1;
                String strResult = result + "";

                String textResultEven = result == 1 ? "홀" : "짝";
                System.out.println(textResultEven + "이 나왔습니다.");

                if(strResult.equals(even)) {
                    System.out.println("당신은 이겼습니다.");
                    coin += bet * 2;
                } else {
                    System.out.println("당신은 졌습니다.");
                }
                
            } else if (command.equals("2")) {
                System.out.println("------- 가위바위보 -------");
                System.out.print("배팅액 입력(남은 돈:"+coin+") > ");
                int bet = Integer.parseInt(scanner.nextLine());
                
                coin -= bet;
                
                System.out.println("가위 바위 보 중에 하나를 고르세요 > ");
                System.out.print("입력 > ");
                String strUserSelectedHand = scanner.nextLine();
                while(!strUserSelectedHand.equals("가위") && !strUserSelectedHand.equals("바위") && !strUserSelectedHand.equals("보")) {
                    System.out.print("입력이 잘못됐습니다. 다시 입력해 주세요 > ");
                    strUserSelectedHand = scanner.nextLine();
                }

                int computerSelectedHand = (int)(Math.random() * 3);
                String strComputerSelectedHand = "";
                if(computerSelectedHand == 0) strComputerSelectedHand = "가위";
                else if(computerSelectedHand == 1) strComputerSelectedHand = "바위";
                else if(computerSelectedHand == 2) strComputerSelectedHand = "보";
                else System.out.println("[Log]Error");

                System.out.println(strComputerSelectedHand + "가 나왔습니다.");
                
                boolean isWinner = true;
                if(strUserSelectedHand.equals(strComputerSelectedHand)) {
                    System.out.println("무승부입니다.");
                    System.out.println("배팅액에 절반을 돌려 드리겠습니다.");
                    coin += bet / 2;
                    continue;
                } else if(strUserSelectedHand.equals("가위")) {
                    if(strComputerSelectedHand.equals("바위")) isWinner = false;
                } else if(strUserSelectedHand.equals("바위")) {
                    if(strComputerSelectedHand.equals("보")) isWinner = false;
                } else if(strUserSelectedHand.equals("보")) {
                    if(strComputerSelectedHand.equals("가위")) isWinner = false;
                }
                if(isWinner) {
                    System.out.println("당신은 이겼습니다.");
                    coin += bet * 2;
                } else System.out.println("당신은 졌습니다.");
                
            } else if (command.equals("3")) {
                break;
            } else if (command.equals("4")) {
                System.out.println("------- 업앤다운 -------");
                System.out.println("숫자는 0~46사이의 값이 있습니다.");
                System.out.println("총 시도 횟수는 5입니다.");

                System.out.print("베팅금액 입력(가진돈: "+coin+") > ");
                int bet = Integer.parseInt(scanner.nextLine());
                coin -= bet;

                int targetNumber = (int)(Math.random() * 47);
                boolean isRight = false;
                for(int i = 5; i > 0; i--) {
                    System.out.print("예상 값을 입력하세요. ("+i+"회 남음) > ");
                    int guessNumber = Integer.parseInt(scanner.nextLine());
                    if(targetNumber > guessNumber) {
                        System.out.println("업!");
                    } else if(targetNumber < guessNumber) {
                        System.out.println("다운!");
                    } else {
                        System.out.println("정답입니다!!! 승리하셨습니다.");
                        coin += bet * 3;
                        isRight = true;
                        break;
                    }
                }
                if (!isRight) {
                    System.out.println("정답을 맞추지 못하셨습니다. 패배");
                }

            } else {
                System.out.println("잘못된 값을 입력하셨습니다. 다시 시도해주세요.");
            }

            // ... 게임 종료 시점
            if (coin <= 0) {
                System.out.println("모든 돈을 잃었습니다.");
                break;
            }

            System.out.println("계속 진행하시려면 enter를 입력해주세요");
            scanner.nextLine();
        }
        
        System.out.println("이용해주셔서 감사합니다. 게임을 종료합니다.");
        

    }
}
