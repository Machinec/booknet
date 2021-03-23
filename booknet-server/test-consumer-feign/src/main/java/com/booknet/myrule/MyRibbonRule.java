package com.booknet.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zichang
 * @Date 2021/3/23 0:21
 * @Description
 */

@Configuration
public class MyRibbonRule {
    // IRule配置Ribbon负载均衡策略，默认轮询
    // AvailabilityFilteringRule ：先过滤掉跳闸、访问故障的服务，对剩下的进行轮询
    // RoundRobinRule: 轮询
    // RetryRule: 先轮询获取服务，如果获取失败，则在指定时间内重试获取
    // RandomRule: 随机
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
