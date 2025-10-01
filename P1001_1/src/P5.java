public class P5 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        if(a == b) {
            //...
        }
        
        String s1 = "안녕하세요";
        String s2 = "안녕하세요";
        if(s1 == s2) {
            // 문자열은 ==으로 비교하면 안됨
        }
        if(s1.equals(s2)) {
            // 문자열은 equals method로 비교해야 함 (API)
        }
    }
}
