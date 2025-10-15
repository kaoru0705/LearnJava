package P3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        Calculator calculator = new Calculator();

        int inputStart = 77;
        int inputEnd = 1500;
        System.out.println(calculator.SumFromTo(inputStart, inputEnd));


    }
}

class IoManager {
    String input(String text) {
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();

        return inputValue;
    }
}

class Calculator {
    int SumFromTo(int start, int end) {
        int sum = 0;
        for(int i = start; i <= end; i++) {
            sum += i;
        }

       return sum;
    }
}

// data를 다루는 클래스를 DTO
// 한 기능을 다루는 클래스 Component?