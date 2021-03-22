package com.booknet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zichang
 * @Date 2021/3/21 17:00
 * @Description
 */

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class TestProvider_8002 {
    public static void main(String[] args) {
        SpringApplication.run(TestProvider_8002.class,args);
    }
}
