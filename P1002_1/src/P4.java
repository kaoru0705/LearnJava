public class P4 {
    public static void main(String[] args) {
        // Exception in thread "main" java.lang.NullPointerException: Cannot store to int array because "arr1" is null
        // int[] arr1 = null;
        // arr1[0] = 10;
        int[] arr1 = null;

        // heap은 scope가 끝난다고 제거되는 게 아니다.
        // 다만 arr2만이 참조하고 있으므로 scope가 지나 arr2가 사라지면 연쇄적으로 참조하고 있던 힙도 가비지 콜렉터가 소멸시켰다.
        {
            int[] arr2 = new int[5];
            arr2[0] = 30;
            // 이게 추가된다면? 가비지가 되지 않는다.
            // arr1 = arr2;
        }
        // ...
        // stack memory가 살아있어도 heap memory를 없앨 수 있는 법
        // arr1 = null;
    }
}
