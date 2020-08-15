package cn.huanzi.qch.springbootmybatis.service.impl;

import cn.huanzi.qch.springbootmybatis.mapper.WifiInfoMapper;
import cn.huanzi.qch.springbootmybatis.pojo.Result;
import cn.huanzi.qch.springbootmybatis.pojo.User;
import cn.huanzi.qch.springbootmybatis.pojo.WifiInfo;
import cn.huanzi.qch.springbootmybatis.service.WifiInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class WifiInfoServiceImpl implements WifiInfoService {

    @Autowired
    private WifiInfoMapper wifiInfoMapper;

    @Override
    public Result insert(WifiInfo wifiInfo) {
        return null;
    }

    @Override
    public Result delete(WifiInfo wifiInfo) {
        return null;
    }

    @Override
    public Result update(WifiInfo wifiInfo) {
        return null;
    }

    @Override
    public Result select(@Param("name") String name, @Param("status") Integer status) {
        List<WifiInfo> list = wifiInfoMapper.select(name, status);
        if (list != null) {
            Map<String, Object> data = new HashMap<>();
            data.put("result", list);
            return Result.build(200, "操作成功！", data);
        } else {
            return Result.build(400, "操作失败！", list);
        }
    }

    @Override
    public PageInfo<WifiInfo> selectAllPageHelper(Integer page, Integer size, String name, Integer status) {
        // 开启分页插件,放在查询语句上面 帮助生成分页语句
        PageHelper.startPage(page, size);
        List<WifiInfo> wifiInfoList = wifiInfoMapper.select(name, status);
        // 封装分页之后的数据  返回给客户端展示  PageInfo做了一些封装 作为一个类
        //PageInfo<WifiInfo> pageAttachMents = new PageInfo<>(wifiInfoList);
        return new PageInfo<>(wifiInfoList);
    }
}
