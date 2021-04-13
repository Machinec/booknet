package com.booknet.service;

import com.booknet.dao.UserDao;
import com.booknet.utils.ControllerReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zichang
 * @Date 2021/4/12 15:10
 * @Description
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public ControllerReturn delAsk(int id) {
        return new ControllerReturn().setCode(200).setMessage("OK").setData(userDao.delAsk(id));
    }

    @Override
    public ControllerReturn delBook(int id) {
        return new ControllerReturn().setCode(200).setMessage("OK").setData(userDao.delBook(id));
    }

    @Override
    public ControllerReturn askList(String openid) {
        return new ControllerReturn().setCode(200).setMessage("OK").setData(userDao.askList(openid));
    }

    @Override
    public ControllerReturn bookList(String openid) {
        return new ControllerReturn().setCode(200).setMessage("OK").setData(userDao.bookList(openid));
    }
}
