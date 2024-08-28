package com.demo.microservice.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/eureka")
public class EurekaController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/user-info")
    public Map<String, String> getUserInfo() {
        String userId = "101";
        String username = "Antony";

        EurekaClient eurekaClient = (EurekaClient) applicationContext.getBean("eurekaClient");
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("EUREKA-CLIENT", false);

        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("userId", userId);
        userInfo.put("username", username);
        userInfo.put("eurekaClientIP", instanceInfo.getIPAddr());
        userInfo.put("eurekaServerHost", instanceInfo.getHostName());
        userInfo.put("eurekaServerPort", String.valueOf(instanceInfo.getPort()));

        return userInfo;
    }
}