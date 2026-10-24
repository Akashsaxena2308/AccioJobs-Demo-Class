package com.accio.springProject.springBeans;

public class Writter {
    private final MessageFormatter formatter;

    public Writter(MessageFormatter formatter){
        this.formatter = formatter;
    }

    public String write(String name){
        return formatter.greet(name);
    }
}
