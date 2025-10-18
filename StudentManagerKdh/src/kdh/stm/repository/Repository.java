package kdh.stm.repository;

import java.util.*;

import kdh.stm.dto.StudentDto;

public class Repository {
    private List<StudentDto> list = new ArrayList<>();

    public void save(StudentDto studentDto) {
        list.add(studentDto);
    }

    public List<StudentDto> findAll() {
        List<StudentDto> copyList = new ArrayList<>();
        for (StudentDto studentDto : list) {
            StudentDto copyStudentDto = new StudentDto(studentDto.getName(), studentDto.getAge(), studentDto.getScore());
            copyList.add(copyStudentDto);
        }

        return copyList;
    }

    public List<StudentDto> findByNameContains(String nameKeyword) {
        List<StudentDto> searchList = new ArrayList<>();
        for (StudentDto studentDto : list) {
            if(studentDto.getName().contains(nameKeyword)) {
                StudentDto copyStudentDto = new StudentDto(studentDto.getName(), studentDto.getAge(), studentDto.getScore());
                searchList.add(copyStudentDto);
            }
        }

        return searchList;
    }

    public int deleteByName(String deleteName) {
        int deleteCount = 0;
        Iterator<StudentDto> iterator = list.iterator();
        while(iterator.hasNext()) {
            StudentDto studentDto = iterator.next();
            if(studentDto.getName().equals(deleteName)) {
                iterator.remove();
                deleteCount++;
            }
        }
        return deleteCount;
    }

    public boolean existsByName(String name) {
        for (StudentDto studentDto: list) {
            if(studentDto.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public void updateByName(String updateName, int age, int score) {
        Iterator<StudentDto> iterator = list.iterator();
        while(iterator.hasNext()) {
            StudentDto studentDto = iterator.next();
            if(studentDto.getName().equals(updateName)) {
                studentDto.setAge(age);
                studentDto.setScore(score);
                return;
            }
        }
    }
}
