package com.booknet.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author zichang
 * @Date 2021/3/25 17:49
 * @Description
 */

@Component
@ConfigurationProperties(prefix = "filter-ignore-url")
public class FilterIgnoreURL {

    public static List<String> urls;

    public List<String> getUrls(){
        return urls;
    }

    public void setUrls(List<String> urls){
        FilterIgnoreURL.urls = urls;
    }
}
