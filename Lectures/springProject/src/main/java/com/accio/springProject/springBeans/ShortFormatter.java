package com.accio.springProject.springBeans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
public class ShortFormatter implements  MessageFormatter{

    public String greet(String name){
        return "Hi! " + name;
    }
}
