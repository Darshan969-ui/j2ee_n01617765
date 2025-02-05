package com.n01617765.j2ee_week3_lab;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {


    public String greet() {
        return "Hello Spring Boot!";
    }

    @PostConstruct
    public void init(){
        System.out.println("GreetingService bean created!");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Closing the Appication, Thankyou!");
    }

}
