package p6;

import java.util.Date;

// class 생성으로 p6.App이라 하면 패키지랑 클래스를 만들어 준다.
public class App {
    public static void main(String[] args) {
        // 날짜 - 사실상 숫자
        // Date -> LocalDate, LocalDateTime, LocalTime
        Date date = new Date(); // 현재 시간(날짜)
        System.out.println(date);

        // KST = UTC + 9
        Date aaa = new Date(0);
        System.out.println(aaa);

        System.out.println(date.getYear());
        // month 0부터 시작
        System.out.println(date.getMonth());
        // 날
        System.out.println(date.getDate());
        // 0은 일요일
        System.out.println(date.getDay());

        System.out.println(new Date(0).equals(new Date(0)));
    }
}