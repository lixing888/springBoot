package cn.huanzi.qch.springbootmybatis.service;

import cn.huanzi.qch.springbootmybatis.mapper.WifiInfoMapper;
import cn.huanzi.qch.springbootmybatis.pojo.Result;
import cn.huanzi.qch.springbootmybatis.pojo.User;
import cn.huanzi.qch.springbootmybatis.pojo.WifiInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        List<WifiInfo> list = wifiInfoMapper.select(name,status);
        if (list != null) {
            return Result.build(200, "操作成功！", list);
        } else {
            return Result.build(400, "操作失败！", list);
        }
    }
}
