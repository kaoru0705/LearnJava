package P3;

public class App {
    public static void main(String[] args) {
        Team[] teams = new Team[5];
    }
}


// 조직도
// 

class Team {
    String name;
    //.. 기타 정보들
    Team[] teamList = new Team[5];  // 같은 구조의 하위 티어가 있다면 재귀로 해결
    Person[] personList = new Person[5]; // Team - Person 이중 for로 해결
}

class Person {
    String name;
    //.. 기타 정보들
}