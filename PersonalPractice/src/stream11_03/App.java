package stream11_03;
import java.util.*;
import java.util.stream.*;
public class App {
    public static void main(String[] args) {
        String[] strArray = {"홍길동", "이순신", "김유신"};
        Stream<String> strStream = Arrays.stream(strArray);

        strStream.forEach(str -> System.out.println(str));

    }
}
