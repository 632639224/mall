package com.yj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication

public class MallLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallLoginApplication.class, args);
    }

}
