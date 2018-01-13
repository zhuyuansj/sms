package com.paic.loancloud.sms.util;

import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.MDC;

import java.util.Map;

/**
 * Created by sunjian on 2017/4/2.
 */
public class MDCUtil {
    /**
     * 用户名
     */
    public static final String MDC_USERNAME = "username";

    /**
     * 请求事物ID
     */
    public static final String MDC_TRANSACTION_ID = "transactionId";

    /**
     * 请求ID的前缀长度
     */
    private static final int REQUEST_ID_PREFIX_LENGTH = 10;

    private MDCUtil(){

    }


    /**
     *  获取请求事物ID
     */
    public static String getTransactionId(){
        return org.slf4j.MDC.get(MDC_TRANSACTION_ID);
    }


    /**
     * 设置请求事物ID
     */
    public static void setTransactionId(String transactionId){
        org.slf4j.MDC.put(MDC_TRANSACTION_ID,transactionId);
    }

    /**
     * 获取请求用户名
     */
    public static String getUsername(){
        return org.slf4j.MDC.get(MDC_USERNAME);
    }

    /**
     * 设置请求用户名
     */
    public static void setUsername(String username){
        org.slf4j.MDC.put(MDC_USERNAME,username);
    }


    /**
     * 生成请求事物ID
     */
    public static String generateTransactionId(){
        return String.valueOf(System.currentTimeMillis()+ RandomUtils.nextInt(10000,10000000));
    }

    /**
     * 获取MDC封装实体
     */
    public static MDCInfo getMDCInfo(){
        return new MDCInfo(org.slf4j.MDC.getCopyOfContextMap());
    }

    /**
     * 设置mdcInfo
     */
    public static void setMDCInfo(MDCInfo mdcInfo){
        Map<String, String> contextMap = org.slf4j.MDC.getCopyOfContextMap();
        if(contextMap == null){
            contextMap = mdcInfo.getContextMap();
        }else {
            contextMap.putAll(mdcInfo.getContextMap());
        }
        org.slf4j.MDC.setContextMap(contextMap);
    }

    /**
     * MDC封装实体
     */
    public static final class MDCInfo{
        /**
         * MDC 内容MAP
         */
        private Map<String,String> contextMap;

        public MDCInfo(Map<String,String> contextMap){
            this.contextMap = contextMap;
        }


        public Map<String,String> getContextMap(){
            return contextMap;
        }

        public void setContextMap(Map<String,String> contextMap){
            this.contextMap = contextMap;
        }
    }




}
