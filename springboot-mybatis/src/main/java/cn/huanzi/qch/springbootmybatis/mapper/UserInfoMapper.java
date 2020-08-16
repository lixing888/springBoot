package cn.huanzi.qch.springbootmybatis.mapper;

import cn.huanzi.qch.springbootmybatis.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: springboot-mybatis
 * @description: 注册用户dao层
 * @author: lixing
 * @create: 2020-08-16 15:09
 **/
@Mapper
@Component(value = "UserInfoMapper")
public interface UserInfoMapper {

    List<UserInfo> selectUserList();

    UserInfo getUserById(Integer id);

}
