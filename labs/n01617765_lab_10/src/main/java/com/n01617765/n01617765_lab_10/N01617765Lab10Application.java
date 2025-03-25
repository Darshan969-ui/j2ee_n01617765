package com.n01617765.n01617765_lab_10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@RestController
@RequestMapping(value="hello")
public class N01617765Lab10Application {

    public static void main(String[] args) {
        SpringApplication.run(N01617765Lab10Application.class, args);
    }



    @RequestMapping(value = "/{firstname}/{lastname}",method = RequestMethod.GET)
    public String hello(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname) {
        return String.format("{\"firstname\":\"%s\", \"lastname\":\"%s\"}", firstname, lastname);
    }



}
