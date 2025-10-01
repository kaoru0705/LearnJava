public class P4 {
    public static void main(String[] args) {
        // 3항 연산자 ternary operator
        int score = 78;
        // ? : 이게 하나의 연산자. 항만 3개
        String result = score >= 60 ? "합격" : "불합격";
        
        // 밑에 예시는 3항 연산자 권고
        // String result = "";

        // if(score >= 60) {
        //     result = "합격";
        // } else {
        //     result = "불합격";
        // }

        // 3항 연산자 두 번 연속으로 쓸 거면 그냥 if else 써라 그래도 두 번까지는 허용되는 범위
        System.out.println(result + "입니다.");

    }
}
