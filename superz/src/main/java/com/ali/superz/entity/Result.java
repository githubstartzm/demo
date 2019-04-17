package com.ali.superz.entity;


import lombok.Data;
import org.apache.http.HttpStatus;

import java.io.Serializable;

/**
 * 返回数据
 *
 * @author simon
 * @date 2016年10月27日 下午9:59:27
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;
    private T data;


    public Result() {
        this.code = 0;
        this.msg = "success";
    }

    public Result(int code, String msg) {
        this(code, msg, null);
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static Result error(int code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result ok(String msg) {
        Result result = new Result();
        result.setMsg(msg);
        return result;
    }


    public static Result ok() {
        return new Result();
    }

    public Result data(T value) {
        Result ok = Result.ok();
        ok.setData(value);
        return ok;
    }





}
