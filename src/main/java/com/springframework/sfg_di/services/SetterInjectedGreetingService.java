package com.springframework.sfg_di.services;

public class SetterInjectedGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - Setter";
    }
}
