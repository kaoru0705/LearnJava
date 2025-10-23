package kdh.account.service;

import java.util.ArrayList;
import java.util.List;

import kdh.account.dto.AccountDto;
import kdh.account.repository.Repository;
import kdh.account.util.CategoryEnum;
import kdh.account.util.InOutSystem;

public class Service {
    Repository repository = new Repository();

    public void addTransaction() {
        InOutSystem.println("거래 등록을 선택하셨습니다.");
        String transactionName = InOutSystem.input("수입 혹은 지출을 입력하세요. > ");

        while(!transactionName.equals("수입") && !transactionName.equals("지출")) {
            InOutSystem.println("입력을 다시 해주세요.");
            transactionName = InOutSystem.strInput("수입 혹은 지출을 입력하세요. > ");
        }

        // repository.addTransaction(transactionCommand);
        String date = InOutSystem.strInput("해당 날짜를 입력해주세요. >");

        InOutSystem.println("======카테고리 선택=======");
        InOutSystem.println("1. 식사 2. 공과금 3. 교통비 4. 월급 5. 상여금");
        int command = InOutSystem.IntegerInput("해당 카테고리를 선택해주세요 > ");
        while(command > 5) {
            InOutSystem.println("해당 카테고리는 존재하지 않습니다.");
            command = InOutSystem.IntegerInput("해당 카테고리를 선택해주세요 > ");
        }

        CategoryEnum type = selectCategoryEnum(command);

        int price = InOutSystem.IntegerInput("금액을 입력해주세요. > ");
        if(transactionName.equals("지출")) {
            price *= -1;
        }
        
        String memo = InOutSystem.strInput("상세한 설명을 입력해주세요 > ");

        AccountDto accountDto = new AccountDto(transactionName, date, type, price, memo);

        repository.addTransaction(accountDto);
    }

    public void displayTransactionList() {
        List <AccountDto> list = repository.findAll();
        if(list.isEmpty()) {
            InOutSystem.println("거래내역이 비어있습니다.");
            return;
        }
        int sumPrice = 0;
        for(AccountDto accountDto: list) {
            InOutSystem.println("날짜: " + accountDto.getDate()
            + " 유형: " + accountDto.getTransactionName()
            + " 카테고리: " + accountDto.getCategoryType().getLabel()
            + " 금액: " + accountDto.getPrice());
            InOutSystem.println("메모: " + accountDto.getMemo());
            sumPrice += accountDto.getPrice();
        }

        InOutSystem.println("총 " + sumPrice + "원입니다.");
    }

    public void deleteTransaction() {
        String date = InOutSystem.strInput("해당 날짜를 입력하세요 > ");
        

    }
    private CategoryEnum selectCategoryEnum(int command) {
        if(command == 1) return CategoryEnum.FOOD;
        else if(command == 2) return CategoryEnum.UTILITY;
        else if(command == 3) return CategoryEnum.TRANSPORT;
        else if(command == 4) return CategoryEnum.SALARY;
        else return CategoryEnum.BONUS;
    }
}
