package com.example.eurekaclusterclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClusterClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClusterClientApplication.class, args);
    }

}
