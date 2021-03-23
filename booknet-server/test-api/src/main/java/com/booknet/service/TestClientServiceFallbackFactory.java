package com.booknet.service;

import com.booknet.pojo.Test;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author zichang
 * @Date 2021/3/23 14:59
 * @Description Hystrix 服务降级
 */
@Component
public class TestClientServiceFallbackFactory implements FallbackFactory {

    @Override
    public TestClientService create(Throwable throwable) {
        return new TestClientService() {
            @Override
            public Test queryById(int id) {
                return new Test()
                        .setId(id)
                        .setName("没有对应信息，客户端提供降级信息，本服务已经关闭");
            }

            @Override
            public List<Test> queryAll() {
                return null;
            }

            @Override
            public Boolean addTest(Test test) {
                return null;
            }
        };
    }

}
