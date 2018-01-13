package com.paic.loancloud.sms.util;

import java.io.Serializable;

/**
 * Created by sunjian on 2017/3/29.
 */
public class ResponseCode implements Serializable {
    private String code;
    private String mesg;
    public ResponseCode(String code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }
}
