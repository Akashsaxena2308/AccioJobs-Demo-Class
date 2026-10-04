package org.example.Abstraction_Interface;

public class Client {
    public static void main(String args[]){
        Computer com = new Laptop();
        Dev dev = new Dev();
        dev.code(com);
    }
}
