package com.example.eurekaclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class HystrixController {

    @GetMapping("/hystrix/{id:\\d+}")
    @HystrixCommand(fallbackMethod = "TimeOutErrorHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    }) //1.HystrixCommand要放再getmapping这个方法下??(直接放timeOutError下没反应，没试过放到service中怎么样)，2TimeOutErrorHandler参数要一致
    public String getHystrix(@PathVariable Long id){

        return timeOutError(id);
    }



    public String timeOutError(Long id) {
        try {
            //我们让这个方法休眠5秒，所以一定会发生错误，也就会调用下边的fallbakcMethod方法
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "服务正常调用" + id;
    }

    /**
     * 这个就是当上边方法的“兜底”方法
     */
    public String TimeOutErrorHandler(Long id) {
        return "对不起，系统处理超时" + id;
    }
}
