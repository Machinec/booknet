package com.booknet.dao;

import com.booknet.pojo.Ask;
import com.booknet.pojo.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zichang
 * @Date 2021/4/12 15:09
 * @Description
 */

@Mapper
@Repository
public interface UserDao {

    @Delete("DELETE FROM ask WHERE id = #{id}")
    public int delAsk(int id);

    @Delete("DELETE FROM books WHERE id = #{id}")
    public int delBook(int id);

    @Select("SELECT book, time, `desc`, id FROM  ask WHERE openid = #{openid}")
    public List<Ask> askList(String openid);

    @Select("SELECT id, book, `desc`, price, image FROM books WHERE openid = #{openid}")
    public List<Book> bookList(String openid);
}
