package com.booknet.controller;

import com.alibaba.fastjson.JSON;
import com.booknet.pojo.Ask;
import com.booknet.pojo.Book;
import com.booknet.service.PublishService;
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
 * @Date 2021/4/10 22:19
 * @Description
 */
@RestController
public class PublishController {

    @Autowired
    private PublishService publishService;

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/publish/test")
    @HystrixCommand(fallbackMethod = "publishTestException")
    public ControllerReturn test(){
        return new ControllerReturn().setCode(200).setMessage("publish provider test");
    }

    @PostMapping("/publish/ask/add")
    @HystrixCommand(fallbackMethod = "publishException")
    public ControllerReturn addAsk(@RequestBody HashMap data, HttpServletRequest request){
//        String user_id = JWTUtil.getUserId(request);
        String user_id = (String) data.get("user_id");
        Map<String, String> userMap = redisTemplate.opsForHash().entries(user_id);
        Ask ask = JSON.parseObject(JSON.toJSONString(data.get("ask")), Ask.class);
        ask.setOpenid(userMap.get("openid"));
        return publishService.addAsk(ask);
    }

    @PostMapping("/publish/book/add")
    @HystrixCommand(fallbackMethod = "publishException")
    public ControllerReturn addBook(@RequestBody HashMap data, HttpServletRequest request){
//        String user_id = JWTUtil.getUserId(request);
        String user_id = (String) data.get("user_id");
        System.out.println("user_id => " + user_id);
        Map<String, String> userMap = redisTemplate.opsForHash().entries(user_id);
        System.out.println("userMap => " + userMap.toString());
        Book book = JSON.parseObject(JSON.toJSONString(data.get("book")), Book.class);
        book.setOpenid(userMap.get("openid"));
        System.out.println("book => " + book.toString());
        return publishService.addBook(book);
    }

    public ControllerReturn publishTestException(){
        return new ControllerReturn().setCode(500).setMessage("访问服务熔断");
    }

    public ControllerReturn publishException(HashMap data, HttpServletRequest request){
        return new ControllerReturn().setCode(500)
                .setMessage(request.getRequestURL().toString() + "访问服务熔断")
                .setData(JSON.toJSONString(data));
    }
}
