package com.booknet.service;

import com.booknet.pojo.User;
import com.booknet.utils.ControllerReturn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Author zichang
 * @Date 2021/3/24 20:15
 * @Description
 */
@FeignClient(value = "LOGIN-PROVIDER", fallbackFactory = LoginClientServiceFallbackFactory.class)
public interface LoginClientService {

    @PostMapping("/user/login")
    public Object login(@RequestBody HashMap data);

}
