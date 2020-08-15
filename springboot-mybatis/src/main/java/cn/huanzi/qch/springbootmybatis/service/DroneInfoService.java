package cn.huanzi.qch.springbootmybatis.service;

import cn.huanzi.qch.springbootmybatis.pojo.DroneInfo;
import cn.huanzi.qch.springbootmybatis.pojo.Result;
import cn.huanzi.qch.springbootmybatis.pojo.WifiInfo;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 无人机信息服务层
 */
public interface DroneInfoService {
    /**
     * 增
     */
    Result insert(DroneInfo droneInfo);

    /**
     * 删
     */
    Result delete(DroneInfo droneInfo);

    /**
     * 改
     */
    Result update(DroneInfo droneInfo);

    /**
     * 查
     */
    Result select(@Param("name") String name, @Param("state") String state);

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @return
     */
    PageInfo<DroneInfo> selectAllPageHelper(@RequestParam("page") Integer page,
                                            @RequestParam("size") Integer size,
                                            @RequestParam("name") String name,
                                            @Param("state") String state);

}
