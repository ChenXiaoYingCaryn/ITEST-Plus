package com.itest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ChanV
 * @create 2021-08-02-16:31
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ItestProvider9001 {
    public static void main(String[] args) {
        SpringApplication.run(ItestProvider9001.class);
    }
}
