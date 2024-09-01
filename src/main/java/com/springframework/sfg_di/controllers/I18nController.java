package com.springframework.sfg_di.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.springframework.sfg_di.services.GreetingService;

@Controller
public class I18nController {

    private final GreetingService greetingService;

    public I18nController(@Qualifier("i18Services") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
