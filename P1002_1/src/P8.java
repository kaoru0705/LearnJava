public class P8 {
    public static void main(String[] args) {
        // 고전 for문은 실무에서는 거의 사용되지 않는다.

        int[] arr = new int[10];

        // foreach, 향상된 for문
        for(int element  : arr) {
            System.out.println(element);
        }
    }
}
