package cn.huanzi.qch.springbootmybatis.service;

import cn.huanzi.qch.springbootmybatis.domain.UserInfo;
import cn.huanzi.qch.springbootmybatis.pojo.DroneInfo;
import cn.huanzi.qch.springbootmybatis.pojo.Result;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @program: springboot-mybatis
 * @description: 注册用户服务层
 * @author: lixing
 * @create: 2020-08-16 15:17
 **/
public interface UserInfoService {

    List<UserInfo> listUser(Integer cardType, String cardId, String name);

    UserInfo getUserById(Integer id);

    Result insert(UserInfo userInfo);

    Result delete(UserInfo userInfo);

    Result update(UserInfo userInfo);

    Result select(String name, String cardId, Integer cardType);

    PageInfo<UserInfo> selectAllPageHelper(Integer page, Integer size, String name, String cardId, Integer cardType);
}
