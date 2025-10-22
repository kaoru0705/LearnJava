package stream11_24;
import java.util.Comparator;
import java.util.stream.*;
public class App {
    public static void main(String[] args) {
        Stream.of(20, 10, 90, 30, 70, 60, 80, 40)
            .sorted((a, b) -> a - b)
            .forEach(number -> System.out.println(number));
    }
}
