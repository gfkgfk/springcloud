package com.example.springcloudsleuthprovider.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("sleuth1")
public class SleuthProvider1Controller {

    Logger loggerFactory = LoggerFactory.getLogger(this.getClass());


    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public String sleuth1() {
        loggerFactory.info("调用Sleuth-Provider1的hello接口");
        return restTemplate.getForEntity("http://Sleuth-Provider2/sleuth2", String.class).getBody();
    }


}
