package question_7;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Accounts>  list;

    public Bank(){
        this.list = new ArrayList<>();
    }

    public String add_account(Accounts account_no) throws Invalid_Detail{
        if (list.contains(account_no)){
            throw new Invalid_Detail("This account already exists.");
        }
        list.add(account_no);

        return "User add successfully";
    }

    public String remove_account(String account_no) throws Invalid_Detail{
        for (Accounts acc: list){
            if (acc.getAccount_no().equals(account_no)){
                list.remove(acc);
                return "Account deleted successfully";
            }
        }

        throw new Invalid_Detail("Please enter valid credential");
    }

    public void deposit_money(Accounts acc1){

    }

}
