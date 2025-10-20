package p4;

import java.util.Stack;

public class App {
    public static void main(String[] args) {
        // 요일... 과 관련된 프로그램

        Day currentDay = Day.SUNDAY;

        if(currentDay == Day.SUNDAY) {
            System.out.println("SUNDAY");
        }
        if(0 == Day.SUNDAY.getValue()) {
            System.out.println("SUNDAY");
        }
    }
}

// enum = 도메인을 정의한다. (도메인 한정된 정보의 범위)
enum Day {
    SUNDAY(0),
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6);

    private int value;

    Day(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}