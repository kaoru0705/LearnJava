package com.account.repository;

import java.util.*;
import com.account.dto.AccountDto;
import com.account.util.CategoryEnum;

public class repository {
    private List<AccountDto> list = new ArrayList<>();

    public void save(AccountDto accountDto) {
        list.add(accountDto);
    }

    public List<AccountDto> findAll() {
        List<AccountDto> copyList = new ArrayList<>();
        for (AccountDto accountDto : list) {
            AccountDto copyAccountDto = new AccountDto(
                accountDto.getName(), accountDto.getDate(), accountDto.getType(), accountDto.getPrice(), accountDto.getMemo());
            copyList.add(copyAccountDto);
        }

        return copyList;
    }

    public List<AccountDto> findByCategory(CategoryEnum type) {
        List<AccountDto> copyList = new ArrayList<>();
         for (AccountDto accountDto : list) {
            if(accountDto.getType() == type) {
                AccountDto copyAccountDto = new AccountDto(
                accountDto.getName(), accountDto.getDate(), accountDto.getType(), accountDto.getPrice(), accountDto.getMemo());
                copyList.add(copyAccountDto);
            }
        }

        return copyList;
    }


    public List<AccountDto> findByMemo(String memo) {
        List<AccountDto> copyList = new ArrayList<>();
         for (AccountDto accountDto : list) {
            if(accountDto.getMemo().contains(memo)) {
                AccountDto copyAccountDto = new AccountDto(
                accountDto.getName(), accountDto.getDate(), accountDto.getType(), accountDto.getPrice(), accountDto.getMemo());
                copyList.add(copyAccountDto);
            }
        }

        return copyList;
    }
    
    public int deleteByDateCategory(String deleteDate, CategoryEnum type) {
        int deleteCount = 0;
        Iterator<AccountDto> iterator = list.iterator();
        while(iterator.hasNext()) {
            AccountDto accountDto = iterator.next();
            if(accountDto.getDate().equals(deleteDate) && accountDto.getType() == type) {
                iterator.remove();
                deleteCount++;
            }
        }
        return deleteCount;
    }

    // public boolean existsByName(String name) {
    //     for (AccountDto AccountDto: list) {
    //         if(AccountDto.getName().equals(name)) {
    //             return true;
    //         }
    //     }

    //     return false;
    // }

    // public void updateByName(String updateName, int age, int score) {
    //     Iterator<AccountDto> iterator = list.iterator();
    //     while(iterator.hasNext()) {
    //         AccountDto AccountDto = iterator.next();
    //         if(AccountDto.getName().equals(updateName)) {
    //             AccountDto.setAge(age);
    //             AccountDto.setScore(score);
    //             return;
    //         }
    //     }
    // }
}
