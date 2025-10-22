package stream11_10;
import java.util.*;
import java.util.stream.*;

// HashMap은 Map인터페이스를 구현하는 클래스로 스트림과 관련된 메소드는 구현되어 있지 않다.
// 허나 HashMap 클래스에는 Set 인터페이스형 객체를 생성하는 entrySet() 메소드가 구현되어 있어
// HashMap형으로 생성된 객체도 스트림을 이용하여 내부반복 가능하다
public class App {
    public static void main(String[] args) {
        Map<String, Integer> books = new HashMap<>();
        books.put("Java 프로그래밍", 10000);
        books.put("JDBC 프로그래밍", 20000);
        books.put("JSP 프로그래밍", 15000);

        Set<Map.Entry<String, Integer>> entries = books.entrySet();
        System.out.println("일반 스트림 사용");
        Stream<Map.Entry<String, Integer>> ns = entries.stream();
        ns.forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));

    }
}
