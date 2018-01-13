package com.paic.loancloud.sms.model.form.sunjian;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(value="根据applyId查询信息")
public class ApplyIdForm {
    @ApiModelProperty(value="需要传入applyId")
    @NotNull(message = "applyId不能为空")
    private long applyId;

    public long getApplyId() {
        return applyId;
    }

    public void setApplyId(long applyId) {
        this.applyId = applyId;
    }
}
