package p10;

public class App {
    public static void main(String[] args) {
        
    }
}

class QQQ {
    public void test() {

    }
}

// 컴파일러가 오버라이딩 어노테이션을 보고 overriding을 안 했을 경우 에러를 일으킴.
// 안전성과 가독성 둘 다 챙김
class YYY extends QQQ {
    @Override
    public void tset() {

    }
}