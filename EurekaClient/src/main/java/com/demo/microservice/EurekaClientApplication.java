package com.demo.microservice;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientApplication {
  public static void main(String[] args) {
    SpringApplication.run(EurekaClientApplication.class, args);
  }
}