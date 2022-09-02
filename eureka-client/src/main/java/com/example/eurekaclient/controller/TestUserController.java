package com.example.eurekaclient.controller;

import com.example.eurekaclient.bean.TestUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("testuser")
public class TestUserController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/{id:\\d+}")
    public TestUser get(@PathVariable Long id) {
        log.info("获取用户id为 " + id + "的信息");
        return new TestUser(id, "kent", "123456");
    }

    @GetMapping
    public List<TestUser> get() {
        List<TestUser> list = new ArrayList<>();
        list.add(new TestUser(1L, "kent", "123456"));
        list.add(new TestUser(2L, "scott", "123456"));
        log.info("获取用户信息 " + list);
        return list;
    }

    @PostMapping
    public void add(@RequestBody TestUser TestUser) {
        log.info("新增用户成功 " + TestUser);
    }

    @PutMapping
    public void update(@RequestBody TestUser TestUser) {
        log.info("更新用户成功 " + TestUser);
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable Long id) {
        log.info("删除用户成功 " + id);
    }
}
