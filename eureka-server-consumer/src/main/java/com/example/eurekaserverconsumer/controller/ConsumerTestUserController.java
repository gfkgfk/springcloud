package com.example.eurekaserverconsumer.controller;

import com.example.eurekaserverconsumer.bean.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ConsumerTestUserController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("TestUser/{id:\\d+}")
    public TestUser getTestUser(@PathVariable Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        URI uri = UriComponentsBuilder.fromUriString("http://Server-Provider/testuser/{id}")
                .build().expand(params).encode().toUri();
        return this.restTemplate.getForEntity(uri, TestUser.class).getBody();
    }

    @GetMapping("TestUser")
    public List<TestUser> getTestUsers() {
        return this.restTemplate.getForObject("http://Server-Provider/testuser", List.class);
    }

    @GetMapping("TestUser/add")
    public String addTestUser() {
        TestUser TestUser = new TestUser(1L, "mrbird", "123456");
        HttpStatus status = this.restTemplate.postForEntity("http://Server-Provider/testuser", TestUser, null).getStatusCode();
        if (status.is2xxSuccessful()) {
            return "新增用户成功";
        } else {
            return "新增用户失败";
        }
    }

    @GetMapping("TestUser/update")
    public void updateTestUser() {
        TestUser TestUser = new TestUser(1L, "mrbird", "123456");
        this.restTemplate.put("http://Server-Provider/testuser", TestUser);
    }

    @GetMapping("TestUser/delete/{id:\\d+}")
    public void deleteTestUser(@PathVariable Long id) {
        this.restTemplate.delete("http://Server-Provider/testuser/{1}", id);
    }
}
