package p1;

public class App {
    public static void main(String[] args) throws Exception{
        new Test().qqqq();
    }
}

class Test {
    // Recursive Method
    private int count = 0;
    public void qqqq() throws Exception{
        Thread.sleep(100);
        count++;
        if(count > 10) return;

        System.out.println("qqqqq 시작" + count);
        qqqq();
        System.out.println("qqqqq 끝" + count);
    }
}
