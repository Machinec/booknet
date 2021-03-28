package com.booknet;

import com.booknet.config.FilterIgnoreURL;
import com.booknet.filter.BooknetFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @Author zichang
 * @Date 2021/3/23 16:30
 * @Description
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigurationProperties({FilterIgnoreURL.class})
@EnableZuulProxy
public class ZuulApplication_9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication_9527.class, args);
    }

    @Bean
    public BooknetFilter booknetFilter(){
        return new BooknetFilter();
    }
}
