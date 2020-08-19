package cn.huanzi.qch.springbootmybatis.service;

import cn.huanzi.qch.springbootmybatis.pojo.Result;

/**
 * @program: springboot-mybatis
 * @description: 对接第三方接口
 * @author: lixing
 * @create: 2020-08-18 09:54
 **/
public interface BMLModelService {

    public Result getBML(String name);

}
