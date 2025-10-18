package lambda.consumer;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Consumer<String> con = t -> System.out.println("Hello " + t);
        con.accept("Java");
    }
}