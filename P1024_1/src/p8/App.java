package p8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) {
        // Date말고... 이젠 LocalDate를 사용하자..
        // 가변객체라 
        Date date = new Date();
        date.setDate(2);
        System.out.println(date);

        new AAA().test();

        // new LocalDateTime() 같은 생성자가 없다. 요즘 클래스는 생성자가 없음
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime when = LocalDateTime.of(2024, 5, 3, 0, 0, 0);

        System.out.println(today);
        System.out.println(when);

        System.out.println((today.minusDays(10)));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        String text = today.format(dtf);

        System.out.println(text);
    }
}
/** */
class AAA {
    /**   
     * 안녕하세요!!
     */
    public void test() {
        
    }
}
