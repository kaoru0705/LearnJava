import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<String, Object> map= new HashMap<>();
        map.put("hahaha", new StudentDto());
        map.put("hehehe", new AccountDto());
        
        for(Map.Entry<String, Object> entry: map.entrySet()) {
            if(entry.getValue() instanceof StudentDto) {
                StudentDto studentDto = (StudentDto)entry.getValue();
                studentDto.setName("강동훈");
            }

            if(entry.getValue() instanceof AccountDto) {
                AccountDto accountDto = (AccountDto)entry.getValue();
                accountDto.setCash(1000000);
            }
        }

        for(Map.Entry<String, Object> entry: map.entrySet()) {
            if(entry.getValue() instanceof StudentDto) {
                StudentDto studentDto = (StudentDto)entry.getValue();
                System.out.println(studentDto.getName());
            }

            if(entry.getValue() instanceof AccountDto) {
                AccountDto accountDto = (AccountDto)entry.getValue();
                System.out.println(accountDto.getCash());
            }
        }

    }
}

class StudentDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class AccountDto {
    private int cash;

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
