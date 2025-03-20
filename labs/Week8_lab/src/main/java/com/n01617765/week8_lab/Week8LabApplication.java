package com.n01617765.week8_lab;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "My API", version = "1.0",description = "Documentation for my API   "))
public class Week8LabApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week8LabApplication.class, args);
    }

}
