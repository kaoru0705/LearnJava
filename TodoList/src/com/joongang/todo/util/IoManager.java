package com.joongang.todo.util;

import java.util.Scanner;

import javax.swing.plaf.InputMapUIResource;

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

    public static String strDateInput(String text) {
        println("날짜를 입력하신다면 YYYY-mm-dd 형식으로 입력하세요.");
        print(text);

        String s = scanner.nextLine();
        while(!s.matches("\\d{4}-\\d{2}-\\d{2}") && !s.equals("")) {
            println("잘못된 형식 ");
            print(text);
            s = scanner.nextLine();
        }

        return s;
    }
}