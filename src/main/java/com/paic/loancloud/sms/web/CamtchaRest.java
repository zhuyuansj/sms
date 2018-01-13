package com.paic.loancloud.sms.web;

import com.paic.loancloud.sms.util.CaptchaUtil;
import com.paic.loancloud.sms.util.ReturnJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunjian on 2017/4/4.
 */
@RestController
@RequestMapping("/captcha")
@Api(description = "验证码生成系统API")
public class CamtchaRest {
    //定义图片上显示验证码的个数
    private static final Integer CODE_COUNT = 4;
    //定义图片的width
    private static final Integer WIDTH = 90;
    //定义图片的height
    private static final Integer HEIGHT = 20;
    //定义图片的height
    private static final String IMAGE_TYPE = "jpeg";

//    @GetMapping(value = "/code")
//    @ApiOperation(value = "生成验证码图片流与key值",notes = "通过规则生成验证码，返回数据结果",response = CaptchaJson.class)
//    public ReturnJson getCaptcha(){
//        String[] str[] = CaptchaUtil.getCaptchImageIO(WIDTH,HEIGHT,CODE_COUNT,IMAGE_TYPE);
//        Capthca capthca = new Captcha();
//        capthca.setImageIO(str[0]);
//        capthca.setCode(str[1]);
//        return ReturnJson.success(capthca);
//    }


}
