package com.booknet.dao;

import com.booknet.pojo.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zichang
 * @Date 2021/3/21 16:38
 * @Description
 */

@Mapper
@Repository
public interface TestDao {

    public boolean addTest(Test test);

    public Test queryById(int id);

    public List<Test> queryAll();

}
