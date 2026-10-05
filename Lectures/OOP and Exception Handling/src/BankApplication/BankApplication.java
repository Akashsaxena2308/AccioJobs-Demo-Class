package BankApplication;

import java.util.UUID;

public class BankApplication {
    //Bank Account
    //name
    //accoutNo
    //password
    //balance
    //checkBalance() --> Password protected
    //UUID.randomUUID().toString();

    //INT MAX = 10
    // a = 7
    // b = 5
    // a  < INT - b

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

        SBI sbiAccount = new SBI("James", "1122", 10000);
        HDFC hdfcAccount = new HDFC("Lee", "5566", 10000);

        System.out.println(sbiAccount.checkBalance("1122"));
        System.out.println(hdfcAccount.checkBalance("5566"));
        System.out.println(sbiAccount.calculateInterestAfterYears(1));
        System.out.println(hdfcAccount.calculateInterestAfterYears(1));



        System.out.println(sbiAccount.addMoney(1000, 100));
        System.out.println(sbiAccount.checkBalance("1122"));

        BankInterface bank1 = new SBI("Jane", "5555", 10000);
    }
}
