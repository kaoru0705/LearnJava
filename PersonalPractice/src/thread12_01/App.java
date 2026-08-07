package thread12_01;

class MyThread extends Thread {
    public void run() {System.out.println("Thread");}
}

public class App {

    public static void main(String[] args) {
        MyThread my_thread = new MyThread();
        my_thread.start();
    }
}
