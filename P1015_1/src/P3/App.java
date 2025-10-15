package P3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        IoManager ioManager = new IoManager();
        Calculator calculator = new Calculator();

        String value = ioManager.input("값 입력 > ");
        ioManager.output("입력된 값 = " + value);


        int inputStart = 77;
        int inputEnd = 1500;
        System.out.println(calculator.SumFromTo(inputStart, inputEnd));

        


    }
}

class IoManager {
    Scanner scanner = new Scanner(System.in);

    String input(String text) {
        System.out.print(text);
        String inputValue = scanner.nextLine();

        return inputValue;
    }

    void output(String text) {
        System.out.println(text);
    }
}

// class Calculator {
//     int sum = 0;
//     int SumFromTo(int start, int end) {
//         sum = 0; // 초기화는 일반적으로 생성자를 통해서만 하는 게 낫다.

//         for(int i = start; i <= end; i++) {
//             accumulate(i);
//         }
    
//        return sum;
//     }

//     void accumulate(int i) {
//         sum += i;
//     }
// }

class Calculator {
    int SumFromTo(int start, int end) {
        
        int sum = 0;
        for(int i = start; i <= end; i++) {
            sum = this.accumulate(sum, i); // this 생략 가능
        }
    
       return sum;
    }

    int accumulate(int sum, int i) {
        sum += i;
        return sum;
    }
}

// data를 다루는 클래스를 DTO
// 한 기능을 다루는 클래스 Component?