
public class SBI extends BankAccount{
    SBI(String name,String password,int balance){

        super(name,password,balance);
    }

    @Override
    public double getInterestRate() {
        return 6.0;
    }
    @Override
    public String getBankName() {

        return "SBI";
    }
}
