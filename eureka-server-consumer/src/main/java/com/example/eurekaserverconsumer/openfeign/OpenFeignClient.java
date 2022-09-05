package com.example.eurekaserverconsumer.openfeign;

import com.example.eurekaserverconsumer.bean.TestUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("Server-Provider")
public interface  OpenFeignClient {
    @GetMapping("/testuser/{id:\\d+}")
    public TestUser  get(@PathVariable Long id);

    @GetMapping("/testuser")
    public List<TestUser> get();

    @PostMapping("/testuser")
    public void add(@RequestBody TestUser TestUser);

    @PutMapping("/testuser")
    public void update(@RequestBody TestUser TestUser);


    @DeleteMapping("/testuser/{id:\\d+}")
    public void delete(@PathVariable Long id);

}
