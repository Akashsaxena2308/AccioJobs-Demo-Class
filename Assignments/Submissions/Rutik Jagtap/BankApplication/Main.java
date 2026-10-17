public class Main {

    public static void main(String[] args) {

        BankAccount b1 =
                new SBI("Rutik", "1234", 1000000);

        BankAccount b2 =
                new HDFC("Pratik", "23456", 1000004);

        BankAccount b3 =
                new PremiumSBI("Amit", "9999", 500000);


        System.out.println("Bank: " + b1.getBankName());

        System.out.println(b1.checkBalance("12345"));

        System.out.println(b1.checkBalance("1234"));


        b1.deposite(1234);

        System.out.println(b1.checkBalance("1234"));


        b1.withdraw(32, "1234");


        b1.changePassword("1234", "3987");

        b1.changePassword("1234", "2345");


        System.out.println(b1.checkBalance("3987"));


        System.out.println("Bank: " + b2.getBankName());

        System.out.println(b2.checkBalance("23456"));


        System.out.println("Bank: " + b3.getBankName());

        System.out.println("Interest Rate: "
                + b3.getInterestRate() + "%");

        System.out.println("Interest for 2 years: "
                + b3.calculateInterestAfterYear(2));
    }
}