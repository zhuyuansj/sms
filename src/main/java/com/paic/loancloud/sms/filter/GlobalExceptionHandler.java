package com.paic.loancloud.sms.filter;

import com.paic.loancloud.sms.util.ArgumentInvlidResult;
import com.paic.loancloud.sms.util.CommonException;
import com.paic.loancloud.sms.util.CommonResult;
import com.paic.loancloud.sms.util.ReturnJson;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by sunjian on 2017/4/2.
 */
@ControllerAdvice//在异常情况下，前端返回界面更友好，不再是404，505这种
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ReturnJson defaultErrorHandler(HttpServletRequest req,MethodArgumentNotValidException exception) throws Exception{
        //输出错误详细信息
        System.out.println(exception.getMessage()+"exception==>"+exception);
        //需要重新封装需要返回的错误信息
       List<ArgumentInvlidResult> invalidArguments = new ArrayList<ArgumentInvlidResult>();
       //解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
        for (FieldError error: exception.getBindingResult().getFieldErrors()) {
            ArgumentInvlidResult invalidArgument = new ArgumentInvlidResult();
            invalidArgument.setErrorMessage(error.getDefaultMessage());
            invalidArgument.setFieldCode(error.getField());
            invalidArgument.setRejectedValue(error.getRejectedValue());
            invalidArgument.setExceptionName(exception.getClass().getSimpleName());
            invalidArguments.add(invalidArgument);
            System.out.println(error.toString());
        }
        return ReturnJson.fail(invalidArguments);
    }



    @ExceptionHandler(value = CommonException.class)
    public ReturnJson defaultErrorHandler(HttpServletRequest req,CommonException exception) throws Exception{
        //输出错误详细信息
        System.out.println(exception.getMessage()+"exception"+exception);
        //解析原错误信息，封装后返回
        CommonResult commonResult = new CommonResult();
        commonResult.setErrorMessage(exception.getMessage());
        commonResult.setExceptionName(exception.getClass().getSimpleName());
        return ReturnJson.json(exception.getResponseCode(),commonResult);
    }

    @ExceptionHandler(value = Exception.class)
    public ReturnJson defaultErrorHandler(HttpServletRequest req,Exception exception) throws Exception{
        //输出错误详细信息
        System.out.println(exception.getMessage()+"exception"+exception);
        CommonResult commonResult = new CommonResult();
        commonResult.setErrorMessage(exception.getMessage());
        commonResult.setExceptionName(exception.getClass().getSimpleName());
        return ReturnJson.fail(commonResult);
    }











}
