package com.accio.springProject.springBeans;

import org.springframework.stereotype.Component;

//@Component
public class LongFormatter implements MessageFormatter{

    public String greet(String name){
        return "Welcome to Hospital! " + name;
    }
}
