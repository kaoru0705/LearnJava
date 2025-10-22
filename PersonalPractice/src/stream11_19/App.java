package stream11_19;
// 생성된 스트림에 어떤 처리를 하면 그 결과로 새로운 스트림이 만들어지는데 이 과정을 '스트림 파이프라인'이라고 한다.
// 새로운 스트림을 만들어 내는 모든 처리를 '중간연산' 또는 '중간처리'라고 하고,
// 새로운 스트림을 만드는 대신 집계값을 리턴하는 처리를 '종료연산' 또는 '최종처리'라고 한다.
// 중간연산에는 1.filtering, 2.mapping, 3.sorting, 4.looping이 있다. 

import java.util.Arrays;

// filtering계에서는 distinct()와 filter()가 있다.
// distinct는 기본형 타입일 경우 값으로 비교해서 중복제거, 참조형 타입일 경우 같은 객체 일 때 중복제거 한다.
// filter()는 Predicate method를 구현해야 한다. 입력 있음 반환 boolean
public class App {
    public static void main(String[] args) {
        // String 배열을 IntStream으로 변환
        String[] strNums = {"10", "20", "30"};
        Arrays.stream(strNums)
            .mapToInt(e -> Integer.parseInt(e))
            .forEach(e -> System.out.println(e));
        
        // int 배열을 Stream<String>으로 변환
        int[] numbers = {10, 20, 30};
        Arrays.stream(numbers)
            .mapToObj(e -> String.valueOf(e))
            .forEach(e -> System.out.println(e + "(" + e.length() + ")"));
    }
}
