package BankApplication;

class SBIPremium extends SBI{
    SBIPremium(String name, String password, int balance){
        super(name, password, balance);
    }

    @Override
    public String getName(){
        return "Premium SBI";
    }

    public int getInterestRate(){
        return super.getInterestRate() + 1;
    }

}
