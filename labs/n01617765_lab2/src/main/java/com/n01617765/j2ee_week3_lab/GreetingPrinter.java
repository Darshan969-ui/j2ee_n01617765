package com.n01617765.j2ee_week3_lab;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class GreetingPrinter {


        private final GreetingService greetingService;

        @Autowired
        public GreetingPrinter(GreetingService greetingService) {
                this.greetingService = greetingService;
        }


      /*  public void printGreeting() {
                System.out.println(greetingService.greet());
        }*/





}
