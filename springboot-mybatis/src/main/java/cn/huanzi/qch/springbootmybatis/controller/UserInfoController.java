package cn.huanzi.qch.springbootmybatis.controller;

import cn.huanzi.qch.springbootmybatis.domain.UserInfo;
import cn.huanzi.qch.springbootmybatis.enums.ResponseCodeEnum;
import cn.huanzi.qch.springbootmybatis.pojo.DroneInfo;
import cn.huanzi.qch.springbootmybatis.pojo.Result;
import cn.huanzi.qch.springbootmybatis.service.UserInfoService;
import com.github.pagehelper.PageInfo;
import lombok.val;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: springboot-mybatis
 * @description: 注册用户控制层
 * @author: lixing
 * @create: 2020-08-16 15:20
 **/
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    /**
     * 新增用户
     *
     * @param userInfo
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@Param(value = "userInfo") UserInfo userInfo) {
        return userInfoService.insert(userInfo);
    }

    //测试：http://localhost:8888/drone/update?id=44&username=张四疯
    @RequestMapping("/update")
    public Result update(UserInfo userInfo) {
        return userInfoService.update(userInfo);
    }

    //测试：http://localhost:8888/drone/select?id=44
    @RequestMapping("/select")
    public Result select(@Param("name") String name, @Param("cardId") String cardId,
                         @Param("cardType") Integer cardType) {
        return userInfoService.select(name, cardId, cardType);
    }

    @RequestMapping(value = "getUserById")
    public Result getUserById(Integer id) {
        UserInfo userById = userInfoService.getUserById(id);
        Result response = new Result();
        if (userById != null) {
            response.setMessage("查询成功");
            response.setStatus(200);
        } else {
            response.setMessage(ResponseCodeEnum.NODATA.getMsg());
            response.setStatus(ResponseCodeEnum.NODATA.getCode());
        }

        response.setResult(userById);

        return response;
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
                                      @Param("cardId") String cardId, @Param("cardType") Integer cardType) {
        Result response = new Result();
        PageInfo<UserInfo> pageInfo = userInfoService.selectAllPageHelper(page, size, name, cardId, cardType);
        Map<String, Object> data = new HashMap<>();
        data.put("result", pageInfo);
        response.setMessage("查询成功");
        response.setStatus(200);
        //response.setData(data);
        response.setResult(pageInfo);
        return response;

    }

    /**
     * 删除用户
     *
     * @param userInfo
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(@Param(value = "userInfo") UserInfo userInfo) {
        return userInfoService.delete(userInfo);
    }

}
