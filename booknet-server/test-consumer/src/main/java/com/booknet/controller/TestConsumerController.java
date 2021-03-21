package com.booknet.controller;

import com.booknet.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author zichang
 * @Date 2021/3/21 22:42
 * @Description 作为消费者，使用RestTemplate调用provider提供的请求。
 */

@RestController
public class TestConsumerController {

    @Autowired
    private RestTemplate restTemplate; // restful服务模板，提供多种访问远程http服务的模板

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @RequestMapping("/consumer/test/get/{id}")
    public Test get(@PathVariable("id") int id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/test/get/"+id, Test.class);
    }

    @RequestMapping("/consumer/test/add/{name}")
    public boolean add(@PathVariable("name") String name){
        Test test = new Test(name);
        return restTemplate.postForObject(REST_URL_PREFIX+"/test/add", test, Boolean.class);
    }

    @RequestMapping("/consumer/test/list")
    public List<Test> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/test/list", List.class);
    }
}
