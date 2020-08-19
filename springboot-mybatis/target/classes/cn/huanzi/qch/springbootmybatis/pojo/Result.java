package cn.huanzi.qch.springbootmybatis.pojo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Result {

    private String message;

    private Integer status;

    private Object result;

    public Result() {
    }

    public Result(String message, Integer status, Object result) {
        this.message = message;
        this.status = status;
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", result=" + result +
                '}';
    }

    public static Result build(Integer status,String message,Object data){
            return new Result(message,status,data);
    }
}
