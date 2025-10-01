public class P3 {
    public static void main(String[] args) {
        int value = 4;

        // 정확히 분기라기보단 Jump다. 일반적인 switch case는 분기가 목적이기 때문에 break문을 사용
        switch(value) {
            case 1:
                System.out.println("1일 때 쓸 로직");
                break;
            case 2:
                System.out.println("2일 때 쓸 로직");
                break;
            case 3:
                System.out.println("3일 때 쓸 로직");
                break;
            default:
                System.out.println(".... 나머지 실행 로직");
        }
    }
}
