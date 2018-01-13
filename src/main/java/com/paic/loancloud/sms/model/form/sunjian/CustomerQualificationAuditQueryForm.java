package com.paic.loancloud.sms.model.form.sunjian;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerQualificationAuditQueryForm {


    @ApiModelProperty(value="需要传入applyId")
    @NotNull(message = "applyId不能为空")
    private long applyId;

    @ApiModelProperty(value="用户姓名")
    @NotNull(message = "姓名不能为空")
    @Size(min = 1 , max = 50 , message = "数据库字段编码长度只能在1-50之间")
    private String customerName;//customer_name


    @ApiModelProperty(value="身份证号")
    @NotNull(message = "身份证号不能为空")
    private String identityNum;//identity_num

    @ApiModelProperty(value="电话号码")
    @NotNull(message = "电话号码类型不能为空")
    private String teleNum;//tele_num

    @ApiModelProperty(value="电话号码类型代码(01：联系电话1 02：联系电话2 03：联系电话3 04：联系电话4)")
    @NotNull(message = "电话号码类型不能为空")
    private String cityCode;//city_code

    public long getApplyId() {
        return applyId;
    }

    public void setApplyId(long applyId) {
        this.applyId = applyId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }

    public String getTeleNum() {
        return teleNum;
    }

    public void setTeleNum(String teleNum) {
        this.teleNum = teleNum;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
