package p6;

import java.util.Date;

// class 생성으로 p6.App이라 하면 패키지랑 클래스를 만들어 준다.
public class App {
    public static void main(String[] args) {
        // 날짜
        // Date -> LocalDate, LocalDateTime, LocalTime
        Date date = new Date(); // 현재 시간(날짜)
        System.out.println(date);
    }
}