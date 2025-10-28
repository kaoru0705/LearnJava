package p3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) {
        Queue<OrderDto> queue = new LinkedList<>();
        queue.offer(new OrderDto());
        Deque<OrderDto> deque = new ArrayDeque<>();
    }
}

class OrderDto {
    String name;
    //...
}
