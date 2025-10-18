import java.util.Iterator;

public class NestedClassTest {
    private final static int SIZE = 15;
    private int[] data = new int[SIZE];

    public NestedClassTest () {
        for(int i = 0; i < SIZE; i++) {
            data[i] = i;
        }
    }

    public void printEven() {
        EvenIterator iterator = this.new EvenIterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    private class EvenIterator implements Iterator<Integer> {
        private int nextIndex = 0;

        public boolean hasNext() {
            return (nextIndex < SIZE);
        }

        public Integer next() {
            Integer ret = Integer.valueOf(data[nextIndex]);
            nextIndex += 2;
            return ret;
        }
    }

    public static void main(String[] args) {
        NestedClassTest nc = new NestedClassTest();
        nc.printEven();
    }
}
