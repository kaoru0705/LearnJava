package P9;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Account myAccount = new Account();
        myAccount.deposit(500);
        myAccount.withdraw(800);
        int cash = myAccount.withdraw(300);
        System.out.println("내 호주머니에 있는 돈: " + cash);
    }
}

class Account {
    private int balance = 0;
    private String owner = "";
    private String userPassword;
    private Scanner scanner = new Scanner(System.in);

    public Account() {
        System.out.println("계좌 생성하기를 진행하겠습니다.");
        System.out.print("계좌를 소유할 분의 성함을 입력해주세요. > ");
        owner = scanner.nextLine();
        System.out.print("계좌 비밀번호를 설정해주세요. > ");
        userPassword = scanner.nextLine();
    }

    public void deposit(int cash) {
        System.out.print(owner + " 님 계좌의 비밀번호를 입력해주세요. > ");
        String password = scanner.nextLine();

        if (isCorrectedPassword(password)) {
            System.out.println(cash + "원이 정상적으로 입금되었습니다.");
            balance += cash;
        } else {
            System.out.println("패스워드가 틀렸습니다.");
        }
    }

    public int withdraw(int cash) {
        if(cannotWithDraw(cash)) {
            System.out.println("출금 오류: " + owner + "님 계좌의 잔액이 부족합니다.");
            return 0;
        }
        System.out.print(owner + " 님 계좌의 비밀번호를 입력해주세요. > ");
        String password = scanner.nextLine();

        if (isCorrectedPassword(password)) {
            System.out.println(cash + "원이 출금되었습니다.");
            balance -= cash;
            System.out.println("남은 잔액은 " + balance + "원입니다.");

            return cash;
            
        } else {
            System.out.println("패스워드가 틀렸습니다.");
            return 0;
        }
    }

    

    public int getBalance() {
        return balance;
    }

    private boolean cannotWithDraw(int cash) {
        return balance < cash;
    }
    private boolean isCorrectedPassword(String password) {
        return userPassword.equals(password);
    }
}
