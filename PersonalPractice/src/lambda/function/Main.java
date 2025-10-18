package lambda.function;
import java.util.function.*;

class Student {
    private String name;
    private int year;
    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {return name;}
    public int getYear() {return year;}
}

public class Main {
    public static void main(String args[]) {
        Student stu = new Student("kang", 1998);

        Function<Student, String> function1 = s -> {return s.getName();};
        Function<Student, Integer> function2 = s -> s.getYear();

        System.out.println(function1.apply(stu));
        System.out.println(function2.apply(stu));
    }
}
