package com.paic.loancloud.sms.model.json.sunjian;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

public class CustomerQualificationAuditJson {

    @ApiModelProperty(value="用户姓名")
    @NotNull(message = "姓名不能为空")
    @Size(min = 1 , max = 50 , message = "数据库字段编码长度只能在1-50之间")
    private String customerName;//customer_name

    @ApiModelProperty(value="身份证号")
    @NotNull(message = "身份证号不能为空")
    private String identityNum;//identity_num
//    private List<Map<String, Object>> telList;//tele_num 单独写个接口





    @ApiModelProperty(value="城市编号")
    @NotNull(message = "城市编号不能为空")
    private String cityCode;//city_code

    @ApiModelProperty(value="打款结果状态")
    @NotNull(message = "打款结果状态不能为空")
    private String transferState;

    @ApiModelProperty(value="auth_result_code预约结果代码(审核状态)")
    @NotNull(message = "预约结果代码不能为空")
    private String authResultCode;//

    @ApiModelProperty(value="阶段类型")
    @NotNull(message = "阶段类型不能为空")
    private String phaseType;//phase_type

    @ApiModelProperty(value="阶段代码")
    @NotNull(message = "阶段代码不能为空")
    private String phaseCode;//phaseCode

    @ApiModelProperty(value="阶段状态")
    @NotNull(message = "阶段状态不能为空")
    private String phaseStatus;//phaseStatus

    @ApiModelProperty(value="是否成功原因reason")
    @NotNull(message = "是否成功原因不能为空")
    private String reason;

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



    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getTransferState() {
        return transferState;
    }

    public void setTransferState(String transferState) {
        this.transferState = transferState;
    }

    public String getAuthResultCode() {
        return authResultCode;
    }

    public void setAuthResultCode(String authResultCode) {
        this.authResultCode = authResultCode;
    }

    public String getPhaseType() {
        return phaseType;
    }

    public void setPhaseType(String phaseType) {
        this.phaseType = phaseType;
    }

    public String getPhaseCode() {
        return phaseCode;
    }

    public void setPhaseCode(String phaseCode) {
        this.phaseCode = phaseCode;
    }

    public String getPhaseStatus() {
        return phaseStatus;
    }

    public void setPhaseStatus(String phaseStatus) {
        this.phaseStatus = phaseStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
