package BankApplication;

class HDFC extends BankAccount{

    HDFC(String name, String password, int balance){
        super(name, password, balance);
    }
    @Override
    public String getBankName(){
        return "HDFC";
    }

    public int getInterestRate(){
        return 7;
    }

}
