import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
public class P12 {
    public static void main(String[] args) {
        // API
        // 출력
        System.out.println("안녕하세요!!!");
        System.out.print("야호!!!");
        System.out.print("야호!!!");

        // 입력
        Scanner scanner = new Scanner(System.in);
        System.out.println("입력 테스트!!");
        System.out.print("나이 입력 > ");
        String inputValue = scanner.nextLine(); // 입력 API 문자 반환
        
        int age = Integer.parseInt(inputValue); // 중요한 API 문자 -> 숫자. 단 변경 불가능한 문자일 경우 Exception 발생
        // API는 못 외운다.
        
        if (age < 20) {
            System.out.println("성인이 아닙니다!! 돌아가세요!!");
        } else {
            System.out.println("성인입니다 수업을 들을 수 있습니다.");
        }
        
        System.out.println("프로그램 종료!!!");
        // Shortcut ctrl + ` = toggle terminal
        
    }
}
