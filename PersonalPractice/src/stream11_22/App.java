package stream11_22;
import java.util.*;
// flatMap 한 원소를 여러 개의 원소로 변환
public class App {
    public static void main(String[] args) {
        Arrays.asList("Hello world, this is java.", "Welcome to java world!")
            .stream()
            .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
            .forEach(word -> System.out.println(word));
    }
}
