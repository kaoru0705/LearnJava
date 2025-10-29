package com.joongang.todo.service;

import com.joongang.todo.dto.Dto;
import com.joongang.todo.util.IoManager;
import com.joongang.todo.repository.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

// 컴포넌트
// 역할: 비즈니스로직(코어로직) 담당
/*
    LocalDate registerDate;
    LocalDate completeDate;
    boolean isComplete;
    String comment;
*/
public class Service {

    private Repository repository = new Repository();


    public void addStudent() {
        IoManager.println("===== 할일 추가 시작 =====");
        String todo = IoManager.input("할일 입력 > ");
        
        LocalDate registerDate = LocalDate.parse(IoManager.input("등록일 > "));
        String strCompleteDate = IoManager.input("완료일 입력 없으시다면 그냥 엔터 > ");
        LocalDate completeDate;
        if(strCompleteDate.equals("")) {
            completeDate = null;
        } else {
            completeDate = LocalDate.parse(strCompleteDate);
        }

        boolean isComplete = (completeDate == null) ? false : true;
        String comment = IoManager.input("후기 입력 > ");

        
        Dto dto = new Dto(registerDate, completeDate, isComplete, comment);

        repository.save(todo, dto);


        IoManager.println("============================");
    }

    public void displayList() {
        IoManager.println("===== 전체 목록 보기 =====");

        Map<String, Dto> list = repository.findAll();

        if(list.isEmpty()) {
            IoManager.println("등록된 할일이 존재하지 않습니다.");
            return;
        }
        
        printList(list);


        IoManager.println("============================");
    }

    public void UpdateIsCompleteByTodoAndDate() {
        IoManager.println("===== 완료 처리하기 =====");

        String searchTodo = IoManager.input("검색할 할일 > ");
        LocalDate registerDate = LocalDate.parse(IoManager.input("등록일 > "));


        int count = repository.updateByTodoAndDate(searchTodo, registerDate);
        
        IoManager.println("총 " + count + " 개 완료 처리되었습니다.");
        System.out.println();
    }

    public void displayByInComplete() {
        IoManager.println("===== 미완료만 보기 =====");

        Map<String, Dto> list = repository.findByInComplete();

        if(list.isEmpty()) {
            IoManager.println("등록된 미완료가 존재하지 않습니다.");
            return;
        }

        printList(list);

    }

    public void displayByComplete() {
        IoManager.println("===== 완료만 보기 =====");

        Map<String, Dto> list = repository.findByComplete();

        if(list.isEmpty()) {
            IoManager.println("등록된 완료가 존재하지 않습니다.");
            return;
        }

        printList(list);
    }

    public void displayByTodo() {
        IoManager.println("===== 제목 키워드 검색 시작 =====");

        String searchTodo = IoManager.input("검색할 할일 > ");
        Map<String, Dto> list = repository.findByTodo(searchTodo);

        if(list.isEmpty()) {
            IoManager.println("등록된 할일이 존재하지 않습니다.");
            return;
        }

        printList(list);
    }

    private void printList(Map<String, Dto> list) {
        for(Map.Entry<String, Dto> entry : list.entrySet()) {
            IoManager.print("할일: " + entry.getKey() + " 등록일: " + entry.getValue().getRegisterDate());
            if(entry.getValue().getIsComplete()) IoManager.print(" 완료일: " + entry.getValue().getCompleteDate());
            IoManager.println(" 후기: " + entry.getValue().getComment());
        }

        IoManager.println("총 " + list.size() + "개가 존재합니다.");
    }

    public void removeByTodoAndDate() {
        IoManager.println("===== 할일 정보 삭제 시작 =====");

        String removeName = IoManager.input("삭제할 할일 > ");
        LocalDate registerDate = LocalDate.parse(IoManager.input("등록일 > "));

        int removedCount = repository.removeByTodoAndDate(removeName, registerDate);
        IoManager.println("총 " + removedCount + "명의 정보가 삭제 되었습니다.");

        IoManager.println("============================");
    }
    
}