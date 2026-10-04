package org.example.Product;

import org.w3c.dom.ls.LSOutput;

public class Discount extends Product{
    int dis;
    public Discount(String name, int price, int dis){
        super(name, price);
        this.dis = dis;
    }



    public int apply_Discount(){
        System.out.println(this.dis/100);
        System.out.println((this.dis*this.price)/100);
        return (this.price) - ((this.dis*this.price)/100);
    }
}
