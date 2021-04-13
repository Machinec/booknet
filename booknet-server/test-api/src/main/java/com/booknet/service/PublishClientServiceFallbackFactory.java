package com.booknet.service;

import com.booknet.utils.ControllerReturn;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @Author zichang
 * @Date 2021/4/10 22:03
 * @Description
 */
@Component
public class PublishClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new PublishClientService() {
            @Override
            public ControllerReturn test() {
                return new ControllerReturn().setCode(500).setMessage("服务暂时无法访问，请稍后重试");
            }

            @Override
            public ControllerReturn addAsk(HashMap data) {
                return new ControllerReturn().setCode(500).setMessage("服务暂时无法访问，请稍后重试");
            }

            @Override
            public ControllerReturn addBook(HashMap data) {
                return new ControllerReturn().setCode(500).setMessage("服务暂时无法访问，请稍后重试");
            }
        };
    }
}
