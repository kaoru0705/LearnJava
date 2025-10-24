package p7;

import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception{
            // 각 데이터간 변환
        // 문자 <-> 숫자
        // 숫자 <-> 날짜
        // 날짜 <-> 문자

        // 1. 숫자 -> 문자
        {
            int value = 15;
            String result = value + "";
            String result1 = String.valueOf(value); // 추천
            String result2 = Integer.toString(value);
        }
        // 2. 문자 -> 숫자
        {
            String value = "27";
            int result = Integer.parseInt(value);
        }
        // 3. 숫자 -> 날짜
        {
            int value = 912833;
            Date result = new Date(value);
        }
        // 4. 날짜 -> 숫자
        {
            Date value = new Date();
            long result = value.getTime();
        }
        // 5. 문자 -> 날짜
        {   
            // java는 2025-10-03 안됨
            String value = "2025/10/03";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date result = sdf.parse(value);
            System.out.println(result);
        }
        // 6. 날짜 -> 문자
        {
            Date value = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
            String result = sdf.format(value);
            System.out.println(result);
        }
    }
}
