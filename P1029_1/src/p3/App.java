package p3;

import java.util.Map;
import java.time.LocalDate;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        Map<String, TodoAdditionalData> todos = new HashMap<> ();
        todos.put("러닝하기!!", new TodoAdditionalData());
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