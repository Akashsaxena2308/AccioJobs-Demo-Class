package BankApplication;

public class SBI extends BankAccount {
    public SBI(String name, String password, int balance) {
        super(name, password, balance);
    }

    @Override
    public String getBankName() {
        return "SBI";
    }

    @Override
    public int getInterestRate() {
        return 6;
    }
}
