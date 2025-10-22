package stream11_23;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Arrays.asList("20 10 90", "30 70", "60 80 40")
            .stream()
            .flatMapToInt(e -> Arrays.stream(e.split(" "))
            .mapToInt(number -> Integer.parseInt(number)))
            .forEach(number -> System.out.println(number));
    }
}
