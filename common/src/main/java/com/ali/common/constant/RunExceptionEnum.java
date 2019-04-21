/* Copyright (C) 2019-2019 Hangzhou HSH Co. Ltd.
 * All right reserved.*/
package com.ali.common.constant;

/**
 * @author simon
 * @date 2019-03-22 14:38
 * @desc 服务端 API 全局错误码
 */
public enum RunExceptionEnum {
    /*服务器暂不可用，建议稍候再重试1次，最多重试3次*/
    SYS_BUSY(-1, "服务器暂不可用，建议稍候再重试1次，最多重试3次"),
    /*请求的URI地址不存在*/
    URL_NOT_EXISTS(404, "请求的URI地址不存在"),
    /*缺少token参数*/
    TOKEN_MISSION(10001, "缺少token参数"),
    /*token 失效*/
    TOKEN_INVALID(10002, "token 失效或都过期"),
    NO_AUTH(10003, "没有权限，请联系管理员授权"),
    /*生成Token失败*/
    GENERATOR_TOKEN_FAIL(10003, "生成Token失败"),
    CHAR_INVALID(10004, "包含非法字符"),
    /*上传文件异常*/
    UPLOAD_FAIL(10005, "上传文件异常"),
    UUID_NULL(10006, "uuid不能为空"),
    /*文件不存在*/
    FILE_NOT_EXISTS(10007, "文件不存在"),
    FILE_DUPLICATE(10008,"文件已经存在"),

    REDIS_SERVER_ERROR(80001, "Redis服务异常"),
    IO_ERROR(80002, "IO Exception"),
    PROC_FAIL(80002, "parseObject fail"),
    CONVERT_BEAN_FAIL(80003, "实体转换失败"),
    VALIDATOR_VERIFY(99999, "输入校验....");

    private int code;
    private String msg;

    RunExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override
    public String toString() {
        return this.code + "-" + this.msg;
    }
}
