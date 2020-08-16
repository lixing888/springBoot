package cn.huanzi.qch.springbootmybatis.controller;

import cn.huanzi.qch.springbootmybatis.pojo.DroneInfo;
import cn.huanzi.qch.springbootmybatis.pojo.Result;
import cn.huanzi.qch.springbootmybatis.pojo.WifiInfo;
import cn.huanzi.qch.springbootmybatis.service.DroneInfoService;
import cn.huanzi.qch.springbootmybatis.service.WifiInfoService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: springboot-mybatis
 * @description: 无人机信息控制层
 * @author: lixing
 * @create: 2020-08-15 14:26
 **/

@RestController
@RequestMapping("/drone")
public class DroneInfoController {

    @Autowired
    private DroneInfoService droneInfoService;

    //测试：http://localhost:10090/drone/insert?username=张三疯&password=111&created=2019-11-11 11:11:11
    @PostMapping("/insert")
    public Result insert(@Param(value = "droneInfo") DroneInfo droneInfo) {
        return droneInfoService.insert(droneInfo);
    }

    //测试：http://localhost:8888/drone/delete?id=44
    @RequestMapping("/delete")
    public Result delete(DroneInfo droneInfo) {
        return droneInfoService.delete(droneInfo);
    }

    //测试：http://localhost:8888/drone/update?id=44&username=张四疯
    @RequestMapping("/update")
    public Result update(DroneInfo droneInfo) {
        return droneInfoService.update(droneInfo);
    }

    //测试：http://localhost:8888/drone/select?id=44
    @RequestMapping("/select")
    public Result select(@Param("name") String name, @Param("status") String state) {
        return droneInfoService.select(name, state);
    }

    /**
     * 分页查询所有信息
     *
     * @return
     */
    @RequestMapping(value = "/selectAllPageHelper", method = RequestMethod.GET)
    public Result selectAllPageHelper(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                      @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                                      @RequestParam(value = "name", required = false, defaultValue = "") String name,
                                      @Param("state") String state) {
        Result response = new Result();
        PageInfo<DroneInfo> pageInfo = droneInfoService.selectAllPageHelper(page, size, name, state);
        Map<String, Object> data = new HashMap<>();
        data.put("result", pageInfo);
        response.setMessage("查询成功");
        response.setStatus(200);
        //response.setData(data);
        response.setResult(pageInfo);
        return response;

    }


}
