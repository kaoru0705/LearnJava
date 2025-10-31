package p1;

// 프로세스간은 기본적으로 메모리를 공유하지 않는다. 프로세스간 통신은 가능
// 하나의 프로세스의 여러 개의 스레드로 동시에 실행되는 것처럼 만들 수 있다.
public class App {
    public static void main(String[] args) {
        // 메인 스레드가 실행되고 서브 스레드가 생성되고 실행됨
        // 하나의 프로세스는 모든 스레드가 끝나야 종료된다.

        // start()가 실행돼야 스레드 생성
        new Test1().start();
        new Test2().start();

        new Thread(new Test3()).start();

        // Runnable을 이용하면 메소드를 동기식으로 돌릴지 비동기식으로 돌릴지 선택할 수 있다.
        // print();
        new Thread(App::print).start();


        System.out.println("메인 스레드 종료!!");
        
    }

    public static void print() {
        for(int i = 0; i < 100; i++) {
            System.out.println("하하하!!!" + i);
        }
    }
}

class Test1 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            System.out.println("야호!!!" + i);
        }
    }
}

class Test2 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            System.out.println("으아아!!!" + i);
        }
    }
}

class Test3 implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            System.out.println("히이익!!!" + i);
        }
    }
}