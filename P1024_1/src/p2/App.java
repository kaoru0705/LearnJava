package p2;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        // String... Immutable
        // java에서 요구하는 게 불변객체를 만드는 것 - 안전성 측면에서 유리(스레드 등등 포함)
        // String 불변객체 값을 변경 시키는 메서드 혹은 그에 준하는 연산자 수행 시 새로운 메모리를 생성
        // Integer, Long, Double Wrapper 클래스들은 전부 불변
        // LocalDate, LocalTime, LocalDateTime	자바 8 날짜/시간 API도 전부 불변

        String text = "안녕하세요";

        long time = System.currentTimeMillis(); // 1970년 1월 1일 0시 0분 0초 000ms.. 부터 지금까지 지난 ms
        // System.out.println(time/1000/60/60/24/365); // 55년
        
        for(int i = 0; i < 100000; i++) {
            text += "야호!!";
        }

        //System.out.println(text);
        System.out.println("첫번째: " + (System.currentTimeMillis() - time) + "ms");
        

        // StringBuilder, StringBuffer
        // 가변 객체
        // 전문적으로 글자를 늘리는 솔루션 등등에 사용
        // stringBuilder는 내부에 넉넉한 배열을 만들고 추가한다. 허나 꽉차면 더 늘릴 것이다.
        // 처음부터 배열의 사이즈를 1000으로 늘림
        // StringBuilder sb = new StringBuilder(1000);
        StringBuilder stringBuilder = new StringBuilder("안녕하세요");
        
        time = System.currentTimeMillis();

        for(int i = 0; i < 100000; i++) {
            stringBuilder.append("야호!!");
        }
        
        // object의 toString을 입력된 문자열 반환으로 오버라이딩 했다.
        String resultText  = stringBuilder.toString();
        //System.out.println(resultText);

        System.out.println("두번째: " + (System.currentTimeMillis() - time) + "ms");
        
        // StringBuffer가 아주 살짝 더 느림. 허나 스레드에 안정적
        StringBuffer stringBuffer = new StringBuffer();

        for(int i = 0; i < 100000; i++) {
            stringBuffer.append("야호!!");
        }
        

    }
}
