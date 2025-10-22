package file.class01;
import java.io.*;

public class App {
    public static void main(String[] args) {
        File myFile = new File("C:\\Windows\\notepad.exe");
        System.out.println(myFile.getName());
        System.out.println(myFile.getPath());
        System.out.println(myFile.length());
    }
}
