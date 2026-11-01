package com.accio.springProject.BeanScope;

import org.springframework.context.ApplicationContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ScopeController {
    private final ApplicationContext context;

    public ScopeController(ApplicationContext context){
        this.context = context;
    }

    @GetMapping("/demo/scope")
    public Map<String, Object> scopeMethod(){
        ScopeToken token1 = context.getBean(ScopeToken.class);
        ScopeToken token2 = context.getBean(ScopeToken.class);

        return Map.of(
                "first", token1.getInstanceId(),
                "second", token2.getInstanceId()
        );
    }


}
