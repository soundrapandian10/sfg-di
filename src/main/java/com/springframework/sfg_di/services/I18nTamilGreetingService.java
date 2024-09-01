package com.springframework.sfg_di.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"TN","default"})
@Service("i18Services")
public class I18nTamilGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Vaṇakkam ulakam - TN";
    }

}
