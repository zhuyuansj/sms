package com.paic.loancloud.sms.mapper;

import com.paic.loancloud.sms.model.entity.SmsDemoDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sunjian on 2017/3/27.
 */
@Mapper
public interface SmsDemoMapper {
    /*
    * removeXxx负责删除单个对象的方法，返回boolean
    * updateXxx负责更新单个对象的方法，返回boolean
    * addXxx负责新增单个对象的方法，返回Boolean
    * addOrUpdateXxx负责新增或更新单个对象的方法，返回boolean
    * saveXxx负责保存多个对象的方法，返回boolean或int视情况而定
    * getXxx负责查询单个对象的方法，返回entity
    * queryXxx负责查询多个对象的方法queryListOfXxxByXxx  queryMapOfXxxByXxx
    * */
    /*
    * 查询多条Test
    * */
    public List<SmsDemoDao> queryListOfSmsByDemo();

    /*
    * 增加一条SmsDemoDao
    * */
    public boolean addOrUpdateSms(SmsDemoDao smsDemoDao);

    /**
     * 通过用户名name来查询用户信息
     */
    public List<SmsDemoDao> queryListSmsDemoDao(@Param("name")String name);
}
