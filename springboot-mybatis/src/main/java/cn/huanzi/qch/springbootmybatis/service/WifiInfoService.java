package cn.huanzi.qch.springbootmybatis.service;

import cn.huanzi.qch.springbootmybatis.mapper.UserMapper;
import cn.huanzi.qch.springbootmybatis.mapper.WifiInfoMapper;
import cn.huanzi.qch.springbootmybatis.pojo.Result;
import cn.huanzi.qch.springbootmybatis.pojo.User;
import cn.huanzi.qch.springbootmybatis.pojo.WifiInfo;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

public interface WifiInfoService {


    /**
     * 增
     */
    Result insert(WifiInfo wifiInfo);

    /**
     * 删
     */
    Result delete(WifiInfo wifiInfo);

    /**
     * 改
     */
    Result update(WifiInfo wifiInfo);

    /**
     * 查
     */
    Result select(@Param("name") String name, @Param("status") Integer status);

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WifiInfo> selectAllPageHelper(@RequestParam("page") Integer page, @RequestParam("size") Integer size);
}
