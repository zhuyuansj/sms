package com.paic.loancloud.sms.service.impl;


import com.paic.loancloud.sms.mapper.ApplyIdMapper;
import com.paic.loancloud.sms.model.entity.sunjian.CheckCustomerValidEntity;
import com.paic.loancloud.sms.model.form.sunjian.ApplyIdForm;
import com.paic.loancloud.sms.model.json.sunjian.CustomerQualificationAuditJson;
import com.paic.loancloud.sms.model.json.sunjian.CustomerTelephoneJson;
import com.paic.loancloud.sms.service.ApplyIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyIdServiceImpl implements ApplyIdService{

    @Autowired
    private ApplyIdMapper applyIdMapper;


    @Override
    public List<CustomerTelephoneJson> queryApplyIdPhone(CheckCustomerValidEntity checkCustomerValidEntity) {
        List<CustomerTelephoneJson> customerTelephoneJsons = applyIdMapper.queryApplyIdPhone(checkCustomerValidEntity);
        return customerTelephoneJsons;
    }

    @Override
    public CustomerQualificationAuditJson queryApplyIdCustomer(CheckCustomerValidEntity checkCustomerValidEntity) {
        CustomerQualificationAuditJson customerQualificationAuditJson = applyIdMapper.queryApplyIdCustomer(checkCustomerValidEntity);
        return customerQualificationAuditJson;
    }

}
