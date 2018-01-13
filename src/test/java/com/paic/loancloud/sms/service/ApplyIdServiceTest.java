package com.paic.loancloud.sms.service;


import com.paic.loancloud.sms.model.entity.SmsDemoDao;
import com.paic.loancloud.sms.model.entity.sunjian.CheckCustomerValidEntity;
import com.paic.loancloud.sms.model.form.sunjian.ApplyIdForm;
import com.paic.loancloud.sms.model.json.sunjian.CustomerQualificationAuditJson;
import com.paic.loancloud.sms.model.json.sunjian.CustomerTelephoneJson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplyIdServiceTest {

    @Autowired
    private ApplyIdService applyIdService;

    @Test
    public void queryApplyIdPhone_when_ApplyId_then_电话和电话code(){
        System.out.println("测试");
        CheckCustomerValidEntity checkCustomerValidEntity = new CheckCustomerValidEntity();
        checkCustomerValidEntity.setApplyId(432);
        List<CustomerTelephoneJson> customerTelephoneJsons = applyIdService.queryApplyIdPhone(checkCustomerValidEntity);
        System.out.println(customerTelephoneJsons.size());
    }


    @Test
    public void queryApplyIdCustomer_when_ApplyId_then_客户信息(){
        System.out.println("测试");
        CheckCustomerValidEntity checkCustomerValidEntity = new CheckCustomerValidEntity();
        checkCustomerValidEntity.setApplyId(432);
        CustomerQualificationAuditJson customerQualificationAuditJson = applyIdService.queryApplyIdCustomer(checkCustomerValidEntity);
        System.out.println(customerQualificationAuditJson);
    }
}
