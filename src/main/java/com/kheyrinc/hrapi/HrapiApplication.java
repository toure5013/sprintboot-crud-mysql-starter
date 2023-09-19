package com.kheyrinc.hrapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@SpringBootApplication
public class HrapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrapiApplication.class, args);
        //Logger.getLogger("INFO");
    }

}
