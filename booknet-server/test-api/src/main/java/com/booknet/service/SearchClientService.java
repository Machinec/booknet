package com.booknet.service;

import com.booknet.utils.ControllerReturn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author zichang
 * @Date 2021/4/10 21:28
 * @Description
 */
@FeignClient(value = "SEARCH-PROVIDER", fallbackFactory = SearchClientServiceFallbackFactory.class)
public interface SearchClientService {

    @GetMapping("/search/test")
    public ControllerReturn test();

    @GetMapping("/search/asks/get/{page}")
    public ControllerReturn getAskList(@PathVariable("page") int page);

    @GetMapping("/search/ask/get/{id}")
    public ControllerReturn getAskDetail(@PathVariable("id") int id);

    @GetMapping("/search/books/get/{page}")
    public ControllerReturn getBooksList(@PathVariable("page") int page);

    @GetMapping("/search/book/get/{id}")
    public ControllerReturn getBookDetail(@PathVariable("id") int id);
}
