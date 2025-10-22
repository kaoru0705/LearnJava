package stream11_07;
import java.util.stream.*;
import java.util.Set;
import java.util.HashSet;

// collection 인터페이스의 서브 인터페이스 , Set, List, Queue 인터페이스를 구현한 HashSet, ArrayList, LinkedList 클래스는
// collection 인터페이스의 stream()과 parallelStream()이 디폴트 메소드로 구현되어 있기 때문에 스트림 가능하다.
public class App {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 10; i++) {
            set.add(i);
        }

        
        System.out.println("일반 스트림 사용");
        set.stream().forEach(e -> System.out.println(e));

        System.out.println("병렬 스트림 사용");
        Stream<Integer> p_stream = set.parallelStream();
        p_stream.forEach(e -> System.out.println(e + "(" + Thread.currentThread().getName() + ")"));
        System.out.println("야호");
    }
}
