interface Pair<K, V> {
    public K getKey();
    public V getValue();
}

class OrderedPair<K, V> implements Pair <K, V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {return key;}
    public V getValue() {return value;}
}

class Data<T> {
    private T t;
    public Data(T t) {this.t = t;}
    public void set(T t) {this.t = t;}
    public T get() {return t;}
}

public class MultipleType {
    public static void main(String args[]) {
        Pair<String, Data<Integer>> p1;
        p1 = new OrderedPair<>("Even", new Data<Integer>(8));

        System.out.println(p1.getKey());
        System.out.println(p1.getValue().get());
    }
}
