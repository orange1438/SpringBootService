package com.orange.service.task;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/16 0016.
 */
@Service
public class TempTask {

    private boolean isActive=true;

    @PostConstruct
    public void startTask(){
        /*如果要启线程，像下面的代码一样写*/

        System.out.println("startTask");
        isActive=true;
        new Thread(new Runnable(){
            @Override
            public void run() {
                while (isActive){
                    try{
                        System.out.println("while releaseStatus，I am task···");
                        //terminalOnlineChange.releaseStatus();//任务逻辑处理服务层方法，请根据实际情况写这的代码
                        //睡眠30秒
                        Thread.sleep(15*1000);
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }).start();
        System.out.println("taskStart");

    }

    public void stopTask() {
        isActive = false;
    }
}
