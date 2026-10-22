package BankApplication;

class SBI extends BankAccount{

    int interestRate = 6;
    SBI(String name, String password, int balance){
        super(name, password, balance);
    }

    public String getBankName(){
        return "SBI";
    }

    public int getInterestRate(){
        return interestRate;
    }

}
