import java.io.*;
import java.util.List;

/**
 * 학생 정보를 파일에 저장하고 로드하는 클래스
 * 학생 데이터를 텍스트 파일에 저장/로드하는 기능을 제공함
 * 파일 형식: 이름|나이|점수 (한 줄에 한 명의 학생)
 */
public class StudentFileManager {
    // 학생 데이터를 저장할 파일의 경로
    private static final String FILE_PATH = "students.txt";

    /**
     * StudentManager에 저장된 모든 학생을 파일에 저장하는 메서드
     * 
     * @param manager 학생 정보를 가지고 있는 StudentManager 객체
     */
    public void saveStudents(StudentManager manager) {
        // FileWriter: 파일에 텍스트를 쓰기 위한 도구
        // try-with-resources 문법을 사용하여 자동으로 리소스를 닫음
        try (FileWriter fileWriter = new FileWriter(FILE_PATH);
             // BufferedWriter: 효율적으로 파일에 데이터를 쓰기 위한 도구
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            // manager의 getAllStudents() 메서드로 모든 학생을 가져옴
            List<Student> students = manager.getAllStudents();

            // 모든 학생을 순회하면서 파일에 저장
            for (Student student : students) {
                // 학생 정보를 특정 형식으로 만듦
                // 형식: 이름|나이|점수
                String line = student.getName() + "|" 
                            + student.getAge() + "|" 
                            + student.getScore();
                
                // 한 줄을 파일에 씀
                bufferedWriter.write(line);
                
                // 다음 줄로 이동 (줄바꿈)
                bufferedWriter.newLine();
            }

            // 파일 저장 완료 메시지
            System.out.println("✓ 학생 정보가 '" + FILE_PATH + "' 파일에 저장되었습니다.");
        } catch (IOException e) {
            // 파일 쓰기 중 오류가 발생한 경우
            System.out.println("✗ 파일 저장 중 오류 발생: " + e.getMessage());
        }
    }

    /**
     * 파일에서 학생 정보를 읽어서 StudentManager에 로드하는 메서드
     * 
     * @param manager 학생 정보를 저장할 StudentManager 객체
     * @return 성공적으로 로드했으면 true, 실패했으면 false
     */
    public boolean loadStudents(StudentManager manager) {
        // File 객체로 파일이 존재하는지 확인
        File file = new File(FILE_PATH);

        // 파일이 존재하지 않으면 로드할 것이 없음
        if (!file.exists()) {
            System.out.println("ℹ 저장된 학생 정보가 없습니다. 새로 시작합니다.");
            return false;
        }

        // FileReader: 파일에서 텍스트를 읽기 위한 도구
        try (FileReader fileReader = new FileReader(FILE_PATH);
             // BufferedReader: 효율적으로 파일에서 데이터를 읽기 위한 도구
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            // 파일의 한 줄을 읽을 변수
            String line;

            // readLine()은 한 줄을 읽고, 더 이상 읽을 줄이 없으면 null 반환
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    // 한 줄을 "|" 기준으로 나눔
                    // 예: "김철수|20|95" → ["김철수", "20", "95"]
                    String[] parts = line.split("\\|");

                    // 올바른 형식인지 확인 (3개의 요소가 있어야 함)
                    if (parts.length == 3) {
                        // 이름 추출
                        String name = parts[0];
                        
                        // 나이 추출 (문자열을 정수로 변환)
                        int age = Integer.parseInt(parts[1]);
                        
                        // 점수 추출 (문자열을 실수로 변환)
                        double score = Double.parseDouble(parts[2]);

                        // 새로운 Student 객체 생성
                        Student student = new Student(name, age, score);
                        
                        // StudentManager에 학생을 추가
                        // addStudent()는 메시지를 출력하므로 조용히 추가할 메서드를 따로 호출
                        manager.addStudentSilently(student);
                    }
                } catch (NumberFormatException e) {
                    // 파일 형식이 잘못된 줄은 건너뜀
                    System.out.println("⚠ 형식이 잘못된 줄을 건너뛰었습니다: " + line);
                }
            }

            // 파일 로드 완료 메시지
            System.out.println("✓ '" + FILE_PATH + "' 파일에서 학생 정보를 로드했습니다.");
            return true;

        } catch (IOException e) {
            // 파일 읽기 중 오류가 발생한 경우
            System.out.println("✗ 파일 로드 중 오류 발생: " + e.getMessage());
            return false;
        }
    }
}
