package BankApplication;

public class BankApplication {
    public static void main(String[] args) {
        SBI sbiAccount = new SBI("James", "1122", 10000);
        HDFC hdfcAccount = new HDFC("Lee", "5566", 10000);

        System.out.println("SBI interest: " + sbiAccount.calculateInterestAfterYears(1));
        System.out.println("HDFC interest: " + hdfcAccount.calculateInterestAfterYears(1));
        System.out.println(sbiAccount.addMoney(1000, 100));

        // 1. Unchecked exception: catch is optional to compile, useful to recover.

            sbiAccount.addMoney(-1);


        // 2. Checked exception: the caller must catch it or declare throws.
        BankInterface account = sbiAccount;
        try {
            System.out.println(account.withDrawMoney(20000, "1122"));
        } catch (InsufficientFundsException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }
        System.out.println("Balance after failed withdrawal: " + account.checkBalance("1122"));

        // 3. A valid withdrawal succeeds; a negative withdrawal is rejected.

//        account.withDrawMoney(1000, "1122");
        try {
            System.out.println(account.withDrawMoney(2000, "1122"));
            account.withDrawMoney(-100, "1122");
        } catch (InsufficientFundsException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        } catch (InvalidAmountException e) {
            System.out.println("Invalid amount: " + e.getMessage());
        } finally {
            System.out.println("Withdrawal attempt completed");
        }
        System.out.println("Final balance: " + account.checkBalance("1122"));
        System.out.println("Application continues after handled failures");
    }
}
