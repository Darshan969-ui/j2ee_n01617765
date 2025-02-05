package com.n01617765.j2ee_week3_lab;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@Configurable
public class AppConfig {


    @Bean
//    @Scope("prototype")
    GreetingService greetingService() {
        return new GreetingService();
    }


}
