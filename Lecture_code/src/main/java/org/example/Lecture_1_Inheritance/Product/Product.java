package org.example.Lecture_1_Inheritance.Product;

public class Product {
    String name;
    int price;
    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public void print() {
        System.out.println("Name: " + name + ", Price: " + price);
    }
}
