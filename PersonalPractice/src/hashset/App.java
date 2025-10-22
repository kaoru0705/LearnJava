package hashset;

import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("one");
        set.add("two");
        set.add("two");
        set.add("three");
        set.add("four");
        set.remove("four");
        System.out.println(set.contains("two"));
        System.out.println(set.size());
        set.clear();
        System.out.println(set.size());
    }
}
