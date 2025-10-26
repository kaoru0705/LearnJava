package kdh.account.service;

import java.util.List;

import kdh.account.dto.AccountDto;
import kdh.account.repository.Repository;
import kdh.account.util.CategoryEnum;
import kdh.account.util.InOutSystem;

public class Service {
    Repository repository = new Repository();

    public void addTransaction() {
        InOutSystem.println("거래 등록을 선택하셨습니다.");
        int transactionCommand = InOutSystem.IntegerInput("1. 수입 2. 지출 > ");

        while(transactionCommand != 1 && transactionCommand != 2) {
            InOutSystem.println("입력을 다시 해주세요.");
            transactionCommand = InOutSystem.IntegerInput("수입 혹은 지출을 입력하세요. > ");
        }
        String transactionName = (transactionCommand == 1) ? "수입" : "지출";

        // repository.addTransaction(transactionCommand);
        String date = InOutSystem.strInput("해당 날짜를 입력해주세요. > ");

        CategoryEnum type = selectCategoryEnum();

        int price = InOutSystem.IntegerInput("금액을 입력해주세요. > ");
        
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
            int sign = (accountDto.getTransactionName().equals("지출")) ? -1 : 1;
            sumPrice += accountDto.getPrice() * sign;
        }

        InOutSystem.println("총 " + sumPrice + "원입니다.");
    }

    public void deleteTransaction() {
        String date = InOutSystem.strInput("해당 날짜를 입력하세요 > ");
        CategoryEnum type = selectCategoryEnum();

        int deleteCount = repository.deleteByDateAndType(date, type);
        if(deleteCount == 0) {
            InOutSystem.println(date + "날짜에 " + type.getLabel()+"은 존재하지 않습니다.");
        }
        InOutSystem.println("총 " + deleteCount + "건 삭제 되었습니다.");
    }

    public void displaybyCategory() {
        for(CategoryEnum type : CategoryEnum.values()) {
            List <AccountDto> list = repository.findByCategory(type);
            if(list.isEmpty()) {
                InOutSystem.println(type.getLabel() + " 카테고리는 비어있습니다.");
                continue;
            }
            int sumByCategory = 0;
            
            for(AccountDto accountDto: list) {
                int sign = (accountDto.getTransactionName().equals("지출")) ? -1 : 1;
                sumByCategory += accountDto.getPrice() * sign;
            }

            InOutSystem.println(type.getLabel() + "별 합계는 " + sumByCategory + "원입니다.");
        }
    }

    public void displayPriceByDescending() {
        List <AccountDto> list = repository.findAll();

        if(list.isEmpty()) {
            InOutSystem.println("해당 카테고리는 비어있습니다.");
            return;
        }

        list.sort((a, b) -> b.getPrice() - a.getPrice());

        for(AccountDto accountDto: list) {
            InOutSystem.println("날짜: " + accountDto.getDate()
            + " 유형: " + accountDto.getTransactionName()
            + " 카테고리: " + accountDto.getCategoryType().getLabel()
            + " 금액: " + accountDto.getPrice());
            InOutSystem.println("메모: " + accountDto.getMemo());
        }

    }

    public void displayListByMemoContain() {
        String memo = InOutSystem.strInput("검색할 메모 키워드는? > ");
        List <AccountDto> list = repository.findByNammContain(memo);

        if(list.isEmpty()) {
            InOutSystem.println("관련된 메모는 존재하지 않습니다.");
            return;
        }
        for(AccountDto accountDto: list) {
            InOutSystem.println("날짜: " + accountDto.getDate()
            + " 유형: " + accountDto.getTransactionName()
            + " 카테고리: " + accountDto.getCategoryType().getLabel()
            + " 금액: " + accountDto.getPrice());
            InOutSystem.println("메모: " + accountDto.getMemo());
        }
    }

    private CategoryEnum selectCategoryEnum() {
        InOutSystem.println("======카테고리 선택=======");
        for(CategoryEnum type : CategoryEnum.values()) {
            InOutSystem.print(type.getCode() + ". " + type.getLabel());
            InOutSystem.print(" ");
        }
        InOutSystem.println("");
        int choice = InOutSystem.IntegerInput("해당 카테고리를 선택해주세요 > ");
        while(CategoryEnum.fromCode(choice) == null) {
            InOutSystem.println("해당 카테고리는 존재하지 않습니다.");
            choice = InOutSystem.IntegerInput("해당 카테고리를 선택해주세요 > ");
        }

        return CategoryEnum.fromCode(choice);
    }

}