public class P5 {

    public static void main(String[] args) {
        Student3 s1 = new Student3("철수");
        Student3 s2 = new Student3("영희");

        s1.study(3);
        s2.study(1);
        s1.study(2);
        s2.study(1);
        s1.study(5);
        s2.study(1);
        int a = 10;

        s1.printResult();
        s2.printResult();

    }
}

class Student3 {
    String name;
    int totalTime;
    int score;

    Student3(String name) {
        this.name = name;
    }

    void study(int hour) {
        this.totalTime += hour;
        this.score += hour * 3;
    }

    void printResult() {
        System.out.println(this.name + "은 " + this.score + "점입니다.");
    }
}