package com.booknet.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author zichang
 * @Date 2021/3/21 22:44
 * @Description 配置类
 */

@Configuration
public class ConfigBean {


//    @Bean
//    @LoadBalanced   //使用Ribbon实现RestTemplate负载均衡访问
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }

}
