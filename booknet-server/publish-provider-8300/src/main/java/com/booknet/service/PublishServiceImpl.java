package com.booknet.service;

import com.booknet.dao.PublishDao;
import com.booknet.pojo.Ask;
import com.booknet.pojo.Book;
import com.booknet.utils.ControllerReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author zichang
 * @Date 2021/4/12 14:10
 * @Description
 */
@Service
public class PublishServiceImpl implements PublishService{

    @Autowired
    private PublishDao publishDao;

    @Override
    public ControllerReturn addAsk(Ask ask) {
        return new ControllerReturn().setCode(200).setMessage("OK").setData(publishDao.addAsk(ask));
    }

    @Override
    public ControllerReturn addBook(Book book) {
        return new ControllerReturn().setCode(200).setMessage("OK").setData(publishDao.addBook(book));
    }
}
