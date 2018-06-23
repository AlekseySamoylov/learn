package com.alekseysamoylov.learn.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import com.alekseysamoylov.learn.service.CardService;

@Component
@ManagedResource(objectName = "learn:bean=ServiceManager,type=service", description = "Trigger Services via JMX", log = true)
public class ServiceMbean {

    @Autowired
    private CardService cardService;

    @ManagedOperation(description = "Triggers specified service once")
    @ManagedOperationParameters({@ManagedOperationParameter(name = "message",
            description = "Message to print into console")})
    public void triggerOnce(String message) {
        cardService.testMethodForJmx(message);
    }
}
