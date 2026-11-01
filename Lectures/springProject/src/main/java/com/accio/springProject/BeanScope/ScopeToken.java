package com.accio.springProject.BeanScope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("prototype")
public class ScopeToken {

    private final String instanceId = UUID.randomUUID().toString();

    public String getInstanceId(){
        return instanceId;
    }
}
