package com.paic.loancloud.sms.model.form;


import javafx.beans.DefaultProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by sunjian on 2017/3/27.
 */
public class SmsDemoForm {
    @NotNull(message = "id不能为空")
    @Size(min = 1 , max = 50 , message = "数据库字段编码长度只能在1-50之间")
    private String id;

    @NotNull(message = "姓名不能为空")
    @Size(min = 1 , max = 50 , message = "数据库字段编码长度只能在1-50之间")
    private String name;


    //正则表达式验证手机号
//    @Pattern(regexp = "^[1][3,4,5,7,8][0-9]{9}$")
//    @Pattern(regexp = "[1,2,3]")  只能输入1个数字，并且这个数字只能为1,2,3
    @NotNull(message = "密码不能为空")
    @Size(min = 1 , max = 50 , message = "数据库字段编码长度只能在1-50之间")
    private String password;



    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
