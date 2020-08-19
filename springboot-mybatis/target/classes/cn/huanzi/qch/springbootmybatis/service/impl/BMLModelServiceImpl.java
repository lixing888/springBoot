package cn.huanzi.qch.springbootmybatis.service.impl;

import cn.huanzi.qch.springbootmybatis.pojo.Result;
import cn.huanzi.qch.springbootmybatis.service.BMLModelService;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import org.apache.http.client.methods.HttpPost;
import org.jsoup.Connection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: springboot-mybatis
 * @description: 调用第三方接口实现类
 * @author: lixing
 * @create: 2020-08-18 10:52
 **/
@Service
@Transactional
public class BMLModelServiceImpl implements BMLModelService {

    private String BMLUrl = "http://192.178.1.88:3200";

    @Override
    public Result getBML(String name) {
        HttpPost post = new HttpPost(BMLUrl + "");
        JSONObject param = new JSONObject();
        param.set("name", name);

        JSONObject json = new JSONObject();
        json.put("page", 1);
        json.put("size", 10);

        String result = HttpRequest.post("http://127.0.0.1:8888/userInfo/selectAllPageHelper")
//                .header("Content-Type", "application/json")
//                .header("X-Bmob-Application-Id", "2f0419a31f9casdfdsf431f6cd297fdd3e28fds4af")
//                .header("X-Bmob-REST-API-Key", "1e03efdas82178723afdsafsda4be0f305def6708cc6")
                .body(String.valueOf(json))
                .execute().body();


        System.out.println(result);

        return null;
    }
}
