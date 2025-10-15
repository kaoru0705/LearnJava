package P4;

public class App {
    public static void main(String[] args) {
        SumCalc1 sc1 = new SumCalc1();
        int result1 = sc1.sum(1, 10);

        SumCalc2 sc2 = new SumCalc2(1, 10);
        int result2 = sc2.getResult();
        int result3 = new SumCalc2(1, 10).getResult();

        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);
        System.out.println("result3: " + result3);
        System.out.println(new SumCalc2(1, 10).getResult());

    }
}

class SumCalc1{
    int sum(int start, int end) {
        int sum = 0;
        for(int i = start; i <= end; i++) {
            sum += i;
        }

        return sum;
    }
}

class SumCalc2{
    int sum = 0;
    int start = 0;
    int end = 0;

    // 흔치않지만 이렇게 짜는 사람이 꽤 있다.
    SumCalc2(int start, int end) {
        for(int i = start; i <= end; i++) {
            sum += i;
        }
    }

    int getResult() {
        return sum;
    }


}