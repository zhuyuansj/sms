package com.paic.loancloud.sms.web;


import com.paic.loancloud.sms.model.entity.sunjian.CheckCustomerValidEntity;
import com.paic.loancloud.sms.model.form.sunjian.ApplyIdForm;
import com.paic.loancloud.sms.model.form.sunjian.CustomerQualificationAuditQueryForm;
import com.paic.loancloud.sms.model.json.sunjian.CustomerQualificationAuditJson;
import com.paic.loancloud.sms.model.json.sunjian.CustomerTelephoneJson;
import com.paic.loancloud.sms.service.ApplyIdService;
import com.paic.loancloud.sms.util.ReturnJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController()
@RequestMapping("/customer_qualification_audit")
@Api(description = "MOCK测试使用, 后续会更新")
public class CustomerQualificationAuditRest {


    @Autowired
    private ApplyIdService applyIdService;



    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ApiOperation(value = "获取页面初始化信息", notes = "根据客户号查询客户资质校验信息", response = ApplyIdForm.class)
    public ReturnJson initCustomerVerifyInfo(@Validated @RequestBody(required = true) ApplyIdForm customerTelpehoneForm) {
        CustomerQualificationAuditJson customerQualificationAuditJson = new CustomerQualificationAuditJson();
        long applyId = (Long) customerTelpehoneForm.getApplyId();//前端获得到的客户号
        System.out.println(applyId);
        customerQualificationAuditJson.setCustomerName("张三");
        customerQualificationAuditJson.setIdentityNum("310105******1234");
        customerQualificationAuditJson.setCityCode("310005");
        customerQualificationAuditJson.setPhaseCode("0200");
        customerQualificationAuditJson.setPhaseStatus("0201");
        customerQualificationAuditJson.setPhaseType("PD");
        customerQualificationAuditJson.setAuthResultCode("N");
        customerQualificationAuditJson.setTransferState("Y");
        if (StringUtils.equals("Y", customerQualificationAuditJson.getAuthResultCode())) {
            customerQualificationAuditJson.setTransferState("审核通过");
        } else if (StringUtils.equals("N", customerQualificationAuditJson.getAuthResultCode())) {
            customerQualificationAuditJson.setTransferState("审核不通过");
            customerQualificationAuditJson.setReason("failReason");
        }
        return ReturnJson.success(customerQualificationAuditJson);
    }

    @RequestMapping(value = "/query_telephone", method = RequestMethod.POST)
    @ApiOperation(value = "根据applyid查询电话号码", notes = "查询电话号码", response = ApplyIdForm.class)
    public ReturnJson queryTelphone(@Validated @RequestBody(required = true) ApplyIdForm customerTelpehoneForm) {
        long applyId = (Long) customerTelpehoneForm.getApplyId();//前端获得到的客户号
        System.out.println(customerTelpehoneForm.getApplyId());
        CheckCustomerValidEntity checkCustomerValidEntity = new CheckCustomerValidEntity();
        checkCustomerValidEntity.setApplyId(432);
        List<CustomerTelephoneJson> customerTelephoneJsons = applyIdService.queryApplyIdPhone(checkCustomerValidEntity);
        return ReturnJson.success(customerTelephoneJsons);
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "获取打款信息", notes = "根据客户号打款结果", response = CustomerQualificationAuditJson.class)
    public ReturnJson updateCustomerverify(@Validated @RequestBody(required = true) ApplyIdForm customerTelpehoneForm) {
        long applyId = (Long) customerTelpehoneForm.getApplyId();//前端获得到的客户号
        System.out.println(customerTelpehoneForm.getApplyId());
        CustomerQualificationAuditJson customerQualificationAuditJson = new CustomerQualificationAuditJson();
        customerQualificationAuditJson.setTransferState("Y");
        return ReturnJson.success(customerQualificationAuditJson);
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ApiOperation(value = "获取审核结果", notes = "根据客户信息获取审核结果", response = CustomerQualificationAuditJson.class)
    public ReturnJson submitCustomerVerifyResult(@Validated @RequestBody(required = true) CustomerQualificationAuditQueryForm checkCustomerValidForm) {
        System.out.println(checkCustomerValidForm.getApplyId());
        System.out.println(checkCustomerValidForm.getCustomerName());
        System.out.println(checkCustomerValidForm.getApplyId());
        System.out.println(checkCustomerValidForm.getCityCode());
        CustomerQualificationAuditJson customerQualificationAuditJson = new CustomerQualificationAuditJson();
        customerQualificationAuditJson.setAuthResultCode("Y");
        customerQualificationAuditJson.setPhaseCode("0200");
        customerQualificationAuditJson.setPhaseType("0201");
        customerQualificationAuditJson.setPhaseStatus("PS");
        if (StringUtils.equals("Y", customerQualificationAuditJson.getAuthResultCode())) {
            customerQualificationAuditJson.setTransferState("审核通过");
        } else if (StringUtils.equals("N", customerQualificationAuditJson.getAuthResultCode())) {
            customerQualificationAuditJson.setTransferState("审核不通过");
            customerQualificationAuditJson.setReason("failReason");
        }
        return ReturnJson.success(customerQualificationAuditJson);
    }

}
