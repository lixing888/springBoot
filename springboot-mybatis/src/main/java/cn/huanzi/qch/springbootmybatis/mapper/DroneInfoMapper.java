package cn.huanzi.qch.springbootmybatis.mapper;

import cn.huanzi.qch.springbootmybatis.pojo.DroneInfo;
import cn.huanzi.qch.springbootmybatis.pojo.WifiInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: springboot-mybatis
 * @description: 无人机dao
 * @author: lixing
 * @create: 2020-08-15 14:22
 **/
@Mapper
@Component(value = "DroneInfoMapper")
public interface DroneInfoMapper {

    List<DroneInfo> select(@Param("name") String name, @Param("state") String state);

}
