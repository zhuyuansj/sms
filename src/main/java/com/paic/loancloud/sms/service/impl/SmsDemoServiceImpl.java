package com.paic.loancloud.sms.service.impl;

import com.paic.loancloud.sms.mapper.SmsDemoMapper;
import com.paic.loancloud.sms.model.entity.SmsDemoDao;
import com.paic.loancloud.sms.service.SmsDemoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sunjian on 2017/3/27.
 */
@Service
public class SmsDemoServiceImpl implements SmsDemoService{

    @Autowired
    private SmsDemoMapper smsDemoMapper;


    @Override
    public List<SmsDemoDao> queryListOfSmsByDemo() {
        return smsDemoMapper.queryListOfSmsByDemo();
    }

    @Override
    @Transactional
    public boolean addOrUpdateSms(SmsDemoDao smsDemoDao) {
        if(smsDemoMapper.addOrUpdateSms(smsDemoDao)==false){
            throw new RuntimeException();
        }else {
            return smsDemoMapper.addOrUpdateSms(smsDemoDao);
        }
    }

    @Override
    public List<SmsDemoDao> queryListSmsDemoDao(String name) {
        return smsDemoMapper.queryListSmsDemoDao(name);
    }
}
