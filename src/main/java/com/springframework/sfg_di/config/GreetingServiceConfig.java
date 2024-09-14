package com.springframework.sfg_di.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import com.springframework.sfg_di.datasoruce.FakeDataSource;
import com.springframework.sfg_di.repositories.EnglishGreetingRepository;
import com.springframework.sfg_di.repositories.EnglishGreetingRepositoryImpl;
import com.springframework.sfg_di.services.ConstructorGreetingService;
import com.springframework.sfg_di.services.I18nEnglishGreetingService;
import com.springframework.sfg_di.services.I18nTamilService;
import com.springframework.sfg_di.services.PrimaryGreetingService;
import com.springframework.sfg_di.services.PropertyInjectedGreetingService;
import com.springframework.sfg_di.services.SetterInjectedGreetingService;

@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${com.username}") String username, @Value("${com.password}") String password,
            @Value("${com.jdbcurl}") String jdbcurl) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUserName(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);

        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({ "dog", "default" })
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

    @Profile({ "TN", "default" })
    @Bean("i18nService")
    I18nTamilService i18nTamilService() {
        return new I18nTamilService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    // @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }
}
