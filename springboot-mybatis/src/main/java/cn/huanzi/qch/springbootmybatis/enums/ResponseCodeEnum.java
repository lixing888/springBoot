package cn.huanzi.qch.springbootmybatis.enums;

import lombok.Getter;

/**
 * 返回值枚举类
 *
 * @author lixing
 */
@Getter
public enum ResponseCodeEnum {

    SUCCESS(200, "操作成功"),
    REPEAT(300, "数据已存在！请勿重复添加。"),
    ERROR(500, "操作失败");
    private int code;

    private String msg;

    ResponseCodeEnum(int code, String msg) {

        this.code = code;
        this.msg = msg;

    }

}
