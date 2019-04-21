/* Copyright (C) 2019-2019 Hangzhou HSH Co. Ltd.
 * All right reserved.*/
package com.ali.superbaby.util;

import com.ali.common.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;

/**
 * @author simon
 * @date 2019-02-27 14:17
 * @desc 统一异常处理控制器
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandler {
    /**
     * 处理自定义异常
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(RunException.class)
    public Result handleRunException(RunException e) {
        Result result = new Result(e.getCode(), e.getMsg());
        return result;
    }

    /**
     * Hibernate validator 异常处理
     *
     * @param
     * @return
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    public Result handlerConstraintViolationException(ConstraintViolationException e) {
        Result result = new Result(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
        return result;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NoHandlerFoundException.class)
    public Result handlerNoFoundException(Exception e) {
        return Result.error(404, "路径不存在，请检查路径是否正确");
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        return Result.error(RunExceptionEnum.FILE_DUPLICATE.getCode(), "数据库中已存在该记录");
    }

  /*  @org.springframework.web.bind.annotation.ExceptionHandler(AuthorizationException.class)
    public Result handleAuthorizationException(AuthorizationException e) {
        return Result.error(RunExceptionEnum.NO_AUTH.getCode(), RunExceptionEnum.NO_AUTH.getMsg());
    }*/

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        return Result.error(RunExceptionEnum.SYS_BUSY.getCode(), RunExceptionEnum.SYS_BUSY.getMsg());
    }
}
