package com.booknet.controller;

import com.booknet.pojo.Test;
import com.booknet.service.TestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author zichang
 * @Date 2021/3/21 22:42
 * @Description 作为消费者，使用RestTemplate调用provider提供的请求。
 */

@RestController
public class TestConsumerController {
//
//    @Autowired
//    private RestTemplate restTemplate; // restful服务模板，提供多种访问远程http服务的模板

    //Ribbon 地址前缀应为服务名变量，通过注册中心的服务名来选中合适的主机访问某个服务，实现负载均衡
    // Ribbon 与 Eureka 整合后RestTemplate可以使用注册中心微服务名称请求服务，不在关心ip地址和端口号
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
//    private static final String REST_URL_PREFIX = "http://TEST-PROVIDER";

    @Autowired
    private TestClientService service;

    @RequestMapping("/test/get/{id}")
    public Test get(@PathVariable("id") int id){
//        return restTemplate.getForObject(REST_URL_PREFIX+"/test/get/"+id, Test.class);
        return this.service.queryById(id);
    }

    @RequestMapping("/test/add/{name}")
    public boolean add(@PathVariable("name") String name){
        Test test = new Test().setDesc(name);
//        return restTemplate.postForObject(REST_URL_PREFIX+"/test/add", test, Boolean.class);
        return this.service.addTest(test);
    }

    @RequestMapping("/test/list")
    public List<Test> list(){
//        return restTemplate.getForObject(REST_URL_PREFIX+"/test/list", List.class);
        return this.service.queryAll();
    }

    @RequestMapping("/test/port")
    public String port(){
        return this.service.port();
    }
}
