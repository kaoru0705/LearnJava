package file.class02;
import java.io.File;

public class App {
    public static void main(String[] args) {
        File myFile = new File("c:\\aa\\bb");
        if(myFile.mkdirs()) {
            System.out.println("Directory was created");
        } else {
            System.out.println("Directory was not created");
        }
    }
}