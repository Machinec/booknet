package com.booknet.service;

import com.booknet.dao.SearchDao;
import com.booknet.pojo.Ask;
import com.booknet.pojo.Book;
import com.booknet.pojo.Constants;
import com.booknet.utils.ControllerReturn;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zichang
 * @Date 2021/4/11 16:33
 * @Description
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchDao dao;

    @Override
    public ControllerReturn test() {
        return null;
    }

    @Override
    public ControllerReturn getAskList(int page) {
        // 设置分页规则, PAGE_SIZE = 20, 页码起始为1
        PageHelper.startPage(page, Constants.PAGE_SIZE);
        // 根据time 降序排序
        PageHelper.orderBy("time desc");
        // 取数据，插件会自动按照规则分页显示数据
        PageInfo<Ask> pageInfo = new PageInfo<>(dao.getAskList());
        // 判断是否为最后一页
        if (pageInfo.getPages() < page) return new ControllerReturn().setCode(400).setMessage("已经到底啦");
        return new ControllerReturn().setCode(200).setMessage("OK").setData(pageInfo.getList());
    }

    @Override
    public ControllerReturn getAskDetail(int id) {
        Ask ask = dao.getAskDetail(id);
        return new ControllerReturn().setData(200).setMessage("OK").setData(ask);
    }

    @Override
    public ControllerReturn getBooksList(int page) {
        PageHelper.startPage(page, Constants.PAGE_SIZE);
        PageHelper.orderBy("time desc");
        PageInfo<Book> pageInfo = new PageInfo<>(dao.getBooksList());
        if (pageInfo.getPages() < page) return new ControllerReturn().setCode(400).setMessage("已经到底啦");
        return new ControllerReturn().setCode(200).setMessage("OK").setData(pageInfo.getList());
    }

    @Override
    public ControllerReturn getBookDetail(int id) {
        Book book = dao.getBookDetail(id);
        return new ControllerReturn().setCode(200).setMessage("OK").setData(book);
    }
}
