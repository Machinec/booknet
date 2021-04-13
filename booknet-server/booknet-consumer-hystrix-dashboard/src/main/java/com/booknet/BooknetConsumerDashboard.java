package com.booknet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author zichang
 * @Date 2021/3/23 15:32
 * @Description hystrix dashboard 服务流量监控
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableHystrixDashboard
public class BooknetConsumerDashboard {
    public static void main(String[] args) {
        SpringApplication.run(BooknetConsumerDashboard.class,args);
    }
}
