package com.moment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
public class MenuApplication {

    public static void main(String[] args){
        SpringApplication.run(MenuApplication.class,args);
        log.info("MenuApp booted");
    }
}
