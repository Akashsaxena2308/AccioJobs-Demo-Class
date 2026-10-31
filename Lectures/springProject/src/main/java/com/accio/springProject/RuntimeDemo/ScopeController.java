
package com.accio.springProject.RuntimeDemo;

import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScopeController {
    private final ApplicationContext context;

    public ScopeController(ApplicationContext context) {
        this.context = context;
    }

    @GetMapping("/demo/scope")
    public Map<String, Object> inspectScope() {
        ScopeToken first = context.getBean(ScopeToken.class);
        ScopeToken second = context.getBean(ScopeToken.class);
        return Map.of(
                "first", first.getInstanceId(),
                "second", second.getInstanceId(),
                "sameInstance", first == second);
    }
}
