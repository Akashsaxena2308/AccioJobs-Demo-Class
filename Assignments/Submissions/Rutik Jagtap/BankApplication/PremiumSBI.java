public class PremiumSBI extends SBI {

    public PremiumSBI(String name, String password, int balance) {
        super(name, password, balance);
    }

    @Override
    public String getBankName() {
        return "Premium SBI";
    }

    @Override
    public double getInterestRate() {
        return super.getInterestRate() + 0.5;
    }
}