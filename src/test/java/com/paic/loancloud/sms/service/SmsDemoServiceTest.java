package com.paic.loancloud.sms.service;

import com.paic.loancloud.sms.mapper.SmsDemoMapper;
import com.paic.loancloud.sms.model.entity.SmsDemoDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by sunjian on 2017/3/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsDemoServiceTest {

    @Autowired
    private SmsDemoMapper smsDemoMapper;

    @Test
    public void queryListOfSmsByDemo(){
        System.out.println("测试");
        List<SmsDemoDao> smsDemoDaos = smsDemoMapper.queryListOfSmsByDemo();
        for (SmsDemoDao dao : smsDemoDaos){
            System.out.println("dao==>"+dao);
        }
    }


    /**
     * @Transactional
     @Rollback实现事物回滚功能
     */
    @Test
    @Transactional
    @Rollback
    public void addOrUpdateSms(){
        SmsDemoDao smsDemoDao = new SmsDemoDao();
        smsDemoDao.setId(33);
        smsDemoDao.setName("name");
        smsDemoDao.setPassword("password");
        smsDemoMapper.addOrUpdateSms(smsDemoDao);
    }

    @Test
    public void queryListSmsDemoDao(){
        List<SmsDemoDao> love = smsDemoMapper.queryListSmsDemoDao("love");
        for (SmsDemoDao smsDemoDao:love) {
            System.out.println(smsDemoDao);
        }
    }
}
