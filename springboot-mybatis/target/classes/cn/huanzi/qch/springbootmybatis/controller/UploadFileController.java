package cn.huanzi.qch.springbootmybatis.controller;

import cn.huanzi.qch.springbootmybatis.pojo.FileForm;
import cn.huanzi.qch.springbootmybatis.pojo.FragmentUploadModel;
import cn.huanzi.qch.springbootmybatis.pojo.Result;
import cn.huanzi.qch.springbootmybatis.service.UploadFileService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

/**
 * Create by lixing
 * 2019/1/10 15:41
 * http://127.0.0.1:8888/file/open
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class UploadFileController {

    @Resource
    public UploadFileService uploadFileService;


    @GetMapping("/open")
    public ModelAndView open() {

        return new ModelAndView("upload");
    }

    @PostMapping("/isUpload")
    public Map<String, Object> isUpload(@Valid FileForm form) {

        return uploadFileService.findByFileMd5(form.getMd5());

    }

    @PostMapping("/upload")
    public Map<String, Object> upload(@Valid FileForm form,@RequestParam(value = "data", required = false) MultipartFile multipartFile) {
        Map<String, Object> map = null;

        try {
            map = uploadFileService.realUpload(form, multipartFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    //=============================================新版================================
}
