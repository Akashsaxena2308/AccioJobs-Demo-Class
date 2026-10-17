
public  class HDFC extends BankAccount {
    public HDFC(String name, String Password, int balance) {

        super(name, Password, balance);
    }

    @Override
    public String getBankName() {
        return "HDFC";
    }
    @Override
    public double getInterestRate() {
        return 7.0;
    }

}
