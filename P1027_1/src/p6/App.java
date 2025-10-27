package p6;

public class App {
    /* Exception in thread "main" java.lang.ArithmeticException: / by zero
        at p6.Repository.repositoryMethod(App.java:24)
        at p6.Service.serviceMethod(App.java:18)
        at p6.Controller.controllerMethod(App.java:12)
        at p6.App.main(App.java:5)
        아래부터 읽기
    */
    public static void main(String[] args) {
        new Controller().controllerMethod();
        System.out.println("프로그램 종료");
    }
}

class Controller {
    public void controllerMethod() {
        new Service().serviceMethod();
    }
}

class Service {
    public void serviceMethod() {
        try {
            new Repository().repositoryMethod();
        } catch (Exception e) {
            System.out.println("에러 처리...");
        } finally {
            // 그 어떠한 경우에도 실행됨. catch문에 return을 넣어도 실행된다.
            // 사실상 다른 용도로는 잘 안 쓰고... 자원 반납.
            // scanner.close();
            System.out.println("finally에서 실행됨");
        }
        System.out.println("서비스 끝!!!");
    }
}

class Repository {
    public void repositoryMethod(){
        int result = 10/0;
        System.out.println(result);
    }
}