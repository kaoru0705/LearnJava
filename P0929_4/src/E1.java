// 197page PrimitiveAndStringConversionExample
public class E1 {
    public static void main(String[] args) {
        // 문자열을 다른 type으로 바꾸기
        int value1 = Integer.parseInt("10");
        double value2 = Double.parseDouble("3.14");
        boolean value3 = Boolean.parseBoolean("false");

        System.out.println("value1: " + value1);
        System.out.println("value2: " + value2);
        System.out.println("value3: " + value3);

        // 문자열이 아닌 형태를 문자열로 만들기
        String str1 = String.valueOf(10);
        String str2 = String.valueOf(3.14);
        String str3 = String.valueOf(true);

        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str3: " + str3);
    }
}
