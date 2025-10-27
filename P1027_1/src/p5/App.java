package p5;

public class App {
    public static void main(String[] args) {
        try {
            String str = "ㄹㄹㄹㄹㄹㄹ";
            str = str.substring(3);

            int a = 3/3;

            int[] arr = new int[5];
            arr[7] = 30;
            
        } catch (NullPointerException e) {
            System.out.println("NullPointerException이 발생했을 경우의 예외를 처리하는 코드");
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException이 발생했을 경우의 예외를 처리하는 코드");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException이 발생했을 경우의 예외를 처리하는 코드");
        } catch(Exception e) {
            e.printStackTrace(); // exception 정보 출력
            System.out.println(e.getMessage());
        }
        System.out.println("프로그램 종료");
    }
}
