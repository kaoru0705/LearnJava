public class P7 {
    public static void main(String[] args) {
        // 이중 배열
        int[][] arr = new int[3][4];

        arr[0][0] = 50;
        arr[1][2] = 70;

        // 진정한 의미에서 이중배열은 없다. page 212 arr은 arr[0] arr[1] arr[2]를 담는 배열을 가리킨다.
        // 힙 메모리에서 arr[0]은 첫 번째 int 4칸짜리 배열을 가리키는 참조타입. arr[1], arr[2]도 마찬가지.
        arr[0] = null;
        arr[0] = new int[2];

        for(int x = 0; x < arr.length; x++) {
            for(int y = 0; y < arr[x].length; y++) {
                arr[x][y] = 30;
            }
        }
    }
}
