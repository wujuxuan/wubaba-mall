package com.wubaba.mall.ums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.wubaba.mall.ums.openFeign")
@SpringBootApplication
public class MallUmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallUmsApplication.class, args);
    }

}
