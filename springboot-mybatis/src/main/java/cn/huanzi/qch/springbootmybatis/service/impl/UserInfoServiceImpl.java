package cn.huanzi.qch.springbootmybatis.service.impl;

import cn.huanzi.qch.springbootmybatis.domain.UserInfo;
import cn.huanzi.qch.springbootmybatis.mapper.UserInfoMapper;
import cn.huanzi.qch.springbootmybatis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: springboot-mybatis
 * @description: 注册用户服务实现层
 * @author: lixing
 * @create: 2020-08-16 15:18
 **/
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> listUser() {

        return userInfoMapper.selectUserList();
    }

    @Override
    public UserInfo getUserById(Integer id) {
        return userInfoMapper.getUserById(id);
    }
}
