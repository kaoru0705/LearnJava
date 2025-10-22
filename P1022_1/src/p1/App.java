package p1;
// inner class 내부에서만 존재하는 클래스

public class App {
    public static void main(String[] args) {
        
    }
}

class AAA {
    public void testA() {
        int a = 10;
        int b = 20;
        
        // 강사님은 이런 코드 본 적 없다고 한다.
        // 가독성이 안 좋다.
        class BBB {
            public void testB() {
                
            }
        }

        BBB bbb = new BBB();
        bbb.testB();

        System.out.println("ffff");
    }
}
