public class P3 {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
        // arr1 = null;
        int[] arr2 = arr1;

        arr1[0] = 30;
        arr2[0] = 40;

        // 같은 힙메모리를 참조하고 있으므로 같게 나온다.
        System.out.println(arr1[0]);
        System.out.println(arr2[0]);

    }
}
