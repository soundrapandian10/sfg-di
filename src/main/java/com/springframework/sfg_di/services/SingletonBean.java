package com.springframework.sfg_di.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("Creating A Singleton Bean!");
    }

    public String getMyScope() {
        return "I'am a Singleton!";
    }
}
