import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        
       //Scanner scanner = new Scanner(new InputStreamReader(System.in, Charset.forName("UTF-8")));
       Scanner scanner = new Scanner(new InputStreamReader(System.in, Charset.forName("MS949")));
       System.out.print("입력 > ");
       String input = scanner.nextLine();
       System.out.println("입력된 값: " + input);
    }
}

// terminal창에서 chcp 949로 code page를 바꿀 수 있다. chcp 65001