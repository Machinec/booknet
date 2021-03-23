package com.booknet.service;

import com.booknet.dao.TestDao;
import com.booknet.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zichang
 * @Date 2021/3/21 16:53
 * @Description
 */
@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TestDao testDao;

    @Override
    public boolean addTest(Test test) {
        return testDao.addTest(test);
    }

    @Override
    public Test queryById(int id) {
        return testDao.queryById(id);
    }

    @Override
    public List<Test> queryAll() {
        return testDao.queryAll();
    }
}
