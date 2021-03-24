package com.booknet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author zichang
 * @Date 2021/3/21 22:53
 * @Description
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.booknet"})
//@ComponentScan("com.booknet")
// 在微服务启动时加载自定义的策略，覆盖默认策略。name为需要负载均衡的服务名, configuration为自定义的负载均衡策略类名
//@RibbonClient(name = "TEST-PROVIDER", configuration = MyRibbonRule.class)
public class BooknetConsumer_9001 {
    public static void main(String[] args) {
        SpringApplication.run(BooknetConsumer_9001.class,args);
    }
}
