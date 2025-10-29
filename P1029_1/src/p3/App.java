package p3;

import java.util.Map;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Map<String, TodoAdditionalData> todos = new HashMap<> ();
        todos.put("러닝하기!!", new TodoAdditionalData());

        // map 반복 돌리기... 일반적이지 않음
        Set<String> keys = todos.keySet();
        for(String key : keys) {
            TodoAdditionalData data = todos.get(key);
            System.out.println("키: " + key + ", 값: " + data.comment);
        }

    }
}

class Student {
    int age;
    int score;
}

class TodoAdditionalData {
    LocalDate registerDay;
    LocalDate completeDay;
    boolean isComplete;
    String comment;

    TodoAdditionalData (LocalDate registerDay, LocalDate completeDay, boolean isComplete, String comment) {
        this.registerDay = registerDay;
        this.completeDay = completeDay;
        this.isComplete = isComplete;
        this.comment = comment;
    }
}

// 할일 관리.
// 데이터: 할일, 등록일, 완료일, 완료여부, 후기.