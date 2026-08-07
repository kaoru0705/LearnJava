package thread12_04;

class MyThread extends Thread {
    public MyThread(String szName) {super(szName);}

    public void run() {
        for(int i = 0; i < 100; i++) {
            String num = String.valueOf(i);
            if (i < 10) num = "0" + String.valueOf(i);
            System.out.print(getName() + "(" + num + ") ");
        }
    }
}

public class App {
    public static void main(String[] args) {
        MyThread my_thread1 = new MyThread("thd1");
        MyThread my_thread2 = new MyThread("thd2");
        MyThread my_thread3 = new MyThread("thd3");

        my_thread1.setPriority(Thread.MIN_PRIORITY);
        my_thread2.setPriority(Thread.NORM_PRIORITY);
        my_thread3.setPriority(Thread.MAX_PRIORITY);

        my_thread1.start();
        my_thread2.start();
        my_thread3.start();

    }
}
