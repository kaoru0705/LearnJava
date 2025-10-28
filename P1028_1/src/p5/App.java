package p5;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i < 6; i++) {
            list.add((int)(Math.random() * 46) + 1);
        }
        
        System.out.println(list);
    }
}
