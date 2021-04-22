package com.booknet.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author zichang
 * @Date 2021/4/10 20:02
 * @Description
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Book {
    private int id;
    private String openid;
    private String book;
    private double price;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date time;
    private String image;
    private String desc;
    private String detail;
    private String contact;
    private String name;
    private String avatar;
}
