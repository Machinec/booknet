package com.booknet.service;

import com.booknet.utils.ControllerReturn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

/**
 * @Author zichang
 * @Date 2021/4/10 22:06
 * @Description
 */
@FeignClient(value = "USER-PROVIDER", fallbackFactory = UserClientServiceFallbackFactory.class)
public interface UserClientService {

    @GetMapping("/user/test")
    public ControllerReturn test();

    @PostMapping("/user/ask/del")
    public ControllerReturn delAsk(@RequestBody HashMap data);

    @PostMapping("/user/book/del")
    public ControllerReturn delBook(@RequestBody HashMap data);

    @PostMapping("/user/ask/list")
    public ControllerReturn askList(@RequestBody HashMap data);

    @PostMapping("/user/book/list")
    public ControllerReturn bookList(@RequestBody HashMap data);
}
