package com.demo.microservice;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class BookApplication extends SpringBootServletInitializer implements
    WebApplicationInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return customizerBuilder(builder);
  }
  public static void main(String[] args) {
    SpringApplication.run(BookApplication.class, args);
  }
  private static SpringApplicationBuilder customizerBuilder(SpringApplicationBuilder builder) {
    return builder.sources(BookApplication.class).bannerMode(Banner.Mode.OFF);
  }
}