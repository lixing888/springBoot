package cn.huanzi.qch.springbootmybatis.controller;

import cn.huanzi.qch.springbootmybatis.pojo.Result;
import cn.huanzi.qch.springbootmybatis.pojo.User;
import cn.huanzi.qch.springbootmybatis.pojo.WifiInfo;
import cn.huanzi.qch.springbootmybatis.service.WifiInfoService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wifi")
public class WifiInfoController {

    @Autowired
    private WifiInfoService wifiInfoService;

    //测试：http://localhost:10090/wifi/insert?username=张三疯&password=111&created=2019-11-11 11:11:11
    @RequestMapping("/insert")
    public Result insert(WifiInfo wifiInfo) {
        return wifiInfoService.insert(wifiInfo);
    }

    //测试：http://localhost:8888/wifi/delete?id=44
    @RequestMapping("/delete")
    public Result delete(WifiInfo wifiInfo) {
        return wifiInfoService.delete(wifiInfo);
    }

    //测试：http://localhost:8888/wifi/update?id=44&username=张四疯
    @RequestMapping("/update")
    public Result update(WifiInfo wifiInfo) {
        return wifiInfoService.update(wifiInfo);
    }

    //测试：http://localhost:8888/wifi/select?id=44
    @RequestMapping("/select")
    public Result select(@Param("name") String name, @Param("status") Integer status) {
        return wifiInfoService.select(name, status);
    }

    /**
     * 分页查询所有信息
     *
     * @return
     */
    @RequestMapping(value = "/selectAllPageHelper", method = RequestMethod.GET)
    public Result selectAllPageHelper(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Result response = new Result();
        PageInfo<WifiInfo> pageInfo = wifiInfoService.selectAllPageHelper(page, size);
        Map<String, Object> data = new HashMap<>();
        data.put("result", pageInfo);
        response.setMessage("查询成功");
        response.setStatus(200);
        response.setData(data);
        return response;

    }
}
