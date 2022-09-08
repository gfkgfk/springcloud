package com.example.springcloudsleuthprovider2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sleuth2")
public class SleuthProvider2Controller {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public String sleuth2(){
        logger.info("调用server-provider2的hello接口");
        return "interface test";
    }
}
