package com.example.springbootannotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringBootAnnotationsApplication {

  public static void main(final String[] args) {
    SpringApplication.run(SpringBootAnnotationsApplication.class, args);
  }

}
