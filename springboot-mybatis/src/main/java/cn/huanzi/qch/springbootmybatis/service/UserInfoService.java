package cn.huanzi.qch.springbootmybatis.service;

import cn.huanzi.qch.springbootmybatis.domain.UserInfo;

import java.util.List;

/**
 * @program: springboot-mybatis
 * @description: 注册用户服务层
 * @author: lixing
 * @create: 2020-08-16 15:17
 **/
public interface UserInfoService {
    List<UserInfo> listUser();

    UserInfo getUserById(Integer id);
}
