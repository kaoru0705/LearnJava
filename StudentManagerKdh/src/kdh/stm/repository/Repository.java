package kdh.stm.repository;

import java.util.*;

import kdh.stm.dto.StudentDto;

public class Repository {
    private List<StudentDto> list = new ArrayList<>();

    public void save(StudentDto studentDto) {
        list.add(studentDto);
    }

    public List<StudentDto> findAllStudentInfo() {
        List<StudentDto> copyList = new ArrayList<>();
        for (StudentDto studentDto : list) {
            StudentDto copyStudentDto = new StudentDto(studentDto.getName(), studentDto.getAge(), studentDto.getScore());
            copyList.add(copyStudentDto);
        }

        return copyList;
    }

    public List<StudentDto> findStudentInfoByNameContains(String searchName) {
        List<StudentDto> searchList = new ArrayList<>();

        for (StudentDto studentDto : list) {
            if(studentDto.getName().contains(searchName)) {
                StudentDto copyStudentDto = new StudentDto(studentDto.getName(), studentDto.getAge(), studentDto.getScore());
                searchList.add(copyStudentDto);
            }
        }

        return searchList;
    }

    public void deleteStudentInfoByName() {
        
    }
}
