package generic.type.conversion1;

class Data<T> {
    private T t;

    public void set(T t) {this.t = t;}
    public T get() {return t;}
}

public class Main {
    public static void main(String[] args) {
        Data<Number> data = new Data<Number> ();
        // Data<Integer> doesn't extend Data<Number>
        // Data<Number> data1 = new Data<Integer>(); 
        data.set(new Integer(10));
        data.set(new Double(10.1));
        System.out.println(data.get());
    }
}