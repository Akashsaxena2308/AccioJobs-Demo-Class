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
        BankAccount sbi = new SBI("Pratik Shinde", "1234", 500000);
        BankAccount sbi_Preminum = new PremiumSBI("Pratik Shinde", "1234", 5000000);
        try {
            System.out.println("Money added to the account :"+ sbi.addMoney(1000000));
//            System.out.println("Money added to the account :"+ sbi.addMoney(-1000000)); -> Will throw an error
            System.out.println("The amount of money withdrawn : \n"+ sbi.withDrawMoney(10000, "1234"));
//            sbi.withDrawMoney(2000, "4532"); -> Invalid password
            System.out.println("Balance in the account : "+ sbi.checkBalance("1234"));

            System.out.println("-------------------------------------------------------------");
            System.out.println("Money added to the account :"+ sbi_Preminum.addMoney(1000000));
//            System.out.println("Money added to the account :"+ sbi_Preminum.addMoney(-1000000));
            System.out.println("The amount of money withdrawn : \n"+ sbi_Preminum.withDrawMoney(10000, "1234"));
//            sbi.withDrawMoney(2000, "4532"); -> Invalid password
            System.out.println("Balance in the account : "+ sbi_Preminum.checkBalance("1234"));
//            sbi_Preminum.checkBalance("59483"); -> Invalid password
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("the rate of interest : "+ sbi.getInterestRate());
            System.out.println("Name of the bank : "+sbi.getBankName());

            System.out.println("--------------------------------");
            System.out.println("the rate of interest : "+ sbi_Preminum.getInterestRate());
            System.out.println("Name of the bank : "+sbi_Preminum.getBankName());
            System.out.println("Operation completed");
        }
    }
}
