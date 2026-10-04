package org.example.Lecture_1_Inheritance.Client;

import org.example.Lecture_1_Inheritance.Product.Discount;
import org.example.Lecture_1_Inheritance.Product.Product;

public class Client {
    public static void main(String args[]){
        Discount laptop = new Discount("laptop", 50000, 20);
        laptop.print();
        laptop.apply_discount();
        laptop.print();
    }
}
