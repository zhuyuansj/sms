package com.paic.loancloud.sms.util;

import java.io.Serializable;

/**
 * Created by sunjian on 2017/4/2.
 * 接口调用失败的异常信息
 */
public class ArgumentInvlidResult implements Serializable{
    /**
     * 异常类
     */
    private String exceptionName;

    /**
     * 错误原因
     */
    private String errorMessage;

    /**
     * 异常字段
     */
    private String fieldCode;
    /**
     * 异常字段值
     */
    private Object rejectedValue;

    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }
}
