package com.example.eurekaserverconsumer.controller;

import com.example.eurekaserverconsumer.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConsumerProviderController {
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


    @GetMapping("/getprovideruserstr/{id:\\d+}")
    public String getProviderUserStr(@PathVariable String id) { //接口放在eureka server上无法调用
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return this.restTemplate.getForEntity("http://Server-Provider/user/{id}", String.class,map).getBody();
    }


    @GetMapping("/getprovideruserjson/{id:\\d+}")
    public User getProviderUserJson(@PathVariable String id) { //接口放在eureka server上无法调用
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return this.restTemplate.getForEntity("http://Server-Provider/user/{id}", User.class,map).getBody();
    }
    @GetMapping("/getprovideruser/{id:\\d+}")
    public User getProviderUser(@PathVariable String id) { //接口放在eureka server上无法调用
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return this.restTemplate.getForEntity("http://Server-Provider/provideruser/{id}", User.class,map).getBody();
    }

}
