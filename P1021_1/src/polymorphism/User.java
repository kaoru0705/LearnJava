package polymorphism;

public class User {

    public void watchTv() {
        System.out.println("사용자의 티비 시청 시작!!");
        // interface 없이 LgTv 와 SamsungTv를 만들고 삼성에서 엘지로 바꾼다면?
        // 의존도가 너무 높다. api부터 전부 바꾸고 통일해야 한다.
        SamsungTv tv = new SamsungTv();
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
        System.out.println("사용자의 티비 시청 끝!!");
    }
}


