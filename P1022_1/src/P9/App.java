package P9;

public class App {
    public static void main(String[] args) {
        new Some().test(() -> {
            System.out.println("사용자의 알고리즘!!");
        });

        new Some().test(() -> {
            System.out.println("사용자의 또다른 알고리즘!!");
        });
    }
}

interface Consumer {
    public void qqqqqq();
}

class Some {
    public void test(Consumer aaaa) {
        System.out.println("test 시작 알고리즘..");

        // 여기 알고리즘은 내가 짤 수 없어
        // 알고리즘, 로직 건네기
        aaaa.qqqqqq();

        System.out.println("test 마무리 알고리즘..");
    }
}
