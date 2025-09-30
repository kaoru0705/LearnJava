public class P3 {
    public static void main(String[] args) {
        // 문자열... 기본타입 아님
        String a = "안녕\"하세\\요!!!";

        System.out.println(a);
        
        // 좀 최신이라 안 쓰는 게 나을 수도 있음
        String c = """
                안녕하세요!!!
                안녕하세요!!!
                안녕하세요!!!
                안녕하세요!!!
                안녕하세요!!!
                안녕하세요!!!
                """;
        System.out.println(c);
        
    }
}
