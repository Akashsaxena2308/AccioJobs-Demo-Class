package com.accio.springProject.RestClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfiguration {

    @Bean
    public RestClient taskRestClient(
            @Value("${external.tasks.base-url}") String baseUrl){
        return RestClient.builder()
                .baseUrl(baseUrl)
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
