package com.demo.microservice.eureka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/eureka")
public class EurekaController {

    @GetMapping("/user-info")
    public Map<String, String> getUserInfo() {
        String userId = "12345";
        String username = "johnDoe";

        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("userId", userId);
        userInfo.put("username", username);

        return userInfo;
    }
}
