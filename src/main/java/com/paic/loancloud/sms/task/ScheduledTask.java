package com.paic.loancloud.sms.task;

import org.apache.log4j.spi.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by sunjian on 2017/3/30.
 */

@Component
public class ScheduledTask {
//    private Logger logger = Logger.getLogger(String.valueOf(ScheduledTask.class));
    @Scheduled(cron = "0 0/2 8-20 * * ?")
    public void executeFileDownLoadTask(){
        //间隔2分钟执行工单任务
        Thread current = Thread.currentThread();
        System.out.println("定时任务1-"+current.getId()+",name:"+current.getName());
    }
//
//    @Scheduled(fixedRate = 10000)
//    public void executeUploadTask(){
//        //间隔1分钟,执行工单上传任务
//        Thread current = Thread.currentThread();
//        System.out.println("定时任务2:"+current.getId());
//        System.out.println("定时任务2:"+current.getId()+",name"+current.getName());
//        try {
//            Thread.currentThread().join(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Scheduled(fixedDelay = 10000)
//    public void executeUploadBackTask(){
//        //间隔3分钟，执行工单上传任务
//        Thread current = Thread.currentThread();
//        System.out.println("定时任务3:"+current.getId());
//        System.out.println("shceduledTest定时任务3:"+current.getId()+",name:"+current.getName());
//        try {
//            Thread.currentThread().join(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
