package p6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws Exception{
        Thread.ofVirtual().start(()-> {
            System.out.println("헬로!!!");
        });

        ExecutorService executor = Executors.newFixedThreadPool(10);

        executor.submit(() -> {
            System.out.println("실행 코드 !!");
        });

        Thread.sleep(3000);
        System.out.println("메인 스레드 종료");
    }
}
