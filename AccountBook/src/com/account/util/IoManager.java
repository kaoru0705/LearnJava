package com.account.util;

import java.util.Scanner;

public class IoManager {
    private static Scanner scanner = new Scanner(System.in);

    private IoManager() {
    };

    public static String input(String text) {
        print(text);

        return scanner.nextLine();
    }

    public static String strInput(String text) {
        print(text);

        return requireNonEmpty(text);
    }

    public static int integerInput(String text) {
        print(text);

        return Integer.parseInt(requireIntegerString(text));
    }

    public static String YesOrNoInput(String text) {
        print(text);

        return requireYesOrNoString();
    }

    public static void print(String text) {
        System.out.print(text);
    }

    public static void println(String text) {
        System.out.println(text);
    }

    private static String requireNonEmpty(String text) {

        String strInput = scanner.nextLine();

        while (strInput.equals("")) {
            println("빈 문자열입니다.");
            print(text);
            strInput = scanner.nextLine();
        }

        return strInput;
    }

    private static String requireIntegerString(String text) {

        while (!scanner.hasNextInt()) {
            println("숫자가 아닙니다.");
            print(text);
            scanner.nextLine();
        }

        return scanner.nextLine();
    }

    private static String requireYesOrNoString() {
        String guest = scanner.nextLine();
        while (!guest.toUpperCase().equals("N") && !guest.toUpperCase().equals("Y")
                && !guest.toUpperCase().equals("YES") && !guest.toUpperCase().equals("NO")) {
            IoManager.print("(Y/N) 중 하나를 입력하세요. > ");
            guest = scanner.nextLine();
        }

        return guest;
    }

}