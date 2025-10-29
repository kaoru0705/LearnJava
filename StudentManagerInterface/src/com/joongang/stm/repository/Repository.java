package com.joongang.stm.repository;

import com.joongang.stm.dto.StudentDto;
import com.joongang.stm.util.IoManager;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


// 컴포넌트
// 역할: 저장소 - 데이터 입출력 담당
// 이 부분은 사실상 DB 쿼리로 변경 예정 - 직접 구현할 일 없음
public class Repository {
    private List<StudentDto> list = new ArrayList<>();

    public void save(StudentDto studentDto) {
        list.add(studentDto);
    }

    public List<StudentDto> findAll() {
        if(list.isEmpty()) {
            return new ArrayList<>();
        }
        List<StudentDto> copyList = new ArrayList<>();

        for(StudentDto dto : list) {
            String name = dto.getName();
            String id = dto.getId();
            int age = dto.getAge();
            int score = dto.getScore();

            StudentDto studentDto = new StudentDto(name, id, age, score);
            copyList.add(studentDto);
        }

        return copyList;
    }

    public List<StudentDto> findbyNameContaining(String searchWord) {
        List<StudentDto> newList = new ArrayList<>();
        for(StudentDto dto : list) {
            if(dto.getName().contains(searchWord)) {
                String name = dto.getName();
                String id = dto.getId();
                int age = dto.getAge();
                int score = dto.getScore();

                StudentDto studentDto = new StudentDto(name, id, age, score);
                newList.add(studentDto);
            }
        }

        return newList;
    }
    public int removeByNameAndId(String removeName, String removeId) {
        int removedCount = 0;

        Iterator<StudentDto> iterator = list.iterator();
        while(iterator.hasNext()) {
            StudentDto studentDto = iterator.next();
            if(studentDto.getId().equals(removeId) && studentDto.getName().equals(removeName)) {
                iterator.remove();
                removedCount++;
            }
        }

        return removedCount;
    }
}

