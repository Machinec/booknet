package com.booknet.service;

import com.booknet.pojo.Test;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Author zichang
 * @Date 2021/3/23 12:55
 * @Description feign value 服务名称， fallbackFactory 服务降级类
 */

@FeignClient(value = "TEST-PROVIDER", fallbackFactory = TestClientServiceFallbackFactory.class)
public interface TestClientService {

    @GetMapping("/test/get/{id}")
    public Test queryById(@PathVariable("id") int id);

    @GetMapping("/test/list")
    public List<Test> queryAll();

    @PostMapping("/test/add")
    public Boolean addTest(Test test);

    @GetMapping("/test/port")
    public String port();

}
