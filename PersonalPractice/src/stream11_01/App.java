package stream11_01;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // for, 향상된 for, Iterator를 이용하여 컬렉션의 개별 원소를 탐색하는 것을 외부 반복(external iteration)
        // 람다식과 결합된 forEach 구문으로 탐색하는 것을 내부 반복(internal iteration)
        // 외부 반복은 내부 원소들을 외부에 있는 프로그램 코드에서 선언한 변수로 복사한 후 각 원소에 대해 필요한 작업을 처리한다.
        // 내부 반복은 필요한 코드를 람다식으로 만들어 컬렉션이나 배열에 넘겨서 그 내부에서 각 원소들을 처리하게 한다.
        // 내부 반복은 외부 반복에 비해 처리 속도가 빠르다.
        List<String> list = new ArrayList<>();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        list.forEach(e -> System.out.println(e));
    }
}
