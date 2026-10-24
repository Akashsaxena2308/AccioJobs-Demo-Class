package com.accio.springProject.springBeans;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanLabConfiguration {
    @Bean
    public MessageFormatter shortGreeting(){
        return new ShortFormatter();
    }

    @Bean
    @Primary
    public MessageFormatter longGreeting(){
        return new LongFormatter();
    }

    @Bean
    public Writter createWrite(@Qualifier("shortGreeting") MessageFormatter messageFormatter){
        return new Writter(messageFormatter);
    }
}
