package com.n01617765.j2ee_week3_lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class J2eeWeek3LabApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        GreetingService greetingService = context.getBean(GreetingService.class);

        System.out.println(greetingService.greet());

        context.close();
    }


}
