package BankApplication;

public class CheckedExceptionDemo {
    public static void main(String[] args) {
        BankInterface account = new SBI("Asha", "1234", 1000);

        // CLASSROOM EXPERIMENT: uncomment only the next line and compile.
        // Even with enough funds, the compiler checks the method's declaration.
        // account.withDrawMoney(100, "1234"); // COMPILE_ERROR_DEMO

        // Compiler: unreported exception InsufficientFundsException;
        // must be caught or declared to be thrown.
        // Comment that line again, then demonstrate the working catch below.
        try {
            System.out.println(account.withDrawMoney(100, "1234"));
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        // This method propagates the checked exception, so its caller handles it.
        try {
            withdrawUsingHelper(account);
        } catch (InsufficientFundsException e) {
            System.out.println("Handled by caller: " + e.getMessage());
        }
        System.out.println("Balance: " + account.checkBalance("1234"));
    }

    private static void withdrawUsingHelper(BankInterface account)
            throws InsufficientFundsException {
        account.withDrawMoney(2000, "1234");
    }
}
