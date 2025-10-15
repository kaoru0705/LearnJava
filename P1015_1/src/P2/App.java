package P2;

public class App {
    public static void main(String[] args) {
        Test t1 = new Test(2 , 3);
        t1.plus(1, 4);


    }
}
// 클래스의 property를 메소드들을 통해 활용함으로써 응집도(coheision)을 높인다.
class Test {
    int a; 
    int b;

    Test (int a, int b) {
        this.a = a;
        this.b = b;
    }

    int plus(int c, int d) {
        if(a < 0) return -1;

        int result = this.a + this.b + c + d;
        return result;
    }
}
