public class P2 {
    public static void main(String[] args) {
        StudentDto[] studentsInfo = new StudentDto[5];

        int studentCount = 0;

        studentsInfo[studentCount] = new StudentDto();
        studentsInfo[studentCount].additionalInfo = new AdditionalInfo();

        studentsInfo[studentCount].name = "홍길동";
        studentsInfo[studentCount].age = 30;
        studentsInfo[studentCount].score = 70;
        studentsInfo[studentCount].additionalInfo.birth = "1998-07-05";
        studentsInfo[studentCount].additionalInfo.gender = "male";

        studentCount++;

    }
}

class StudentDto {
    String name;
    int age;
    int score;
    AdditionalInfo additionalInfo;
}

class AdditionalInfo {
    String gender;
    String birth;
}