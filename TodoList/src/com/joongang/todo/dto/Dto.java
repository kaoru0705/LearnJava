package com.joongang.todo.dto;

import java.time.LocalDate;

public class Dto {
    LocalDate registerDate;
    LocalDate completeDate;
    boolean isComplete;
    String comment;

    //All Argument Constructor
    public Dto(LocalDate registerDate, LocalDate completeDate, boolean isComplete, String comment) {
        this.registerDate = registerDate;
        this.completeDate = completeDate;
        this.isComplete = isComplete;
        this.comment = comment;
    }

    //No Argument Constructor
    public Dto() {}

    // setter, getter = 문법은 메서드이지만, 개념적으로 기능으로 분류 안 함
    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setCompleteDate(LocalDate completeDate) {
        this.completeDate = completeDate;
    }

    public LocalDate getCompleteDate() {
        return completeDate;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
    public boolean getIsComplete() {
        return isComplete;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }    
}