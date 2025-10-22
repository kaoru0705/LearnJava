package p6;

public class App {
    public static void main(String[] args) {
        QQQ qqq1 = (a) -> Math.sqrt(a);

        double result1 = qqq1.calculate(10);
        System.out.println(result1);

        QQQ qqq2 = Math::sqrt;
        double result2 = qqq2.calculate(9);

        System.out.println(result2);

        QQQ log1 = Math::log;

        double resultLog1 = log1.calculate(25);
        System.out.println(resultLog1);
    }
}

interface QQQ {
    public double calculate(int a);
}
