package com.booknet.controller;

import com.booknet.service.SearchService;
import com.booknet.utils.ControllerReturn;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zichang
 * @Date 2021/4/10 21:45
 * @Description
 */
@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search/test")
    @HystrixCommand(fallbackMethod = "searchTestException")
    public ControllerReturn test(){
        return new ControllerReturn().setCode(200).setMessage("search provider test");
    }

    @GetMapping("/search/asks/get/{page}")
    @HystrixCommand(fallbackMethod = "searchException")
    public ControllerReturn getAskList(@PathVariable("page") int page){
        return searchService.getAskList(page);
    }

    @GetMapping("/search/ask/get/{id}")
    @HystrixCommand(fallbackMethod = "searchException")
    public ControllerReturn getAskDetail(@PathVariable("id") int id){
        return searchService.getAskDetail(id);
    }

    @GetMapping("/search/books/get/{page}")
    @HystrixCommand(fallbackMethod = "searchException")
    public ControllerReturn getBooksList(@PathVariable("page") int page){
        return searchService.getBooksList(page);
    }

    @GetMapping("/search/book/get/{id}")
    @HystrixCommand(fallbackMethod = "searchException")
    public ControllerReturn getBookDetail(@PathVariable("id") int id){
        return searchService.getBookDetail(id);
    }

    @GetMapping("/search/find/book/{key}")
    @HystrixCommand(fallbackMethod = "findException")
    public ControllerReturn findBook(@PathVariable("key") String key){
//        System.out.println("key = " + key);
        return searchService.findBook(key);
    }

    @GetMapping("/search/find/ask/{key}")
    @HystrixCommand(fallbackMethod = "findException")
    public ControllerReturn findAsk(@PathVariable("key") String key){
//        System.out.println("key = " + key);
        return searchService.findAsk(key);
    }

    public ControllerReturn searchException(int param){
        return new ControllerReturn().setCode(500).setMessage("访问服务熔断").setData(param);
    }

    public ControllerReturn searchTestException(){
        return new ControllerReturn().setCode(500).setMessage("访问服务熔断");
    }

    public ControllerReturn findException(String param){
        return new ControllerReturn().setCode(500).setMessage("访问服务熔断").setData(param);
    }

}
