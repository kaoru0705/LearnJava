package p2;

public class App {
    public static void main(String[] args) {
        // String API
        String str1 = "aaaa, bbb, ccc";
        String str2 = str1.toUpperCase();
        System.out.println(str2);

        String searchWord = "bts";
        String targetWord = "Bts";

        // APi return type부터 보고 이해하기
        searchWord.contains(targetWord);
        String[] arr = searchWord.split(",");
        // 앞뒤 공백 제거
        String result = "  fff f  ".trim();
        // 시작하는지
        "dafaef".startsWith("da");
        System.out.println(result);
        // endIndex - 1
        result = "aefafawef".substring(3, 5);
        System.out.println(result);

        "aefawfaf".indexOf("f");

        String filename = "C:/aaaa/bbbb/qwer.jpg";
        String ext = filename.substring(filename.lastIndexOf('.'));
        System.out.println(ext);

        ////////////////////////////////////////////////////////////
        /// static method
        int a = 10;
        int b = 20;
        String aaa = String.valueOf(a);

        String str5 = a + " X " + b + "=" + (a*b);
        String str6 = String.format("%d 곱하기 %d는 %d입니다.", a, b, a*b);
        System.out.println(str6);

        
        String[] qqqq = {"안녕하세요", "반갑습니다", "야호"};
        // 배열을 한 문장으로 바꿔줌
        result = String.join(",",qqqq);
        System.out.println(result);

        
    }
}
