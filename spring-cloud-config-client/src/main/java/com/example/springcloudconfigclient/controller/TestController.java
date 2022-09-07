package com.example.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {
    @Value("${message}")
    private String message;


    @GetMapping("/message")
    public String getMessage() {
        System.out.println("当前配置信息message:"+this.message);
        return this.message;
    }
}
