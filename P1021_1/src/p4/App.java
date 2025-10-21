package p4;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        ServiceContainer serviceContainer = new ServiceContainer();

        // 학생 관리 프로그램
        System.out.println("반갑습니다.");
        
        while(true) {
            System.out.println("메뉴");
            System.out.println("1. ...");
            System.out.println("2. ...");
            System.out.println("3. ...");
            System.out.println("0. 종료");

            String command = "0";

            if(command.equals("0")) break;

            // if(command.equals("1")) {}
            // else if (command.equals("2")) {}
            // else if (command.equals("3")) {}
            // // "4"을 추가하는 것도 힘들다.

            // Controller는 command가 몇이든 알 바가 아니다. 기능 확장해도 if문 추가하고 그럴 필요가 없다.
            // 학생정보프로그램에서도 controller까지 전부 건드려야 됨. 기능 확장을 하려고 사용하는 쪽(controller)에서도 건드려야 한다. 확장하는 곳만 수정할 수 있게 만들어라.
            // OCP: 개방 폐쇠 원칙 - 기능의 확장은 열려있고 수정에는 닫혀있어야 한다.
            Service service = serviceContainer.getService(command);
            service.run();
        }
    }
}

interface Service {
    public void run();
}

class StudentAddService implements Service {
    public void run() {
        // 학생 등록 로직...
    }
}

class StudentListService implements Service {
    public void run() {
        // 학생 목록 출력 로직...
    }
}

class StudentSearchService implements Service {
    public void run() {
        // 학생 검색 로직...
    }
}

class StudentRemoveService implements Service {
    public void run() {
        // 학생 삭제 로직...
    }
}

//....

class ServiceContainer {
    private Map<String, Service> map = new HashMap<>();

    public ServiceContainer() {
        map.put("1", new StudentAddService());
        map.put("2", new StudentListService());
        // ...
        map.put("4", new StudentRemoveService());
    }

    public Service getService(String command) {
        return map.get(command);
    }
}