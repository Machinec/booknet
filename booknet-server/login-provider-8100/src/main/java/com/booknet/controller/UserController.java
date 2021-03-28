package com.booknet.controller;

import com.alibaba.fastjson.JSON;
import com.booknet.pojo.User;
import com.booknet.service.UserService;
import com.booknet.utils.ControllerReturn;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author zichang
 * @Date 2021/3/24 21:00
 * @Description
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    @HystrixCommand(fallbackMethod = "loginException")
    public Object login(@RequestBody HashMap data){
        String code = (String) data.get("code");
        User user = JSON.parseObject(JSON.toJSONString(data.get("user")), User.class);
        String token = userService.login(code,user);
        if (token == null){
            return new ControllerReturn(400, "登录失败");
        }
        System.out.println("UserController token: " + token);
        return new ControllerReturn().setCode(200).setMessage("登录成功").setData(token);
    }

    public Object loginException(HashMap data){
        return new ControllerReturn(500, "/login => 服务器无法访问");
    }
}
