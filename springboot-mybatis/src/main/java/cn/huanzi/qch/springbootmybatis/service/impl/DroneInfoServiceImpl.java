package cn.huanzi.qch.springbootmybatis.service.impl;

import cn.huanzi.qch.springbootmybatis.mapper.DroneInfoMapper;
import cn.huanzi.qch.springbootmybatis.mapper.WifiInfoMapper;
import cn.huanzi.qch.springbootmybatis.pojo.DroneInfo;
import cn.huanzi.qch.springbootmybatis.pojo.Result;
import cn.huanzi.qch.springbootmybatis.pojo.WifiInfo;
import cn.huanzi.qch.springbootmybatis.service.DroneInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

/**
 * @program: springboot-mybatis
 * @description: 无人机服务实现层
 * @author: lixing
 * @create: 2020-08-15 14:20
 **/
@Service
@Transactional
public class DroneInfoServiceImpl implements DroneInfoService {

    @Autowired
    private DroneInfoMapper droneInfoMapper;

    @Override
    public Result insert(DroneInfo droneInfo) {
        droneInfo.setId(UUID.randomUUID().toString());
        droneInfo.setCreatedTime(new Date());
        droneInfo.setDeletedTime(null);
        int i = droneInfoMapper.insert(droneInfo);
        if (i > 0) {
            return Result.build(200, "操作成功！", droneInfo);
        } else {
            return Result.build(400, "操作失败！", null);
        }
    }

    @Override
    public Result delete(DroneInfo droneInfo) {
        return null;
    }

    @Override
    public Result update(DroneInfo droneInfo) {
        return null;
    }

    @Override
    public Result select(String name, String state) {
        List<DroneInfo> list = droneInfoMapper.select(name, state);
        if (list != null) {
            Map<String, Object> data = new HashMap<>();
            data.put("result", list);
            return Result.build(200, "查询无人机列表操作成功！", data);
        } else {
            return Result.build(400, "查询无人机列表操作失败！", list);
        }
    }

    @Override
    public PageInfo<DroneInfo> selectAllPageHelper(Integer page, Integer size, String name, String state) {
        // 开启分页插件,放在查询语句上面 帮助生成分页语句
        PageHelper.startPage(page, size);
        List<DroneInfo> droneInfoList = droneInfoMapper.select(name, state);
        // 封装分页之后的数据  返回给客户端展示  PageInfo做了一些封装 作为一个类
        //PageInfo<WifiInfo> pageAttachMents = new PageInfo<>(wifiInfoList);
        return new PageInfo<>(droneInfoList);
    }
}
