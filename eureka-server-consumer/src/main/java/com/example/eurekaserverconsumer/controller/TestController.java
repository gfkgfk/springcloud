package com.example.eurekaserverconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/info")
    public String getInfo() {
        return this.restTemplate.getForEntity("http://Server-Provider/info", String.class).getBody();
    }
    @GetMapping("/getservertest")
    public String getServerTest() { //接口放在eureka server上无法调用
        return this.restTemplate.getForEntity("http://Eureka-Server/test", String.class).getBody();
    }

}
