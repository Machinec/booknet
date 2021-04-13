package com.booknet.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author zichang
 * @Date 2021/4/10 19:59
 * @Description
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Ask {
    private int id;
    private String openid;
    private String book;
    private Date time;
    private String desc;
    private String detail;
    private String contact;
    private String name;
    private String avatar;
}
