package kdh.stm.service;

import java.util.ArrayList;
import java.util.List;

import kdh.stm.dto.StudentDto;
import kdh.stm.repository.Repository;
import kdh.stm.util.IoManager;

public class Service {
    private Repository repository = new Repository();

    public void createStudentInfo() {
        IoManager.println("[테스트 로그] 학생 등록 로직 수행");
        StudentDto studentDto = new StudentDto();

        studentDto.setName(IoManager.strInput("이름 입력 > "));
        studentDto.setAge(IoManager.integerInput("나이 입력 > "));
        studentDto.setScore(IoManager.integerInput("점수 입력 > "));
        repository.save(studentDto);
    }

    public void displayAllStudentInfo() {
        System.out.println("[테스트 로그] 학생 목록 로직 수행");
        List <StudentDto> list = repository.findAllStudentInfo();

        for (int index = 0; index < list.size(); index++) {
            System.out.println("학생의 이름: " + list.get(index).getName()
                    + " 나이: " + list.get(index).getAge()
                    + " 점수: " + list.get(index).getScore());
        }
    }

    public void searchStudentInfo() {
        IoManager.println("[테스트 로그] 학생 검색 로직");
        String searchName = IoManager.strInput("검색할 학생의 이름: > ");
        List <StudentDto> list = repository.findStudentInfoByNameContains(searchName);
        if (list.size() == 0) {
            IoManager.println("검색된 학생이 없습니다.");
            return;
        }

        IoManager.println("이름에 " + searchName + "이(가) 포함되는 학생은 ");
        for (int searchIndex = 0; searchIndex < list.size(); searchIndex++) {
            IoManager.println("\t이름: " + list.get(searchIndex).getName()
                    + " 나이: " + list.get(searchIndex).getAge()
                    + " 점수: " + list.get(searchIndex).getScore());
        }
        IoManager.println("으로 총 " + list.size() + "명 있습니다.");
    }

    public void deleteStudentInfo() {
        IoManager.println("[테스트 로그] 학생 삭제 로직");
        String deletedName = IoManager.strInput("삭제할 이름은? > ");
        boolean isDelete = false;
        boolean isCancel = false;
        for (int nameIndex = 0; nameIndex < list.size(); nameIndex++) {
            if (list.get(nameIndex).getName().equals(deletedName)) {
                String guest = IoManager.YesOrNoInput("삭제할 이름을 찾았습니다.\n마지막으로 묻습니다. 정말 삭제하시겠습니까? (Y/N) > ");

                if (guest.toUpperCase().equals("N") || guest.toUpperCase().equals("NO")) {
                    IoManager.println("삭제하지 않기로 했습니다.");
                    isCancel = true;
                    break;
                }
            }

            if (list.get(nameIndex).getName().equals(deletedName)) {
                list.remove(nameIndex);
                nameIndex--;
                IoManager.println("삭제되었습니다.");
                isDelete = true;
            }
        }

        if (!isDelete && !isCancel) {
            IoManager.println("존재하지 않는 이름입니다.");
        }
    }

    public void updateStudentInfo() {
        IoManager.println("[테스트 로그] 학생 정보 수정 로직");
    }

}