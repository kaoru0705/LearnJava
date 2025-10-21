package linkedlist.queue;
import java.util.LinkedList;
public class App {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("four");
        // queue.add("five"); // add 실패 시 예외 처리 offer는 실패 시 false
        // remove 실패 시 예외 처리
        // poll은 null 반환

        String s = queue.poll();
        while(s != null) {
            System.out.println(s);
            s = queue.poll();
        }
    }
}
