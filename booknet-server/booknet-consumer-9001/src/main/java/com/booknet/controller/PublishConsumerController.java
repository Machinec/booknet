package com.booknet.controller;

import com.booknet.service.PublishClientService;
import com.booknet.utils.ControllerReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author zichang
 * @Date 2021/4/10 22:11
 * @Description
 */

@RestController
public class PublishConsumerController {

    @Autowired
    private PublishClientService service;

    @GetMapping("/publish/test")
    public ControllerReturn test(){
        return service.test();
    }

    @PostMapping("/publish/ask/add")
    public ControllerReturn addAsk(@RequestBody HashMap data){
        return service.addAsk(data);
    }

    @PostMapping("/publish/book/add")
    public ControllerReturn addBook(@RequestBody HashMap data){
        return service.addBook(data);
    }
}
