package cn.huanzi.qch.springbootmybatis.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 无人机信息实体
 *
 * @author lixing
 */
@Data
public class DroneInfo {

    private String id;
    private String image;
    private String name;
    private String state;
    private String canAttack;
    private Integer canTakeover;
    private Integer whitelisted;
    private Date createdTime;
    private Date deletedTime;
    private Integer attacking;
    private String direction;

}
