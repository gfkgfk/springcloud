package com.example.eurekaserverconsumer.controller;

import com.example.eurekaserverconsumer.bean.TestUser;
import com.example.eurekaserverconsumer.openfeign.OpenFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OpenFeignController {
    @Autowired
    OpenFeignClient openFeignClient;


    @GetMapping("/openfeign/get")
    public TestUser getOpenFeignUser() {
        return this.openFeignClient.get(Long.valueOf(1));
    }


    @GetMapping("/openfeign/getlist")
    public List<TestUser> getOpenFeignUserList() {
        return this.openFeignClient.get();
    }


    @PostMapping("/openfeign/post")
    public void add(@RequestBody TestUser testUser) {
        this.openFeignClient.add(testUser);
    }


    @PutMapping("/openfeign/put")
    public void update(@RequestBody TestUser testUser) {
        this.openFeignClient.update(testUser);
    }


    @DeleteMapping("/openfeign/{id:\\d+}")
    public void delete(@PathVariable Long id) {
        this.openFeignClient.delete(id);
    }


}
