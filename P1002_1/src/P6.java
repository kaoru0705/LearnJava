public class P6 {
    public static void main(String[] args) {
        int[] arr = new int[10];

        // 객체 접근연산자 . 배열은 객체다.
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 6) + 1;
        }
    }
}
