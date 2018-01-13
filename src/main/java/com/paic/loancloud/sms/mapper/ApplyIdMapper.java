package com.paic.loancloud.sms.mapper;

import com.paic.loancloud.sms.model.entity.SmsDemoDao;
import com.paic.loancloud.sms.model.entity.sunjian.CheckCustomerValidEntity;
import com.paic.loancloud.sms.model.form.sunjian.ApplyIdForm;
import com.paic.loancloud.sms.model.json.sunjian.CustomerQualificationAuditJson;
import com.paic.loancloud.sms.model.json.sunjian.CustomerTelephoneJson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApplyIdMapper {
    /**
     * 通过applyId查询用户电话和电话code
     */
    public List<CustomerTelephoneJson> queryApplyIdPhone(CheckCustomerValidEntity checkCustomerValidEntity);

    /**
     * 根据applyId查询用户姓名，身份证号，城市号，预约结果代码，原因，阶段类型，阶段代码，阶段状态，打款结果状态
     */
    public CustomerQualificationAuditJson queryApplyIdCustomer(CheckCustomerValidEntity checkCustomerValidEntity);


}
