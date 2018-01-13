package com.paic.loancloud.sms.service;

import com.paic.loancloud.sms.model.entity.SmsDemoDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sunjian on 2017/3/27.
 */
public interface SmsDemoService {

    /*
    * 查询多条SmsDemoDao
    * */
    public List<SmsDemoDao> queryListOfSmsByDemo();

    /*
    * 增加一条SmsDemoDao
    * */
    public boolean addOrUpdateSms(SmsDemoDao smsDemoDao);


    /**
     * 通过用户名name来查询用户信息
     */
    public List<SmsDemoDao> queryListSmsDemoDao(String name);
}
