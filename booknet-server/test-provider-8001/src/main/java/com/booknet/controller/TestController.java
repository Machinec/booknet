package com.booknet.controller;

import com.booknet.pojo.Test;
import com.booknet.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
