package com.paic.loancloud.sms.util;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paic.loancloud.sms.util.CommConstant;
import com.paic.loancloud.sms.util.ResponseCode;

import java.io.Serializable;

/**
 * rest请求返回值(JSON)
 */
public class ReturnJson implements Serializable {
    private final String resultCode;

    private final String resultMesg;

    private final Object data;


    public ReturnJson() {
        this.resultCode = CommConstant.SUCCESS_CODE;
        this.resultMesg = CommConstant.SUCCESS_MESG;
        this.data = null;
    }

    public ReturnJson(String resultCode, String resultMesg, Object data) {
        this.resultCode = resultCode;
        this.resultMesg = resultMesg;
        this.data = data;
    }

    public static ReturnJson json(ResponseCode responseCode, Object data) {
        return new ReturnJson(responseCode.getCode(), responseCode.getMesg(), data);
    }

    public static ReturnJson json(ResponseCode responseCode) {
        return new ReturnJson(responseCode.getCode(), responseCode.getMesg(), null);
    }

    /**
     * 返回成功的JSON串
     *
     * @param data 有参数
     * @return
     */
    public static ReturnJson success(Object data) {
        return ReturnJson.json(CommConstant.SUCCESS, data);
    }

    /**
     * 返回成功的JSON串
     */
    public static ReturnJson success() {
        return ReturnJson.success(null);
    }


    /**
     * 返回默认失败的JSON串
     *
     * @param data 返回值
     * @return json串
     */
    public static ReturnJson fail(Object data) {
        return ReturnJson.json(CommConstant.SYSTEM_FAIL, data);
    }


    /**
     * 返回失败的JSON串,数据体为null
     *
     * @return
     */
    public static ReturnJson fail() {
        return ReturnJson.fail(null);
    }

    /**
     * 根据结果码、结果信息、数据体生成实体
     *
     * @param resultCode
     * @param resultMesg
     * @param data
     * @return
     */
    public static ReturnJson json(String resultCode, String resultMesg, Object data) {
        return new ReturnJson(resultCode, resultMesg, data);
    }


    /**
     * 根据结果码判断请求是否处理成功
     *
     * @return
     */
    @JsonIgnore
    public boolean isSuccess() {
        return CommConstant.SUCCESS_CODE.equalsIgnoreCase(resultCode);
    }

    /**
     * 返回结果code
     *
     * @return
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * 返回结果具体信息
     *
     * @return
     */
    public String getResultMesg() {
        return resultMesg;
    }

    /**
     * 返回结果的具体数据
     *
     * @return
     */
    public Object getData() {
        return data;
    }

}
