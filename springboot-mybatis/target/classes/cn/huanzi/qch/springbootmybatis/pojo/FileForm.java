package cn.huanzi.qch.springbootmybatis.pojo;

import lombok.Data;

/**
 * Create by tianci
 * 2019/1/10 16:33
 */
@Data
public class FileForm {

    private String md5;//分片的md5

    private String uuid;

    private String date;

    private String name;

    private String size;//总大小

    private String total;//总片数

    private String index;//当前是第几片

    private String action;//upload check

    private String partMd5;//整个文件的md5
}
