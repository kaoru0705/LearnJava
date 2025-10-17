package com.joongang.stm.service;

import java.util.Arrays;

import com.joongang.stm.dto.StudentDto;
import com.joongang.stm.util.IoManager;
import com.joongang.stm.repository.Repository;

// 컴포넌트
// 역할: 비즈니스로직(코어로직) 담당
public class Service {

    private Repository repository = new Repository();


    public void addStudent() {
        IoManager.println("===== 학생 정보 입력 시작 =====");
        String name = IoManager.input("이름 입력 > ");
        int age = IoManager.intgerInput("나이 입력 > ");
        int score = IoManager.intgerInput("점수 입력 > ");

        StudentDto studentDto = new StudentDto(name, age, score);

        repository.save(studentDto);


        IoManager.println("============================");
    }

    public void displayListOfStudent() {
        IoManager.println("===== 학생 정보 목록 시작 =====");

        StudentDto[] list = repository.findAll();

        for(StudentDto studentDto: list) {
            String text = "";
            text += "이름: " + studentDto.getName();
            text += ", 나이: " + studentDto.getAge();
            text += ", 점수: " + studentDto.getScore();
            IoManager.println(text);
        }

        IoManager.println("총 " + list.length + "명이 존재합니다.");


        IoManager.println("============================");
    }

    public void searchStudent() {
        IoManager.println("===== 학생 정보 검색 시작 =====");

        String searchWord = IoManager.input("검색할 이름 > ");

        StudentDto[] list = repository.findbyNameContaining(searchWord);

        for(StudentDto studentDto: list) {
            String text = "";
            text += "이름: " + studentDto.getName();
            text += ", 나이: " + studentDto.getAge();
            text += ", 점수: " + studentDto.getScore();
            IoManager.println(text);
        }

        IoManager.println("============================");
    }

    public void removeStudent() {
        IoManager.println("===== 학생 정보 삭제 시작 =====");

        String removeName = IoManager.input("삭제할 학생의 이름 > ");

        int count = repository.removeByName(removeName);
        IoManager.println("총 " + count + "명의 정보가 삭제 되었습니다.");

        IoManager.println("============================");
    }

    public void statistize() {
        IoManager.println("===== 학생 정보 통계 시작 =====");

        StudentDto[] list = repository.findAll();
        int sumScore = 0;
        for(StudentDto studentDto : list) {
            sumScore += studentDto.getScore();
        }

        double avg = sumScore / (double)list.length;
        IoManager.println("총 인원: " + list.length);
        IoManager.println("평균: " + avg);

        IoManager.println("============================");
    }
}