package com.zkl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@ServletComponentScan//开启servlet组件的支持
@SpringBootApplication
public class SpringbootWebProject3Application {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootWebProject3Application.class, args);
    }

}
