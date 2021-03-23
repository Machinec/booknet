package com.booknet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author zichang
 * @Date 2021/3/23 21:39
 * @Description
 */
@SpringBootApplication
@EnableConfigServer
public class Config_3344 {
    public static void main(String[] args) {
        SpringApplication.run(Config_3344.class, args);
    }
}
