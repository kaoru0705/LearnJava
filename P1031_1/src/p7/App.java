package p7;

import java.util.Vector;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> list = new Vector<>();
        // ArrayList랑 비슷한데 synchronized가 전부 붙어있다.
        list.add("1111");
        list.add("1111");
        list.add("1111");
        list.add("1111");
        list.add("1111");


    }
}
