package p3;

public class App {
    public static void main(String[] args) throws Exception{
        // 비동기시 주의 사항
        // 상당수 스레드는 데이터를 공유하지 않음 -> 편하게 비동기 코드 작성해도 됨
        // 여러 스레드 혹은 비동기 코드가 메모리를 공유하면... 많이 힘듦... 동기화 필수
        // 동기화는 병목현상을 야기함
        // 비동기 코드는 동기화하면 할수록 ... 왜 비동기로 만들었는지 의문이 들 수밖에 없다.
        // 동기화 필요 시... 최소한으로만 범위 지정해서 동기화 코드 작성해야 함

        Test1 t1 = new Test1();
        t1.start();
        Test1 t2 = new Test1();
        t2.start();

        t1.join();  // join 동기화 메서드 - t1 스레드가 끝날 때까지 기다림
        t2.join();  // join 동기화 메서드 - t2 스레드가 끝날 때까지 기다림

        System.out.println(Data.count);
    }
}

class Test1 extends Thread {

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            Data.increaseCount();
        }
    }
}

class Data {
    public static int count = 0;
    public synchronized static void increaseCount() { // 메소드 동기화 시키기
        // ... 시간 오래걸리는 코드 이 때 제어권을 다른 스레드에게 넘김
        int temp = count;
        // System.out.println("어떤 코드"); // 일부러 오버헤드 발생 시킬 목적
        int a = 10;
        a++;
        a++; 
        a++;

        temp++;
        count = temp;
    }
}