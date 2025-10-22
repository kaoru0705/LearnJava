package kdh.stm.service;

import java.util.List;

import kdh.stm.dto.StudentDto;
import kdh.stm.repository.Repository;
import kdh.stm.util.IoManager;

public class Service {
    private Repository repository = new Repository();

    public void createStudentDto() {
        IoManager.println("[테스트 로그] 학생 등록 로직 수행");
        StudentDto studentDto = new StudentDto(IoManager.strInput("이름 입력 > "),
        IoManager.integerInput("나이 입력 > "), IoManager.integerInput("점수 입력 > "));

        studentDto.setName(IoManager.strInput("이름 입력 > "));
        studentDto.setAge(IoManager.integerInput("나이 입력 > "));
        studentDto.setScore(IoManager.integerInput("점수 입력 > "));
        repository.save(studentDto);
    }

    public void displayAllList() {
        System.out.println("[테스트 로그] 학생 목록 로직 수행");
        List <StudentDto> list = repository.findAll();

        for (int index = 0; index < list.size(); index++) {
            System.out.println("학생의 이름: " + list.get(index).getName()
                    + " 나이: " + list.get(index).getAge()
                    + " 점수: " + list.get(index).getScore());
        }
    }

    public void searchStudentDto() {
        IoManager.println("[테스트 로그] 학생 검색 로직");
        String nameKeyword = IoManager.strInput("검색할 학생의 이름: > ");
        List <StudentDto> list = repository.findByNameContains(nameKeyword);
        if (list.size() == 0) {
            IoManager.println("검색된 학생이 없습니다.");
            return;
        }

        IoManager.println("이름에 " + nameKeyword + "이(가) 포함되는 학생은 ");
        for (int index = 0; index < list.size(); index++) {
            IoManager.println("\t이름: " + list.get(index).getName()
                    + " 나이: " + list.get(index).getAge()
                    + " 점수: " + list.get(index).getScore());
        }
        IoManager.println("으로 총 " + list.size() + "명 있습니다.");
    }

    public void deleteStudentDto() {
        IoManager.println("[테스트 로그] 학생 삭제 로직");
        String deleteName = IoManager.strInput("삭제할 학생의 이름은? > ");
        if(!repository.existsByName(deleteName)) {
            IoManager.println(deleteName + "는(은) 존재하지 않는 이름입니다.");
            return;
        }
        
        String guest = IoManager.YesOrNoInput("삭제할 이름을 발견했습니다.\n마지막으로 묻습니다. 정말 삭제하시겠습니까? (Y/N) > ");

        if(guest.toUpperCase().equals("Y") || guest.toUpperCase().equals("YES")) {
            int deleteCount = repository.deleteByName(deleteName);
            IoManager.println("총 " + deleteCount + "명 삭제했습니다.");
        } else {
            IoManager.println("삭제하지 않기로 했습니다.");
        }
    }
        

    public void updateStudentDto() {
        IoManager.println("[테스트 로그] 학생 정보 수정 로직");
        String updateName = IoManager.strInput("수정할 학생의 이름은? >");
        if(!repository.existsByName(updateName)) {
            IoManager.println(updateName + "는(은) 존재하지 않는 이름입니다.");
            return;
        }
        IoManager.println("수정할 학생의 이름을 발견했습니다.\n 정보를 입력해주세요.");
        int age = IoManager.integerInput("나이 > ");
        int score = IoManager.integerInput("점수 > ");
        repository.updateByName(updateName, age, score);
    }

}