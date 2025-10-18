package generic.type.limit;

class Data<T extends Number> {
    private T t;

    public Data(T t) {this.t = t;}
    public void set(T t) {this.t = t;}
    public T get() {return t;}
}

public class Main {
    public static void main(String[] args) {
        Data<Integer> data = new Data<Integer>(20);
        
        System.out.println(data.get());
    }
}
