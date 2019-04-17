/* Copyright (C) 2019-2019 Hangzhou HSH Co. Ltd.
 * All right reserved.*/
package com.ali.superz.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.StringUtils;

/**
 * 运行时异常
 *
 * @author simon
 * @date 2019-02-27 14:14
 * @desc RunException
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RunException extends RuntimeException {
    /**
     * 消息
     */
    private String msg;
    /**
     * 编码
     */
    private int code;

    public RunException(RunExceptionEnum ee, String msg) {
        this.code = ee.getCode();
        this.msg = StringUtils.isEmpty(msg) ? ee.getMsg() : msg;
    }

    public RunException(RunExceptionEnum ee, String msg, Throwable e) {
        super(ee.getMsg(), e);
        this.code = ee.getCode();
        this.msg = StringUtils.isEmpty(msg) ? ee.getMsg() : msg;
    }

    public RunException(RunExceptionEnum ee) {
        super(ee.getMsg());
        this.code = ee.getCode();
        this.msg = ee.getMsg();
    }

    public RunException(int code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public RunException(RunExceptionEnum ee, Throwable e) {
        super(ee.getMsg(), e);
        this.msg = ee.getMsg();
        this.code = ee.getCode();
    }
}
