package kdh.account.repository;

import kdh.account.dto.AccountDto;
import kdh.account.util.InOutSystem;
import kdh.account.util.CategoryEnum;

import java.util.ArrayList;
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

    public void deleteByDateAndType() {
        
    }

    

}
