package p5;

import java.util.*;

public class App {
    public static void main(String[] args) {
        // 하루 일과 프로그램...
        new Controller().run();
        Map<String, Integer> termsMap = new HashMap<> ();
        
    }

}

// class Controller {
//     private Service service = new Service();
//     public void run() {
//         System.out.println("하루 일과를 시작합니다.");
//         // Service에서 기능을 확장했더니 실행시키는 쪽도 수정해야 한다. -> Container, Factory 
//         service.wakeUp();
//         service.eat();
//     }
// }

// class Service {
//     public void wakeUp() {
//         System.out.println("일어납니다.");
//     }
//     public void eat() {
//         System.out.println("밥을 먹습니다.");
//     }
// }

class Controller {
    private ServiceContainer serviceContainer = new ServiceContainer();

    public void run() {
        System.out.println("하루 일과를 시작합니다.");
        for(Service service : serviceContainer.getServiceList()) {
            service.process();
        }
    }
}

interface Service {
    public void process();
}

class WakeUpService implements Service {
    @Override
    public void process() {
        System.out.println("일어납니다.");
    }
}

class EatService implements Service {
    public void process() {
        System.out.println("밥을 먹습니다.");
    }
}

class StudyService implements Service {
    public void process() {
        System.out.println("공부를 합니다.");
    }
}

class ServiceContainer {
    private List<Service> list = new ArrayList<>();

    public ServiceContainer() {
        list.add(new WakeUpService());
        list.add(new EatService());
        list.add(new StudyService());
    }

    public List<Service> getServiceList() {
        return list;
    }
}