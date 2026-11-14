package com.accio.springProject.RestClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import java.net.http.HttpClient;
import java.time.Duration;

@Configuration
public class RestClientConfiguration {

    @Bean
    public RestClient taskRestClient(
            @Value("${external.tasks.base-url}") String baseUrl){

        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(2)) //Hospital service --> JSON service
                .build(); //Connection timeout ---> 2 seconds

        //Connection is succesful --> JSON service --> Takes too long to give response

        JdkClientHttpRequestFactory factory = //Rules or specific configuration
                new JdkClientHttpRequestFactory(httpClient);
        factory.setReadTimeout(Duration.ofSeconds(3));

        return RestClient.builder()
                .baseUrl(baseUrl)
                .requestFactory(factory)
                .build();
    }

//    @Bean
//    public RestClient task1RestClient(
//            @Value("${external.tasks1.base-url}") String baseUrl){
//        return RestClient.builder()
//                .baseUrl(baseUrl)
//                .build();
//    }
}


//Hospital user ---> todos/5


// Hospital service --> jsonplaceholder service  || 2sec ||

// Jsonplaceholder down / slow / return an error

//400 --> Bad request
//404 --> Not found
//500 --> Internal service error
//502 -->


// Communication
//
