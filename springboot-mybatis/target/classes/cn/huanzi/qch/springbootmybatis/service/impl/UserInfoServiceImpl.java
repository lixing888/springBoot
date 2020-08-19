package cn.huanzi.qch.springbootmybatis.service.impl;

import cn.huanzi.qch.springbootmybatis.domain.UserInfo;
import cn.huanzi.qch.springbootmybatis.enums.ResponseCodeEnum;
import cn.huanzi.qch.springbootmybatis.mapper.UserInfoMapper;
import cn.huanzi.qch.springbootmybatis.pojo.DroneInfo;
import cn.huanzi.qch.springbootmybatis.pojo.Result;
import cn.huanzi.qch.springbootmybatis.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    public List<UserInfo> listUser(Integer cardType, String cardId, String name) {

        return userInfoMapper.selectUserList(cardType, cardId, name);
    }

    @Override
    public UserInfo getUserById(Integer id) {
        return userInfoMapper.getUserById(id);
    }

    @Override
    public Result insert(UserInfo userInfo) {

        userInfo.setId(UUID.randomUUID().toString());
        userInfo.setCreateTime(new Date());
        //唯一性校验
        List<UserInfo> list = userInfoMapper.selectUserList(userInfo.getCardType(), userInfo.getCardId(), userInfo.getName());
        if (list.size() > 0) {
            return Result.build(ResponseCodeEnum.REPEAT.getCode(), ResponseCodeEnum.REPEAT.getMsg(), list.get(0));
        }
        try {
            int i = userInfoMapper.insert(userInfo);
            if (i > 0) {
                return Result.build(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMsg(), userInfo);
            } else {
                return Result.build(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getMsg(), null);
            }
        } catch (Exception e) {
            return Result.build(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getMsg(), e.toString());
        }
    }

    @Override
    public Result delete(UserInfo userInfo) {
        return null;
    }

    @Override
    public Result update(UserInfo userInfo) {
        try {
            int i = userInfoMapper.update(userInfo);
            if (i > 0) {
                return Result.build(ResponseCodeEnum.SUCCESS.getCode(), "操作成功！", null);
            } else {
                return Result.build(ResponseCodeEnum.ERROR.getCode(), "操作失败！", null);
            }
        } catch (Exception e) {
            return Result.build(ResponseCodeEnum.ERROR.getCode(), "操作失败！", e.toString());

        }
    }

    @Override
    public Result select(String name, String cardId, Integer cardType) {
        List<UserInfo> list = userInfoMapper.selectUserList(cardType, cardId, name);
        if (list != null) {
            Map<String, Object> data = new HashMap<>();
            data.put("result", list);
            return Result.build(200, "查询无人机列表操作成功！", data);
        } else {
            return Result.build(400, "查询无人机列表操作失败！", list);
        }
    }

    @Override
    public PageInfo<UserInfo> selectAllPageHelper(Integer page, Integer size, String name, String cardId, Integer cardType) {
        // 开启分页插件,放在查询语句上面 帮助生成分页语句
        PageHelper.startPage(page, size);
        List<UserInfo> droneInfoList = userInfoMapper.selectUserList(cardType, cardId, name);
        // 封装分页之后的数据  返回给客户端展示  PageInfo做了一些封装 作为一个类
        //PageInfo<WifiInfo> pageAttachMents = new PageInfo<>(wifiInfoList);
        return new PageInfo<>(droneInfoList);
    }
}
