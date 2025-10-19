package resource.by.autocloseable;

class MyResource implements AutoCloseable {
    private String name;

    public MyResource(String name) {
        this.name = name;
        System.out.println("[MyResource(" + name + ") open");
    }

    public String read(boolean flag) {
        if(flag) {
            System.out.println("[MyResource(" + name + ") read]");
            return "100";
        } else {
            System.out.println("[MyResource(" + name + ") read]");
            return "abc";
        }
    }

    public String getName() {
        return this.name;
    }

    public void close() throws Exception {
        System.out.println("[MyResource(" + name + ") close]");
    }

}
public class Main {
    public static void main(String[] args) {
        try(MyResource res = new MyResource("A")) {
        String data = res.read(true);
        int value = Integer.parseInt(data);
        System.out.println("[MyResource(" + res.getName() + ") " + value + "]" ); 
        } catch(Exception e) {
            System.out.println(e);
        }
        System.out.println();
        try(MyResource res = new MyResource("B")) {
        String data = res.read(false);
        int value = Integer.parseInt(data);
        System.out.println("[MyResource(" + res.getName() + ") " + value + "]" ); 
        } catch(Exception e) {
            System.out.println(e);
        }
        MyResource res = new MyResource("C");
    }
}
