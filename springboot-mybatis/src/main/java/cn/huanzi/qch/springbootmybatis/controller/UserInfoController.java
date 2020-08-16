package cn.huanzi.qch.springbootmybatis.controller;

import cn.huanzi.qch.springbootmybatis.service.UserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springboot-mybatis
 * @description: 注册用户控制层
 * @author: lixing
 * @create: 2020-08-16 15:20
 **/
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @RequestMapping(value = "listUser")
    public Object listUser() {
        return userInfoService.listUser();
    }

    @RequestMapping(value = "getUserById")
    public Object getUserById(Integer id) {
        return userInfoService.getUserById(id);
    }
}
