package com.booknet.service;

import com.alibaba.fastjson.JSON;
import com.booknet.pojo.User;
import com.booknet.utils.ControllerReturn;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Author zichang
 * @Date 2021/3/24 20:17
 * @Description
 */

@Component
public class LoginClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new LoginClientService() {
            @Override
            public Object login(HashMap data) {
                String code = (String) data.get("code");
                User user = JSON.parseObject(JSON.toJSONString(data.get("user")), User.class);
                return new ControllerReturn(500, "/user/login无法访问，请稍后再试").setData(user);
            }
        };
    }
}
