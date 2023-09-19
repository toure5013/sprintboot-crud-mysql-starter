package com.kheyrinc.hrapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // This means that this class is a Controller
@RequestMapping(path="") // This means URL's start with /demo (after Application path)
@SpringBootApplication
public class HrapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrapiApplication.class, args);
    }


    @GetMapping(path  ="/")
    public String welcome(){
        return "Welcome to hr api v1 :)";
    }

}
