package com.booknet.controller;

import com.alibaba.fastjson.JSON;
import com.booknet.pojo.User;
import com.booknet.service.LoginClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author zichang
 * @Date 2021/3/24 21:08
 * @Description
 */

@RestController
public class LoginConsumerController {

    @Autowired
    private LoginClientService service;

    @PostMapping("/login")
    public Object login(@RequestBody HashMap data){
//        System.out.println("LoginConsumerController => /login hello");
//        String code = (String) data.get("code");
//        User user = JSON.parseObject(JSON.toJSONString(data.get("user")), User.class);
        return service.login(data);
    }
}
