package com.joongang.stm.repository;

import com.joongang.stm.dto.StudentDto;
import com.joongang.stm.util.IoManager;

// 컴포넌트
// 역할: 저장소 - 데이터 입출력 담당
// 이 부분은 사실상 DB 쿼리로 변경 예정 - 직접 구현할 일 없음
public class Repository {
    private StudentDto[] list = new StudentDto[5];
    private int count = 0;

    public void save(StudentDto studentDto) {
        list[count] = studentDto;
        count++;
    }

    public StudentDto[] findAll() {
        if(count == 0) {
            IoManager.println("등록된 학생이 없습니다.");
            return new StudentDto[]{};
        }
        StudentDto[] copyList = new StudentDto[count];

        for(int i = 0; i < count; i++) {
            String name = list[i].getName();
            int age = list[i].getAge();
            int score = list[i].getScore();

            copyList[i] = new StudentDto(name, age, score);
        }

        return copyList;
    }

    public StudentDto[] findbyNameContaining(String searchWord) {
        int searchCount = 0;
        for(int i = 0; i < count; i++) {
            if(list[i].getName().contains(searchWord)) {
                searchCount++;
            }
        }

        StudentDto[] newList = new StudentDto[searchCount];
        int newListCount = 0;
        for(int i = 0; i < count; i++) {
            if(list[i].getName().contains(searchWord)) {
                String name = list[i].getName();
                int age = list[i].getAge();
                int score = list[i].getScore();
                newList[newListCount] = new StudentDto(name, age, score);
                newListCount++;
            }
        }
        return newList;
    }
    public int removeByName(String removeName) {
        int removeCount = 0;

        for(int i = 0; i < count; i++) {
            if(list[i].getName().equals(removeName)) {
                for(int x = i; x < count - 1 ; x++) {
                    list[x] = list[x+1];
                }
                count--;
                i--;
                removeCount++;
            }
        }

        return removeCount;
    }
}

