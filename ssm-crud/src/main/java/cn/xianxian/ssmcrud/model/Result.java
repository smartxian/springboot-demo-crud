package cn.xianxian.ssmcrud.model;

import java.util.HashMap;
import java.util.Map;

public class Result {
    //状态码
    private int code;
    private String msg;
    private Map<String,Object> extend = new HashMap<String, Object>();

    public static Result success() {
        Result result = new Result();
        result.setCode(100);
        result.setMsg("处理成功");
        return  result;
    }

    public static Result fail() {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("处理失败");
        return  result;
    }

    public Result add(String key,Object value) {
        this.getExtend().put(key,value);
        return this;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}