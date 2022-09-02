package com.example.eurekaclient.controller;

import com.example.eurekaclient.bean.ProviderUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderUserController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Registration client;

    @GetMapping("/info")
    public String info() {
        @SuppressWarnings("deprecation")
        String info = "host：" + client.getHost() + "，service_id：" + client.getServiceId() + "  TestController------Kent";
        log.info(info);
        return info;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }


    @GetMapping("/user/{id:\\d+}")
    public String getUser(@PathVariable String id) {
        return "{\"id\":" + id + ",\"name\":\"kent\"}";
    }


    @GetMapping("/provideruser/{id:\\d+}")
    public ProviderUser getProviderUser(@PathVariable String id) {
        ProviderUser providerUser = new ProviderUser();
        providerUser.setId(id);
        providerUser.setName("GOGOGO");
        return providerUser;
    }








}
