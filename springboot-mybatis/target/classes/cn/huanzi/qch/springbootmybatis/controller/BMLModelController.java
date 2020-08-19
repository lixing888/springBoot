package cn.huanzi.qch.springbootmybatis.controller;

import cn.huanzi.qch.springbootmybatis.pojo.Result;
import cn.huanzi.qch.springbootmybatis.service.BMLModelService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springboot-mybatis
 * @description: 对接第三方接口
 * @author: lixing
 * @create: 2020-08-18 11:35
 **/
@RestController
@RequestMapping("/bml")
public class BMLModelController {

    @Resource
    private BMLModelService service;

    @PostMapping("/getPageHelper")
    public Result getPageHelper(@Param("name") String name) {

        return service.getBML(name);

    }
}
