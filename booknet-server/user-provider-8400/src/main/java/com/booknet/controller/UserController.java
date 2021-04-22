package com.booknet.controller;

import com.booknet.service.UserService;
import com.booknet.utils.ControllerReturn;
import com.booknet.utils.JWTUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zichang
 * @Date 2021/4/10 22:26
 * @Description
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/user/test")
//    @HystrixCommand(fallbackMethod = "userException")
    public ControllerReturn test(){
        return new ControllerReturn().setCode(200).setMessage("user provider test");
    }

    @PostMapping("/user/ask/del")
    @HystrixCommand(fallbackMethod = "userTestException")
    public ControllerReturn delAsk(@RequestBody HashMap data){
        int id = (int) data.get("id");
        return userService.delAsk(id);
    }

    @PostMapping("/user/book/del")
    @HystrixCommand(fallbackMethod = "userTestException")
    public ControllerReturn delBook(@RequestBody HashMap data){
        int id = (int) data.get("id");
        return userService.delBook(id);
    }

    @PostMapping("/user/ask/list")
    @HystrixCommand(fallbackMethod = "userException")
    public ControllerReturn askList(@RequestBody HashMap data){
//        String user_id = JWTUtil.getUserId(request);
        String user_id = (String) data.get("user_id");
        Map<String, String> userMap = redisTemplate.opsForHash().entries(user_id);
        return userService.askList(userMap.get("openid"));
    }

    @PostMapping("/user/book/list")
    @HystrixCommand(fallbackMethod = "userException")
    public ControllerReturn bookList(@RequestBody HashMap data){
//        String user_id = JWTUtil.getUserId(request);
        String user_id = (String) data.get("user_id");
        Map<String, String> userMap = redisTemplate.opsForHash().entries(user_id);
        return userService.bookList(userMap.get("openid"));
    }

    public ControllerReturn userTestException(HashMap data){
        return new ControllerReturn().setCode(500).setMessage("访问服务熔断").setData(data);
    }

    public ControllerReturn userException(HashMap data){
        return new ControllerReturn().setCode(500).setMessage("访问服务熔断");
    }
}
