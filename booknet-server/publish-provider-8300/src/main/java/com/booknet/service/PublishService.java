package com.booknet.service;

import com.booknet.pojo.Ask;
import com.booknet.pojo.Book;
import com.booknet.utils.ControllerReturn;

/**
 * @Author zichang
 * @Date 2021/4/12 14:10
 * @Description
 */
public interface PublishService {

    public ControllerReturn addAsk(Ask ask);

    public ControllerReturn addBook(Book book);
}
