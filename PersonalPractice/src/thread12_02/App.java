package thread12_02;

class MyThread implements Runnable {
    public void run() {System.out.println("Thread");}
}

public class App {
    public static void main(String[] args) {
        Thread my_thread = new Thread(new MyThread());
        my_thread.start();
    }
}
