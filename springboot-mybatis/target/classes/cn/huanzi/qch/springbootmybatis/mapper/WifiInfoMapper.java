package cn.huanzi.qch.springbootmybatis.mapper;

import cn.huanzi.qch.springbootmybatis.pojo.WifiInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "WifiInfoMapper")
public interface WifiInfoMapper {

    List<WifiInfo> select(@Param("name") String name, @Param("status") Integer status);

}
