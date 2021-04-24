package com.booknet.dao;

import com.booknet.pojo.Ask;
import com.booknet.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zichang
 * @Date 2021/4/11 16:40
 * @Description
 */
@Mapper
@Repository
public interface SearchDao {

    @Select("SELECT `name`, avatar, book, time, `desc`, id FROM `user`, ask WHERE ask.openid = `user`.openid")
    public List<Ask> getAskList();

    @Select("SELECT * FROM ask WHERE id = #{id}")
    public Ask getAskDetail(int id);

    @Select("SELECT id, book, `desc`, price, image FROM books")
    public List<Book> getBooksList();

    @Select("SELECT `name`, avatar, books.* FROM `user`, books WHERE books.id = #{id} AND books.openid = `user`.openid")
    public Book getBookDetail(int id);

    @Select("SELECT id, book, `desc`, price, image FROM books WHERE book LIKE '%${key}%'")
    public List<Book> findBook(@Param("key") String key);

    @Select("SELECT `name`, avatar, book, time, `desc`, id FROM `user`, ask WHERE ask.openid = `user`.openid AND ask.book LIKE '%${key}%'")
    public List<Ask> findAsk(@Param("key") String key);
}
