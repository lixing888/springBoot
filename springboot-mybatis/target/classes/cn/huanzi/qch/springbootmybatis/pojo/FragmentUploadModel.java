package cn.huanzi.qch.springbootmybatis.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: springboot-mybatis
 * @description: 分片上传文件模型
 * @author: lixing
 * @create: 2020-08-18 17:59
 **/
@Data
@ApiModel(description = "分片上传文件模型")
public class FragmentUploadModel {
    /**
     * 分片上传文件
     */
    @ApiModelProperty(value = "分片上传文件")
    private MultipartFile file;
    /**
     * 上传任务id
     */
    @ApiModelProperty(value = "上传任务id")
    private String taskId;
    /**
     * 分片数
     */
    @ApiModelProperty(value = "分片数")
    private Integer chunks;
    /**
     * 分片号
     */
    @ApiModelProperty(value = "分片号")
    private Integer chunk;

    @ApiModelProperty(value = "文件名")
    private String name;
    @ApiModelProperty(value = "文件大小")
    private Long size;

    private String part;


}
