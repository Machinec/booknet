package com.booknet.dao;

import com.booknet.pojo.Ask;
import com.booknet.pojo.Book;
import com.booknet.utils.ControllerReturn;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author zichang
 * @Date 2021/4/12 14:10
 * @Description
 */

@Mapper
@Repository
public interface PublishDao {

    @Insert("INSERT INTO ask(openid, book, time, `desc`, detail, contact) " +
            "VALUES(#{openid}, #{book}, CURDATE(), #{desc}, #{detail}, #{contact})")
    public int addAsk(Ask newAsk);

    @Insert("INSERT INTO books(openid, book, price, time, image, `desc`, detail, contact) " +
            "VALUES(#{openid}, #{book}, #{price}, CURDATE(), #{image}, #{desc}, #{detail}, #{contact})")
    public int addBook(Book newBook);
}
