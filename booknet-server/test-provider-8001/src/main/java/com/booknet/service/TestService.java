package com.booknet.service;

import com.booknet.pojo.Test;

import java.util.List;

/**
 * @Author zichang
 * @Date 2021/3/21 16:52
 * @Description
 */
public interface TestService {
    public boolean addTest(Test test);
    public Test queryById(int id);
    public List<Test> queryAll();
}
