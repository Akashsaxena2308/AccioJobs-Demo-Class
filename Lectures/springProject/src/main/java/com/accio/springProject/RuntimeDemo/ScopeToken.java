package com.accio.springProject.RuntimeDemo;

import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ScopeToken {
    private final String instanceId = UUID.randomUUID().toString();

    public String getInstanceId() {
        return instanceId;
    }
}