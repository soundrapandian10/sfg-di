package com.springframework.sfg_di.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean {

    public PrototypeBean() {
        System.out.println("Creating A Prototype Bean!");
    }

    public String getMyScope() {
        return "I'am a Prototype!";
    }
}
