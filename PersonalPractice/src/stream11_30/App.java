package stream11_30;
import java.util.*;
import java.util.stream.*;

public class App {
    public static void main(String[] args) {
        List<Member> members = new ArrayList<> ();
        members.add(new Member("홍길동", "남", 30));
        members.add(new Member("심사임당", "여", 50));
        members.add(new Member("이순신", "남", 40));
        members.add(new Member("김유신", "남", 20));
        members.add(new Member("유관순", "여", 19));
        members.add(new Member("강감찬", "남", 45));

        List<Member> male_members = members.stream()
                                            .filter(member -> member.getGender().equals("남"))
                                            .collect(Collectors.toList());
        male_members.stream()
                    .forEach(member -> System.out.println(member));

        List<Member> female_members = members.stream()
                                            .filter(member -> member.getGender().equals("여"))
                                            .toList();
        female_members.stream()
                    .forEach(member -> System.out.println(member));
        
        Set<Member> female_members2 = members.stream()
                                            .filter(member -> member.getGender().equals("여"))
                                            .collect(Collectors.toSet());
        female_members2.stream()
                    .forEach(member -> System.out.println(member));

        
        Map<String, Integer> ages = members.stream()
                                            .collect(Collectors.toMap(member -> member.getName(),
                                            member -> member.getAge()));
        // Map을 가리키는 변수를 출력하면 key value가 나온다.
        // HashMap은 순서가 지켜지지 않는다. 순서를 지킬려면 LinkedHashMap으로 선언해야 한다.
        System.out.println(ages);
    }
}

class Member {
    String name;
    String gender;
    int age;

    Member(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }
    public String getGender() {
        return this.gender;
    }
    public int getAge() {
        return this.age;
    }
    public String toString() {
        return "name = " + this.name + ", " + "gender = " + this.gender + ", age = " + this.age;
    }
}

