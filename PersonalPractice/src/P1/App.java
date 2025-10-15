package P1;

public class App {
    public static void main(String[] args) {
        MyString str = new MyString();
        System.out.println(str.length());
        System.out.println(str.getString());

        str.setString("Hello Java");
        System.out.println(str.getString());
        System.out.println(str.length());
        System.out.println(str.compareTo("Hello Java"));

        MyString str2 = new MyString("Test");
        MyString str3 = new MyString(512);

        System.out.println(str2.getString());
        System.out.println(str3.getString());

        MyString s1 = new MyString("Hello");
        MyString s2 = s1;

        s1.setString("Bye");
        System.out.println(s2.getString()); // 얕은 복사
    }
}
