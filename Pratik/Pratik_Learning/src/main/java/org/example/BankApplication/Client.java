package org.example.BankApplication;

public class Client {
    // Bank Account
    // name
    // accountNo
    // password
    // balance
    // checkBalance
    public static void main(String args[]){
        System.out.println("======== BANK APPLICATION TESTING ========\n");

        // 1. Create an sbi Account
        System.out.println("========== SBI ============");
        Bank_Account sbiAccount = new SBI("Alice Smith", "1234", 10000);
        sbiAccount.withDrawMoney("1234", 1000);
        sbiAccount.add_money(5000);
        sbiAccount.receipt("1234");
        System.out.println();

        System.out.println("========== HDFC ============");
        Bank_Account hdfcAccount = new HDFC("Pratik Shinde", "12345", 100000000);
        hdfcAccount.receipt("12345");

        hdfcAccount.withDrawMoney("1234", 1000);
        hdfcAccount.add_money(5000);
        hdfcAccount.receipt("1234");
    }
}
