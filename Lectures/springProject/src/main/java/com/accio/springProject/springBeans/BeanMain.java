package com.accio.springProject.springBeans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanMain {

    public static void main(String[] args){
        try(var context =  new AnnotationConfigApplicationContext("com.accio.springProject.springBeans")){

            MessageFormatter formatter = context.getBean(MessageFormatter.class);

            System.out.println(formatter.greet("John"));

            Writter writer1 = context.getBean(Writter.class);
            System.out.println(writer1.write("Jane"));
        }
    }
}
