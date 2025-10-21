package arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 선형 리스트 연결 리스트를 배열기반으로 만듦
        // 내부적으로는 처음 배열크기를 넉넉하게 잡고 size()는 추가한 개수만큼만 반환
        // 당연히 특정 값을 제거하거나 삽입하면 느리다. 크기가 너무 커져도 그렇다.

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
