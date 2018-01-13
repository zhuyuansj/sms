package com.paic.loancloud.sms.web;

import com.paic.loancloud.sms.model.entity.SmsDemoDao;
import com.paic.loancloud.sms.model.form.SmsDemoForm;
import com.paic.loancloud.sms.service.SmsDemoService;
import com.paic.loancloud.sms.util.ReturnJson;
import com.paic.loancloud.sms.util.SpringUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by sunjian on 2017/3/27.
 */
@RestController
public class SmsDemoRest {

    @Bean
    public SmsDemoDao getSmsDemoDao(){return new SmsDemoDao();}


    @Autowired
    private SmsDemoService smsDemoService;

    @GetMapping(value = "/sms2")
    public List<SmsDemoDao> queryListOfSmsByDemo(){
        return smsDemoService.queryListOfSmsByDemo();
    }

    @PostMapping(value = "/test1")
    public List<SmsDemoDao> getSmsDemoDao(@RequestParam(value = "id",required = false, defaultValue = "0")Integer myid){
        System.out.println(myid);
        return  smsDemoService.queryListOfSmsByDemo();
    }

    @PostMapping(value = "test2")//由于后台的updateTime是timestamp类型，前端无法直接传递，故需要传递String到后台,进行转换
    public void test2(SmsDemoDao smsDemoDao/*HttpServletRequest request,HttpServletResponse response*/){
        System.out.println(smsDemoDao);
    }
    @GetMapping(value = "test3")
    public void test3(HttpServletRequest request){
        SmsDemoDao smsDemoDao = (SmsDemoDao) SpringUtil.getBean("getSmsDemoDao");
        System.out.println(smsDemoDao);
        String name = request.getParameter("name");
        String updateTime = request.getParameter("updateTime");
        System.out.println(name+"==>"+updateTime);
    }

    @PostMapping("addSmsDemoDao")
    @ApiOperation(value = "新增sms短信信息",notes = "传递信息，新增字段信息，返回是否成功标志",
    response = Boolean.class)//@Validated是表单验证
    public ReturnJson addSmsDemoDao(@Validated @RequestBody(required = true) SmsDemoForm smsDemoForm){
        //增加Sms信息
        SmsDemoDao smsDemoDao = new SmsDemoDao();
        //右边复制到左边,右边的对象范围大，左边的对象范围小
        BeanUtils.copyProperties(smsDemoForm,smsDemoDao);
        boolean flag = smsDemoService.addOrUpdateSms(smsDemoDao);
        return ReturnJson.success(flag);
    }


}
