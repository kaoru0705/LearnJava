package com.account.service;

import java.util.List;

import com.account.dto.AccountDto;
import com.account.repository.repository;
import com.account.util.CategoryEnum;
import com.account.util.IoManager;

public class service {
    private repository repository = new repository();

    public void createAccountDto() {
        IoManager.println("[테스트 로그] 가계부 등록 로직 수행");
        AccountDto accountDto = new AccountDto();

        accountDto.setName(getIncomeOrExpense());
        accountDto.setDate(IoManager.strInput("날짜 입력 > "));
        accountDto.setType(getCategoryEnum());
        accountDto.setPrice(IoManager.integerInput("금액 입력 > "));
        accountDto.setMemo(IoManager.strInput("상세한 설명 > "));

        repository.save(accountDto);
    }

    public void displayAllList() {
        IoManager.println("[테스트 로그] 가계부 목록 로직 수행");
        List <AccountDto> list = repository.findAll();

        int sum = 0;

        if(list.isEmpty()) {
            IoManager.println("등록된 가계부가 없습니다.");
        }

        for (int index = 0; index < list.size(); index++) {
            IoManager.println(list.get(index).getName()
                    + " 날짜: " + list.get(index).getDate()
                    + " 카테고리: " + list.get(index).getType().getLabel()
                    + " 금액: " + list.get(index).getPrice());
            IoManager.println("메모: " + list.get(index).getMemo());
            int sign = (list.get(index).getName().equals("지출")) ? -1 : 1;
            sum += sign * list.get(index).getPrice();
        }
        IoManager.println("금액은 총 " + sum + "원 입니다.");
    }

    public void displayByCategory() {
        IoManager.println("[테스트 로그] 카테고리별 합계");

        for(CategoryEnum type : CategoryEnum.values()) {
            List <AccountDto> list = repository.findByCategory(type);
            
            if (list.isEmpty()) {
                IoManager.println(type.getLabel() + "로 등록된 금액은 없습니다.");
                continue;
            }

            int sum = 0;
            for(int index = 0; index < list.size(); index++) {
                int sign = (list.get(index).getName().equals("지출")) ? -1 : 1;
                sum += sign * list.get(index).getPrice();
            }

            IoManager.println(type.getCode()+ ". " + type.getLabel() + " = " + sum);
        }
    }

    public void deleteAccountDto() {
        IoManager.println("[테스트 로그] 가계부 삭제 로직");
        String deleteDate = IoManager.strInput("삭제할 가계부의 날짜는? > ");
        IoManager.println("삭제할 카테고리는? ");
        CategoryEnum type = getCategoryEnum();
        
        int deletCount = repository.deleteByDateCategory(deleteDate, type);

        if(deletCount != 0) {
            IoManager.println("총 " + deletCount +"개 삭제했습니다.");
        } else {
            IoManager.println("삭제할 데이터가 존재하지 않습니다.");
        }
    }

    public void displayByDesceneding() {
        List<AccountDto> list = repository.findAll();
        if(list.isEmpty()) {
            IoManager.println("등록된 가계부가 없습니다.");
        }
        list.sort((a, b) -> b.getPrice() - a.getPrice());

        for (int index = 0; index < list.size(); index++) {
            IoManager.println(list.get(index).getName()
                    + " 날짜: " + list.get(index).getDate()
                    + " 카테고리: " + list.get(index).getType().getLabel()
                    + " 금액: " + list.get(index).getPrice());
            IoManager.println("메모: " + list.get(index).getMemo());
        }
    }

    public void displayByMemo() {
        String memo = IoManager.strInput("찾을 메모 입력 > ");
        List<AccountDto> list = repository.findByMemo(memo);

        for (int index = 0; index < list.size(); index++) {
            IoManager.println(list.get(index).getName()
                    + " 날짜: " + list.get(index).getDate()
                    + " 카테고리: " + list.get(index).getType().getLabel()
                    + " 금액: " + list.get(index).getPrice());
            IoManager.println("메모: " + list.get(index).getMemo());
        }
    }
    
    private String getIncomeOrExpense() {
        int choice = IoManager.integerInput("1. 수입 2. 지출 입력 > ");
        while(choice != 1 && choice != 2) {
            IoManager.println("다시 입력해주세요. ");
            choice = IoManager.integerInput("1. 수입 2. 지출 입력 > ");
        }

        if(choice == 1) return "수입";
        else return "지출";
    }

    private CategoryEnum getCategoryEnum() {
        IoManager.println("1. 식사 2. 공과금 3. 교통비 4. 월급 5. 상여금");
        CategoryEnum choice = CategoryEnum.fromCode(IoManager.integerInput("입력  > "));
        while(choice == null) {
            IoManager.println("다시 입력해주세요. ");
            choice = CategoryEnum.fromCode(IoManager.integerInput("입력  > "));
        }

        return choice;
    }
}