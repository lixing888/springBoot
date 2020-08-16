package cn.huanzi.qch.springbootmybatis.domain;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;

import java.util.Date;

/**
 * @program: springboot-mybatis
 * @description: 注册用户信息
 * @author: lixing
 * @create: 2020-08-16 15:04
 **/
@Data
public class UserInfo {
    private Integer id;

    private String name;

    private String passWord;
    @Ignore
    private Date createTime;
    @Ignore
    private Date updateTime;

    private String creatorId;

}
