public class P2 {
    public static void main(String[] args) {
        // double보다는 int연산이 빠르므로 1을 밖으로 빼는 게 낫다.
        // int value = (int)(Math.random() * 6 + 1);
        int value = (int)(Math.random() * 6) + 1;
        int value2 = (int)(Math.random() * 20) + 40;

        System.out.println(value);
        System.out.println(value2);
        
        // if는 순서가 중요하다. 뒤에 있는 조건문일 수록 많은 조건을 거친다.
        if(value == 1) {
            System.out.println("1일 때 실행될 로직들...");
        } else if(value == 2) {
            System.out.println("2일 때 실행될 로직들...");
        } else if(value == 3) {
            System.out.println("3일 때 실행될 로직들...");
        } else if(value == 4) {
            System.out.println("4일 때 실행될 로직들...");
        } else if(value == 5) {
            System.out.println("5일 때 실행될 로직들...");
        } else { // else if(value == 6) { 이라고 적는 게 낫다. 나머지가 6으로 정확히 나올 걸 알아도 실무에서 else는 Error 느낌이 강하다.
            System.out.println("6일 때 실행될 로직들...");
        }
        // else {
        //   System.out.println("[log]Error");
        // }
        
    }
}
