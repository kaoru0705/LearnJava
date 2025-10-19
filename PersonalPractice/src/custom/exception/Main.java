package custom.exception;

public class Main {
    public static void main(String[] args) {
        MyClass mc = new MyClass();
        try {
            mc.testFunc(20);
        } catch(MyException e) {
            System.out.println(e);
        }
    }
}

class MyException extends Exception {
    public MyException() {
        super();
    }
    public String toString() {
        return "MyException";
    }
}

class MyClass {
    public void testFunc(int x ) throws MyException {
        if(x > 10) throw new MyException();
    }
}
