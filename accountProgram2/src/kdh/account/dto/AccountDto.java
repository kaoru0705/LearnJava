package kdh.account.dto;
import kdh.account.util.CategoryEnum;

public class AccountDto {
    private String transactionName;
    private String date;
    private CategoryEnum type;
    private int price;
    private String memo;

    public AccountDto(String transactionName, String date, CategoryEnum type, int price, String memo) {
        this.transactionName = transactionName;
        this.date = date;
        this.type = type;
        this.price = price;
        this.memo = memo;
    }

    public AccountDto() {
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public CategoryEnum getCategoryType() {
        return type;
    }

    public void setCategoryType(CategoryEnum type) {
        this.type = type;
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