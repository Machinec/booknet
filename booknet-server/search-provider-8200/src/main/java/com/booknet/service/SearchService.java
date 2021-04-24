package com.booknet.service;

import com.booknet.utils.ControllerReturn;

/**
 * @Author zichang
 * @Date 2021/4/11 16:32
 * @Description
 */
public interface SearchService {

    public ControllerReturn test();


    public ControllerReturn getAskList(int page);


    public ControllerReturn getAskDetail(int id);


    public ControllerReturn getBooksList(int page);


    public ControllerReturn getBookDetail(int id);

    public ControllerReturn findBook(String key);

    public ControllerReturn findAsk(String key);
}
