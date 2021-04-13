package com.booknet.service;

import com.booknet.utils.ControllerReturn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

/**
 * @Author zichang
 * @Date 2021/4/10 21:59
 * @Description
 */
@FeignClient(value = "PUBLISH-PROVIDER", fallbackFactory = PublishClientServiceFallbackFactory.class)
public interface PublishClientService {

    @GetMapping("/publish/test")
    public ControllerReturn test();

    @PostMapping("/publish/ask/add")
    public ControllerReturn addAsk(@RequestBody HashMap data);

    @PostMapping("/publish/book/add")
    public ControllerReturn addBook(@RequestBody HashMap data);
}
