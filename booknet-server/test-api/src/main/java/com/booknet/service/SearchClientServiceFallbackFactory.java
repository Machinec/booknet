package com.booknet.service;

import com.booknet.utils.ControllerReturn;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author zichang
 * @Date 2021/4/10 21:34
 * @Description
 */
@Component
public class SearchClientServiceFallbackFactory implements FallbackFactory {

    @Override
    public Object create(Throwable throwable) {
        return new SearchClientService() {
            @Override
            public ControllerReturn test() {
                return new ControllerReturn().setCode(500).setMessage("服务暂时无法访问，请稍后重试");
            }

            @Override
            public ControllerReturn getAskList(int page) {
                return new ControllerReturn().setCode(500).setMessage("服务暂时无法访问，请稍后重试");
            }

            @Override
            public ControllerReturn getAskDetail(int id) {
                return new ControllerReturn().setCode(500).setMessage("服务暂时无法访问，请稍后重试");
            }

            @Override
            public ControllerReturn getBooksList(int page) {
                return new ControllerReturn().setCode(500).setMessage("服务暂时无法访问，请稍后重试");
            }

            @Override
            public ControllerReturn getBookDetail(int id) {
                return new ControllerReturn().setCode(500).setMessage("服务暂时无法访问，请稍后重试");
            }
        };
    }
}
