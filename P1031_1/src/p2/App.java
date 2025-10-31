package p2;

public class App {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        Test2 t2 = new Test2();
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();
    }
}

class Test1 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            System.out.println("test1: " + i);
        }
    }
}

class Test2 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            System.out.println("test2: " + i);
        }
    }
}