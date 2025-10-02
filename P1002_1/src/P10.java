public class P10 {
    public static void main(String[] args) {
        // 정렬... 선택정렬
        int[] arr = {3, 1, 5, 9, 8, 6, 2, 7, 4};
        
        for(int x = 0; x < arr.length - 1; x++) {
            int minIndex = x;
            for(int y = x; y < arr.length; y++) {
                if(arr[minIndex] > arr[y]) {
                    minIndex = y;
                }
            }
            int temp = arr[x];
            arr[x] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for(int e : arr) {
            System.out.println(e);
        }
    }
}
