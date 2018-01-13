package com.paic.loancloud.sms;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestOperations;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunjian on 2017/3/31.
 */
public class EsgHttpClient {

    /**
     * 调用esg服务器
     * 服务端url
     * 参数
     * 客户端编码
     * 服务端返回的结果数据
     */
    public static <T> Map<String,Object> invokeEsgMethod(String url, Map<String,T>paramPost, RestOperations restOperations){
        //设置报文头的格式
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
            headers.setAccept(Arrays.asList(new MediaType[]{new MediaType("application","json",
                    Charset.forName("UTF-8"))}));
            HttpEntity<Map<String, T>> requestEntity = new HttpEntity<>(paramPost, headers);
            //调用服务
            System.out.println("开始调用API接口:url:["+url+"]"+"requestEntity:==>"+"httpMethod==>"+ HttpMethod.POST);
            String json_result = restOperations.postForEntity(url, requestEntity, String.class, new HashMap<>()).getBody();
            System.out.println("json_result==>"+json_result);
        }catch (Exception e){
            System.out.println("调用接口失败==>"+url+"  "+paramPost);
        }
        return null;
    }
}
