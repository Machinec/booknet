package com.booknet.controller;

import com.booknet.service.SearchClientService;
import com.booknet.utils.ControllerReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zichang
 * @Date 2021/4/10 21:40
 * @Description
 */

@RestController
public class SearchConsumerController {

    @Autowired
    private SearchClientService service;

    @GetMapping("/search/test")
    public ControllerReturn test(){
        return service.test();
    }

    @GetMapping("/search/asks/get/{page}")
    public ControllerReturn getAskList(@PathVariable("page") int page){
        return service.getAskList(page);
    }

    @GetMapping("/search/ask/get/{id}")
    public ControllerReturn getAskDetail(@PathVariable("id") int id){
        return service.getAskDetail(id);
    }

    @GetMapping("/search/books/get/{page}")
    public ControllerReturn getBooksList(@PathVariable("page") int page){
        return service.getBooksList(page);
    }

    @GetMapping("/search/book/get/{id}")
    public ControllerReturn getBookDetail(@PathVariable("id") int id){
        return service.getBookDetail(id);
    }
}
