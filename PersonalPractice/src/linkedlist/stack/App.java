package linkedlist.stack;
import java.util.LinkedList;
import java.util.NoSuchElementException;
public class App {
    public static void main(String[] args) {
        // 이중 연결 리스트다. 그러니 큐 스택 둘 다 가능함. 당연히 데이터 접근속도는 배열 리스트에 비해 느릴 수밖에 없다. 삽입혹은 삭제는 빠르다.
        // pointer로 그부분만 바꿔주면 되니
        LinkedList<String> stack = new LinkedList<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");

        try {
            while(true) System.out.println(stack.pop());
        } catch (NoSuchElementException e) {
            System.out.println("stack is empty");
        }
    }
}
