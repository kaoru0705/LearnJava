package kdh.account.util;

import java.util.Scanner;

public class InOutSystem {
    private static Scanner scanner = new Scanner(System.in);

    public static String input(String question) {
        print(question);

        return scanner.nextLine();
    }
    
    public static String strInput(String question) {
        print(question);

        return noSpaceStr(question);
    }

    public static int IntegerInput(String question) {
        print(question);

        return getValidIntegerInput(question);
    }

    public static void print(String s) {
        System.out.print(s);
    }

    public static void println(String s) {
        System.out.println(s);
    }

    private static String noSpaceStr(String question) {
        String str = scanner.nextLine();
        while(str.length() == 0) {
            println("빈 문자열입니다. 다시 입력해주세요.");
            print(question);
            str = scanner.nextLine();
        }

        return str;
    }

    private  static int getValidIntegerInput(String question) {
        while(!scanner.hasNextInt()) {
            println("정수를 입력해주시기 바랍니다.");
            scanner.nextLine();
        }

        return Integer.parseInt(scanner.nextLine());
    }
}
