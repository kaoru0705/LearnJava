public class P12 {
    public static void main(String[] args) {
        // 에라스토테니스의 체 소수 구하기
        // 무언가가 소수였으면 그것을 제외한 그것의 배수는 소수가 아니다.
        // https://ko.wikipedia.org/wiki/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98_%EC%B2%B4
        // index가 number다. 0과 1은 소수 판별 X
        boolean[] arr = new boolean[101];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = true;
        }

        for(int number = 2; number < arr.length; number++) {
            if(arr[number]) {
                System.out.print(number + " ");
                for(int i = number * 2; i < arr.length; i += number) {
                    arr[i] = false;
                }
            }
        }

    }
}
