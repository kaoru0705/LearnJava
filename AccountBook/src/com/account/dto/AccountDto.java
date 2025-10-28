package com.account.dto;

import com.account.util.CategoryEnum;

public class AccountDto {
    private String name;
    private String date;
    private CategoryEnum type;
    private int price;
    private String memo;

    public AccountDto(String name, String date, CategoryEnum type, int price, String memo) {
        this.name = name;
        this.date = date;
        this.type = type;
        this.price = price;
        this.memo = memo;
    }

    public AccountDto() {
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setType(CategoryEnum type) {
        this.type = type;
    }

    public CategoryEnum getType() {
        return type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo() {
        return memo;
    }
}
