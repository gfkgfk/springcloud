package com.example.eurekaserverconsumer.controller;


import com.example.eurekaserverconsumer.bean.TestUser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ConsumerHystrixController {
    @Autowired
    private RestTemplate restTemplate;


    //服务消费端熔断降级
    @GetMapping("TestUserHystrix/{id:\\d+}")
    @HystrixCommand(fallbackMethod = "getUserDefault")
    public TestUser getTestUser(@PathVariable Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        URI uri = UriComponentsBuilder.fromUriString("http://Server-Provider/testuser/{id}")
                .build().expand(params).encode().toUri();
        return this.restTemplate.getForEntity(uri, TestUser.class).getBody();
    }

    public TestUser getUserDefault(Long id){
        TestUser testUser = new TestUser();
        testUser.setId(-1L);
        testUser.setUsername("服务不可用熔断");
        testUser.setPassword("123456");
        return testUser;
    }
}
