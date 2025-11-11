import java.util.ArrayList;
import java.util.List;

/**
 * 학생들을 관리하는 클래스
 * 학생 추가, 삭제, 수정, 조회 등의 기능을 제공함
 */
public class StudentManager {
    // 등록된 모든 학생을 저장하는 리스트
    // List는 순서대로 요소를 저장하는 자료구조
    // ArrayList는 List의 구현체로, 크기를 자동으로 조절할 수 있음
    private List<Student> students;

    /**
     * StudentManager 생성자
     * 새로운 학생 관리자를 만들 때 빈 학생 리스트를 초기화함
     */
    public StudentManager() {
        // 새로운 ArrayList 객체를 생성하여 students에 저장
        // 처음에는 학생이 아무도 없는 빈 상태
        this.students = new ArrayList<>();
    }

    /**
     * 새로운 학생을 등록하는 메서드
     * 
     * @param student 등록할 학생 객체
     */
    // 학생 등록
    public void addStudent(Student student) {
        // students 리스트에 student 객체를 추가
        // add() 메서드는 리스트의 맨 뒤에 요소를 추가함
        students.add(student);
        
        // 등록 완료 메시지 출력
        System.out.println("✓ 학생 '" + student.getName() + "'이(가) 등록되었습니다.");
    }

    /**
     * 등록된 모든 학생의 정보를 화면에 출력하는 메서드
     */
    // 학생 목록 조회
    public void displayAllStudents() {
        // isEmpty()는 리스트가 비어있는지 확인하는 메서드
        // 학생이 없으면 true를 반환
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return; // 메서드를 여기서 종료
        }

        // 제목 출력
        System.out.println("\n========== 학생 목록 ==========");
        
        // for 루프를 사용하여 모든 학생을 순회
        // i는 0부터 시작하여 리스트의 크기-1까지 증가
        for (int i = 0; i < students.size(); i++) {
            // students.get(i)는 i번째 위치의 학생을 가져옴
            // (i + 1)을 사용하여 1부터 시작하는 번호로 표시
            System.out.println((i + 1) + ". " + students.get(i));
        }
        
        // 하단 구분선 출력
        System.out.println("==============================\n");
    }

    /**
     * 이름으로 학생을 검색하는 메서드
     * 
     * @param name 검색할 학생의 이름
     * @return 찾은 학생 객체, 없으면 null 반환
     */
    // 학생 검색 (이름으로)
    public Student findStudentByName(String name) {
        // for-each 루프를 사용하여 모든 학생을 순회
        // student 변수에 students 리스트의 각 요소가 순서대로 들어옴
        for (Student student : students) {
            // 현재 학생의 이름이 찾는 이름과 같은지 확인
            // equals()는 문자열이 같은지 비교하는 메서드
            if (student.getName().equals(name)) {
                // 찾은 학생을 반환
                return student;
            }
        }
        
        // 모든 학생을 확인했는데 못 찾으면 null 반환
        // null은 "아무것도 없다"는 의미
        return null;
    }

    /**
     * 학생의 정보(나이, 점수)를 수정하는 메서드
     * 
     * @param name 수정할 학생의 이름
     * @param age 수정할 새로운 나이
     * @param score 수정할 새로운 점수
     */
    // 학생 정보 수정
    public void updateStudent(String name, int age, double score) {
        // findStudentByName()을 사용하여 이름으로 학생을 찾음
        Student student = findStudentByName(name);
        
        // 찾은 학생이 null이 아닌지 확인 (즉, 학생이 존재하는지 확인)
        if (student != null) {
            // 찾은 학생의 나이를 새로운 값으로 수정
            student.setAge(age);
            
            // 찾은 학생의 점수를 새로운 값으로 수정
            student.setScore(score);
            
            // 수정 완료 메시지 출력
            System.out.println("✓ 학생 '" + name + "'의 정보가 수정되었습니다.");
        } else {
            // 학생을 찾지 못한 경우 오류 메시지 출력
            System.out.println("✗ 학생 '" + name + "'을(를) 찾을 수 없습니다.");
        }
    }

    /**
     * 이름으로 학생을 찾아서 삭제하는 메서드
     * 
     * @param name 삭제할 학생의 이름
     */
    // 학생 삭제
    public void deleteStudent(String name) {
        // findStudentByName()을 사용하여 이름으로 학생을 찾음
        Student student = findStudentByName(name);
        
        // 찾은 학생이 null이 아닌지 확인 (즉, 학생이 존재하는지 확인)
        if (student != null) {
            // students 리스트에서 해당 학생을 제거
            // remove() 메서드는 매개변수로 받은 객체를 리스트에서 삭제함
            students.remove(student);
            
            // 삭제 완료 메시지 출력
            System.out.println("✓ 학생 '" + name + "'이(가) 삭제되었습니다.");
        } else {
            // 학생을 찾지 못한 경우 오류 메시지 출력
            System.out.println("✗ 학생 '" + name + "'을(를) 찾을 수 없습니다.");
        }
    }

    /**
     * 현재 등록된 학생의 총 개수를 반환하는 메서드
     * 
     * @return 등록된 학생의 개수
     */
    // 학생 수 반환
    public int getStudentCount() {
        // students 리스트의 크기(요소의 개수)를 반환
        // size()는 리스트에 몇 개의 요소가 있는지 알려주는 메서드
        return students.size();
    }

    /**
     * 모든 학생 정보를 담고 있는 리스트를 반환하는 메서드
     * 파일 저장 시 모든 학생을 가져오기 위해 사용됨
     * 
     * @return 등록된 모든 학생의 리스트
     */
    public List<Student> getAllStudents() {
        // students 리스트 전체를 반환
        // 새로운 리스트로 복사하여 반환하므로 원본이 손상되지 않음
        return new ArrayList<>(students);
    }

    /**
     * 파일에서 로드할 때 사용하는 메서드
     * 메시지를 출력하지 않고 조용히 학생을 추가
     * 
     * @param student 추가할 학생 객체
     */
    public void addStudentSilently(Student student) {
        // 메시지를 출력하지 않고 리스트에만 추가
        students.add(student);
    }
}
