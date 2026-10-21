package question_7;

import java.util.UUID;

public abstract class Accounts {
    private final String account_no;
    private final String name;
    private String password;
    private Long money;

    public Accounts(String name, String password, Long money) throws Invalid_Detail{
        if (name.isBlank() || password.length() > 7){
            throw new Invalid_Detail("Please enter correct cerdential.");
        }

        if (money < 5000){
            throw new Invalid_Detail("Need minimum of 5000 rupee to create a account");
        }
        this.account_no = UUID.randomUUID().toString();
        this.name = name;
        this.password = password;
        this.money = money;
    }

    public void reset_password(String new_password) throws Invalid_Detail{
        if (new_password.length() > 7) throw new Invalid_Detail("Please enter valid password");
        if(new_password.equals(password)) throw new Invalid_Detail("Please enter new correct password");
        this.password = new_password;
    }

    public String deposit_money(Long money) throws Invalid_Detail{
        if (money <= 0){
            throw new Invalid_Detail("Please enter valid amount");
        }
        this.money += money;
        return money+" successfully deposited";
    }

    public String withdraw_money(Long cash, String pin) throws Invalid_Detail{
        if (!pin.equals(password)){
            throw new Invalid_Detail("Please enter valid details");
        }

        if (cash <= 0 || cash > this.money){
            throw new Invalid_Detail("Please enter valid amount");
        }

        this.money -= cash;

        return cash+" withdrawn";
    }

    public Long getMoney(){
        return this.money;
    }

    public String getAccount_no() {
        return account_no;
    }

    public String getName() {
        return name;
    }

    public String getPassword(){
        return password;
    }
}
