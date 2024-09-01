package com.springframework.sfg_di.controllers;

import org.springframework.stereotype.Controller;

import com.springframework.sfg_di.services.PrimaryBean;

@Controller
public class MyController {

    private final PrimaryBean primaryBean;

    public MyController(PrimaryBean primaryBean) {
        this.primaryBean = primaryBean;
    }

    public String sayHello() {
        return primaryBean.sayGreeting();
    }
}
