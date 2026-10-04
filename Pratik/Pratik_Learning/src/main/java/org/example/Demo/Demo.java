package org.example.Demo;

import org.example.Product.*;

public class Demo {
    public static void main(String[] args) {
        Discount l1 = new Discount("Mac_book", 80000, 30);
        System.out.println(l1.apply_Discount());
//        System.out.println(l1.apply_Discount());
        l1.print();
    }
}
