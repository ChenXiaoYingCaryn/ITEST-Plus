package com.itest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ChanV
 * @create 2021-08-02-18:06
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ItestConsumer8001 {
    public static void main(String[] args) {
        SpringApplication.run(ItestConsumer8001.class, args);
    }
}
