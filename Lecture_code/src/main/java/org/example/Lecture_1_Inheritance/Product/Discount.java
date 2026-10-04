package org.example.Lecture_1_Inheritance.Product;

public class Discount extends Product{
    int price_cut;
    public Discount(String name, int price, int price_cut){
        super(name, price);
        this.price_cut = price_cut;
    }

    public int apply_discount(){
        this.price = (int)(price - ((price)*((double)(price_cut)/100)));
        return price;
    }

    public void print() {
        System.out.println("Name: " + name + ", Price: " + price + ", Price Cut: " + price_cut + "%");
    }
}
