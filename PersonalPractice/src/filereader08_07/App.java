package filereader08_07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class App {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\shkdh\\Desktop\\economyPdf\\분석법\\장기투자\\분석 결과.txt");
        try(Reader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader)) {
            int nData;
            
            while((nData = br.read()) != -1) {
                System.out.print((char)nData);
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
