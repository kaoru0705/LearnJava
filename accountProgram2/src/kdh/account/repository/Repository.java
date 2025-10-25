package kdh.account.repository;

import kdh.account.dto.AccountDto;
import kdh.account.util.InOutSystem;
import kdh.account.util.CategoryEnum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Repository {
    private List <AccountDto> list = new ArrayList<>();

    public void addTransaction(AccountDto accountDto) {
        list.add(accountDto);
    }

    public List<AccountDto> findAll() {
        List<AccountDto> copyList = new ArrayList<>();

        for(AccountDto accountDto : list) {
            copyList.add(new AccountDto(
                accountDto.getTransactionName(),
                accountDto.getDate(),
                accountDto.getCategoryType(),
                accountDto.getPrice(),
                accountDto.getMemo()));
        }

        return copyList;
    }

    public int deleteByDateAndType(String date, CategoryEnum type) {
        Iterator<AccountDto> iterator = list.iterator();
        int deleteCount = 0;
        while(iterator.hasNext()) {
            AccountDto accountDto = iterator.next();
            if(accountDto.getDate().equals(date) && accountDto.getCategoryType() == type) {
                iterator.remove();
                deleteCount++;
            }
        }
        return deleteCount;
    }

    public List<AccountDto> findByCategory(CategoryEnum type) {
        List<AccountDto> copyList = new ArrayList<>();

        for(AccountDto accountDto : list) {
            if(accountDto.getCategoryType() == type) {
                copyList.add(new AccountDto(
                accountDto.getTransactionName(),
                accountDto.getDate(),
                accountDto.getCategoryType(),
                accountDto.getPrice(),
                accountDto.getMemo()));
            }
        }

        return copyList;
    }

    public List<AccountDto> findByNammContain(String memo) {
        List<AccountDto> copyList = new ArrayList<>();

        for(AccountDto accountDto : list) {
            if(accountDto.getMemo().contains(memo)) {
                copyList.add(new AccountDto(
                accountDto.getTransactionName(),
                accountDto.getDate(),
                accountDto.getCategoryType(),
                accountDto.getPrice(),
                accountDto.getMemo()));
            }
        }

        return copyList;
    }

    

}
