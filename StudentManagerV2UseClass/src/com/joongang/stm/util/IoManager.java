package com.joongang.stm.util;

import java.util.Scanner;

public class IoManager {
    private static Scanner scanner = new Scanner(System.in);

    private IoManager() {};

    public static String input(String text) {
        print(text);
        return scanner.nextLine();
    }

    public static void println(String text) {
        System.out.println(text);
    }

    public static void print(String text) {
        System.out.print(text);
    }

    public static void pause() {
        print("계속 진행하시려면 enter를 입력하세요.");
        scanner.nextLine();
    }

    public static int intgerInput(String text) {
        print(text);

        while(!scanner.hasNextInt()) {
            print("정수를 입력해주세요. > ");
            scanner.nextLine();
        }

        int number = scanner.nextInt();
        scanner.nextLine();

        return number;
    }
}