package com.paic.loancloud.sms.util;

/**
 * Created by sunjian on 2017/4/2.
 */
public class CommonException extends Exception {
    private ResponseCode responseCode;

    public CommonException(Throwable throwable,ResponseCode responseCode){
        super(responseCode.getMesg(),throwable);
        this.responseCode = responseCode;
    }

    /**
     * error message,status code and info about the cause
     */
    public CommonException(ResponseCode responseCode){
        super(responseCode.getMesg());
        this.responseCode = responseCode;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }
}
