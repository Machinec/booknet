package com.booknet.controller;

import com.booknet.service.UserClientService;
import com.booknet.utils.ControllerReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @Author zichang
 * @Date 2021/4/10 22:13
 * @Description
 */
@RestController
public class UserConsumerController {

    @Autowired
    private UserClientService service;

    @GetMapping("/user/test")
    public ControllerReturn test(){
        return service.test();
    }

    @PostMapping("/user/ask/del")
    public ControllerReturn delAsk(@RequestBody HashMap data){
        return service.delAsk(data);
    }

    @PostMapping("/user/book/del")
    public ControllerReturn delBook(@RequestBody HashMap data){
        return service.delBook(data);
    }

    @PostMapping("/user/ask/list")
    public ControllerReturn askList(@RequestBody HashMap data){
        return service.askList(data);
    }

    @PostMapping("/user/book/list")
    public ControllerReturn bookList(@RequestBody HashMap data){
        return service.bookList(data);
    }
}
