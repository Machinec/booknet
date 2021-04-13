package com.booknet.service;

import com.booknet.utils.ControllerReturn;

/**
 * @Author zichang
 * @Date 2021/4/12 15:10
 * @Description
 */
public interface UserService {

    public ControllerReturn delAsk(int id);

    public ControllerReturn delBook(int id);

    public ControllerReturn askList(String openid);

    public ControllerReturn bookList(String openid);
}
