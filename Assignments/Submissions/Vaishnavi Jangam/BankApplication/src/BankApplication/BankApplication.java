package BankApplication;

public class BankApplication {
//    bank account
//    name
//    balance
//    password
//    UUID.randomUUID().toString();



    public static void main(String[] args){
//        BankAccount b1 = new BankAccount("John", "1234", 10000);
//        BankAccount b2 = new BankAccount("doe", "5678", 5000);
//
//        System.out.println(b1.checkBalance("1234"));
//        System.out.println(b2.checkBalance("1234"));
//        System.out.println(b2.checkBalance("5678"));
//
//        System.out.println(b1.addMoney(5000));
//        System.out.println(b1.checkBalance("1234"));
//
//        System.out.println(b1.changePassword("1234","0000"));
//        System.out.println(b1.withDrawMoney(1000,"1234"));
//        System.out.println(b1.withDrawMoney(5000, "0000"));
//        System.out.println(b1.checkBalance("0000"));

        SBI sbiAcc = new SBI("Vaishnavi", "1122", 100000);
        HDFC hdfcAcc = new HDFC("Pallavi", "4321", 120000);
        SBIPremium premiumAcc = new SBIPremium("abc" , "1234", 500000);

        System.out.println(sbiAcc.checkBalance("1122"));
        System.out.println(hdfcAcc.checkBalance("4321"));
        System.out.println(sbiAcc.calculateInterestAfterYears(1));
        System.out.println(hdfcAcc.calculateInterestAfterYears(1));

        try{
            System.out.println(sbiAcc.addMoney(1000, 100));

            System.out.println(sbiAcc.addMoney(-300));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


//        BankInterface bank1 = new SBI("Vaishnavi", "1234", 100000);
//        System.out.print(bank1.checkBalance("1234"));


        try{
            System.out.println(hdfcAcc.checkBalance("0000"));
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

}

