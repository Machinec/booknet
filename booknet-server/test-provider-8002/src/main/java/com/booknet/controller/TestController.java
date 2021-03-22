package com.booknet.controller;

import com.booknet.pojo.Test;
import com.booknet.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author zichang
 * @Date 2021/3/21 16:56
 * @Description 提供Restful服务
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    // 获取微服务配置信息
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/test/add")
    public boolean addTest(Test test){
        return testService.addTest(test);
    }

    @GetMapping("/test/get/{id}")
    public Test get(@PathVariable("id") int id){
        return testService.queryById(id);
    }

    @GetMapping("/test/list")
    public List<Test> queryAll(){
        return testService.queryAll();
    }

    // 注册进来的微服务，获取一些消息
    @GetMapping("/test/discovery")
    public Object discovery(){
        // 获取微服务列表清单
        List<String> services = client.getServices();
        // 得到一个具体的微服务信息，通过具体的服务id（eureka application name)
        List<ServiceInstance> instances = client.getInstances("TEST-PROVIDER");
        for (ServiceInstance instance : instances) {
            
        }
        return this.client;
    }
}
