package com.joongang.stm.dto;

// Dto


public class StudentDto {
    private String name;
    private String id;
    private int age;
    private int score;

    //All Argument Constructor
    public StudentDto(String name, String id, int age, int score) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.score = score;
    }

    //No Argument Constructor
    public StudentDto() {}

    // setter, getter = 문법은 메서드이지만, 개념적으로 기능으로 분류 안 함
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }    
}