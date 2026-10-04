package org.example.Product;

public class Product{
    String name;
    int price;
    static int cnt;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
        cnt += 1;
    }

    public void change_Price(int new_price) {
        this.price = new_price;
    }

    public void print() {
        System.out.println(this.name + " " + this.price + " " + this.cnt);
    }
}
