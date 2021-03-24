package com.booknet.service;

import com.booknet.pojo.User;

/**
 * @Author zichang
 * @Date 2021/3/24 20:55
 * @Description
 */
public interface UserService {

    public int insertUser(User user);

    public String login(String code, User user);
}
