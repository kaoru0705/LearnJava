package com.joongang.todo.repository;

import com.joongang.todo.dto.Dto;
import com.joongang.todo.util.IoManager;
import java.util.Map;
import java.time.LocalDate;
import java.util.HashMap;


// 컴포넌트
// 역할: 저장소 - 데이터 입출력 담당
// 이 부분은 사실상 DB 쿼리로 변경 예정 - 직접 구현할 일 없음
public class Repository {
    private Map<String, Dto> list = new HashMap<>();

    public void save(String todo, Dto dto) {
        list.put(todo, dto);
        System.out.println();
    }

    public Map<String, Dto> findAll() {
        if(list.isEmpty()) {
            return new HashMap<>();
        }
        Map<String, Dto> copyList = new HashMap<>();
        
        
        for(Map.Entry<String, Dto> entry : list.entrySet()) {
            LocalDate registerDate = entry.getValue().getRegisterDate();
            LocalDate completeDate = entry.getValue().getCompleteDate();
            
            boolean isComplete = entry.getValue().getIsComplete();
            String comment = entry.getValue().getComment();
            copyList.put(entry.getKey(), new Dto(registerDate, completeDate, isComplete, comment));
        }

        return copyList;
    }

    public int updateByTodoAndDate(String searchTodo, LocalDate date) {
        if(list.isEmpty()) {
            IoManager.println("완료처리할 할일이 존재하지 않습니다.");
            return 0;
        }

        int updatedCount = 0;

        for(Map.Entry<String, Dto> entry : list.entrySet()) {
            if(entry.getKey().contains(searchTodo) && date.equals(entry.getValue().getRegisterDate()) && !entry.getValue().getIsComplete()) {
                LocalDate completeDate = LocalDate.parse(IoManager.input("등록할 완료일 > "));
                entry.getValue().setCompleteDate(completeDate);
                entry.getValue().setIsComplete(true);
                updatedCount++;
            }
        }

        return updatedCount;
    }

    public Map<String, Dto> findByInComplete() {
        if(list.isEmpty()) {
            return new HashMap<>();
        }

        Map<String, Dto> searchList = new HashMap<>();

        for(Map.Entry<String, Dto> entry : list.entrySet()) {
            if(!entry.getValue().getIsComplete()) {
                LocalDate registerDate = entry.getValue().getRegisterDate();
                LocalDate completeDate = entry.getValue().getCompleteDate();
            
                boolean isComplete = entry.getValue().getIsComplete();
                String comment = entry.getValue().getComment();
                searchList.put(entry.getKey(), new Dto(registerDate, completeDate, isComplete, comment));
            }
        }

        return searchList;
    }

    public Map<String, Dto> findByComplete() {
        if(list.isEmpty()) {
            return new HashMap<>();
        }

        Map<String, Dto> searchList = new HashMap<>();

        for(Map.Entry<String, Dto> entry : list.entrySet()) {
            if(entry.getValue().getIsComplete()) {
                LocalDate registerDate = entry.getValue().getRegisterDate();
                LocalDate completeDate = entry.getValue().getCompleteDate();
            
                boolean isComplete = entry.getValue().getIsComplete();
                String comment = entry.getValue().getComment();
                searchList.put(entry.getKey(), new Dto(registerDate, completeDate, isComplete, comment));
            }
        }

        return searchList;
    }

    public Map<String, Dto> findByTodo(String searchTodo) {
        if(list.isEmpty()) {
            return new HashMap<>();
        }

        Map<String, Dto> searchList = new HashMap<>();

        for(Map.Entry<String, Dto> entry : list.entrySet()) {
            if(entry.getKey().contains(searchTodo)) {
                LocalDate registerDate = entry.getValue().getRegisterDate();
                LocalDate completeDate = entry.getValue().getCompleteDate();

                boolean isComplete = entry.getValue().getIsComplete();
                String comment = entry.getValue().getComment();
                searchList.put(entry.getKey(), new Dto(registerDate, completeDate, isComplete, comment));
            }
        }

        return searchList;
    }
    public int removeByTodoAndDate(String searchTodo, LocalDate date) {
        if(list.isEmpty()) {
            IoManager.println("삭제할 할일이 존재하지 않습니다.");
            return 0;
        }

        int removedCount = 0;

        for(Map.Entry<String, Dto> entry : list.entrySet()) {
            if(entry.getKey().contains(searchTodo) && date.equals(entry.getValue().getRegisterDate())) {
                list.remove(entry.getKey());
                removedCount++;
            }
        }

        return removedCount;
    }
}

