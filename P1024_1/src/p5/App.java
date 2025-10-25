package p5;

public class App {
    public static void main(String[] args) {
        // 정규표현식 - 대부분의 언어, 데이터베이스에서 지원함 regex
        // 문자를 ... 
        String accountName = "0Java"; // id
        //{3} 무조건 3글자
        // {3,5} 사이
        // {3,} 3글자 이상
        String test = "[a-fA-Z0-9가-힣ㄱ-ㅎ\\]]{3,5}";
        // 알파벳은 3글자 숫자는 2글자
        String test1 = "[a-zA-Z]{3}[0-9]{2}";
        // [^abc] abc 포함 안함
        String test2 = "[^abc]";
        // [\\d] 숫자로만 [\\D] 숫자가 아니어야 됨
        String test3 = "\\d{3}";
        // a부터 z까지는 적어도 한 글자 이상이고 맨끝은 숫자여야 됨 "aaaaaaaaaaaaaaaa0"
        String test4 = "[a-z]+[0-9]";
        // a부터 z까지 없어도 되고 있어도 됨 맨끝은 숫자여야 됨
        String test5 = "[a-z]*[0-9]";
        // ^대괄호 바깥이면 해당문자열로 시작 "Java"만 됨 [a-z]* 추가하면?
        String test6 = "^Java[a-z]*";
        // Java로 끝나야함
        String test7 = "[a-z0-9]+Java$";
        
        if(accountName.matches(test7)) {
            System.out.println("패턴에 부합합니다.");
        } else {
            System.out.println("패턴에 부합하지 않습니다.");
        }

    }
}
