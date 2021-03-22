package com.booknet;

import com.booknet.myrule.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author zichang
 * @Date 2021/3/21 22:53
 * @Description
 */

@SpringBootApplication
@EnableEurekaClient
// 在微服务启动时加载自定义的策略，覆盖默认策略。name为需要负载均衡的服务名, configuration为自定义的负载均衡策略类名
@RibbonClient(name = "TEST-PROVIDER", configuration = MyRibbonRule.class)
public class TestConsumer {
    public static void main(String[] args) {
        SpringApplication.run(TestConsumer.class,args);
    }
}
