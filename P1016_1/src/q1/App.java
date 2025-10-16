package q1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        final int c = scanner.nextInt();
        final int d = scanner.nextInt();
        final int e = scanner.nextInt();
        final int f = scanner.nextInt();
        final int x = scanner.nextInt();
        final Runner takahashi = new Runner(b, a, c);
        final Runner aoki = new Runner(e, d, f);

        final Race race = new Race(x, takahashi, aoki);
        race.simulate();

        scanner.close();
    }
}

class Race {
    private final int totalRunningTime;
    private final Runner takahashi;
    private final Runner aoki;

    
    public Race(final int totalRunningTime, final Runner takahashi, final Runner aoki) {
        this.totalRunningTime = totalRunningTime;
        this.takahashi = takahashi;
        this.aoki = aoki;
    }
    
    public void simulate() {
        for(int i = 0; i < totalRunningTime; i++) {
            takahashi.process();
            aoki.process();
        }
        displayWinner();
    }

    private void displayWinner() {
        if(takahashi.getDistance() == aoki.getDistance()) {
            System.out.println("Draw");
        } else if(takahashi.getDistance() > aoki.getDistance()) {
            System.out.println("Takahashi");
        } else {
            System.out.println("Aoki");
        }
    }
    
    
}

class Runner {
    private final int speed;
    private final int workTime;
    private final int restTime;
    
    private int distance = 0;
    private int currentRunTime = 0;
    private int currentRestTime = 0;
    private boolean isRest = false;

    public Runner(final int speed, final int workTime, final int restTime) {
        this.speed = speed;
        this.workTime = workTime;
        this.restTime = restTime;
    }

    public int getDistance() {
        return distance;
    }

    public void process() {
        if(isRest) {
            rest();
        } else {
            run();
        }
    }

    private void run() {
        distance += speed;
        currentRunTime++;
        if(currentRunTime == workTime) {
            isRest = true;
            currentRunTime = 0;
        }
    }

    private void rest() {
        currentRestTime++;
        if(currentRestTime == restTime) {
            isRest = false;
            currentRestTime = 0;
        }
    }
}