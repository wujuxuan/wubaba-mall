package com.wubaba.mall.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
public class MallSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallSmsApplication.class, args);
    }

}
