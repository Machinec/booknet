package com.booknet.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zichang
 * @Date 2021/3/21 16:04
 * @Description 实体类 orm 类表关系映射
 */
@Data
@NoArgsConstructor
@Accessors(chain = true) // 支持链式写法
public class Test implements Serializable {
    private int id; // 主键
    private String openid;
    private String book;
    private double price;
    private Date time;
    private String image;
    private String desc;
    private String detail;
    private String contact;
}
