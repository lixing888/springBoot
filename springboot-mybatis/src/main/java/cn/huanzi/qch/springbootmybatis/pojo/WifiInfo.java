package cn.huanzi.qch.springbootmybatis.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class WifiInfo {

    private Integer id;

    private String name;

    private Integer status;

    private String mac;

    private String reliability​;

    private String ssid;

    private Date createTime;

    private String creatorId;


}
