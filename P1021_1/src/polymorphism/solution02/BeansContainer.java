package polymorphism.solution02;

// 인스턴스 생성 관리, 조립 - 다른 기능 없음
// 설정에 해당하는 클래스 = 나중에 프레임워크에 따라 xml, json, 어노테이션 설정

public class BeansContainer {
    // factory
    // public Tv getTv(String name) {
    //     if(name.equals("samung")) {
    //         return new SamsungTv();
    //     } else if(name.equals("lg")) {
    //         return new LgTv();
    //     }
    //     return null;
    // }

    // Container
    private User user;
    public BeansContainer() {
        // 설정 및 조립 설정
        // IoC
        Speaker speaker = new AppleSpeaker();
        Tv tv = new LgTv(speaker); // DI
        user = new User(tv); // DI
    }

    public User getUser() {
        return user;
    }
}
