package com.orange.service.timing;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/16 0016.
 */

// 定时器:具体定时的参数参考schedule
@EnableScheduling
@Component
public class TimingConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(taskScheduler());
        scheduledTaskRegistrar.addCronTask(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("I am timing``````");
                    }
                    //},"59 55 23 ? * L");
                },"*/10 * * * * ?");
    }

    @Bean(destroyMethod = "shutdown")
    public Executor taskScheduler() {
        return Executors.newScheduledThreadPool(1);
    }

    @Scheduled(cron = "00 19 10 * * *")
    public void test() {
        System.out.println("true = " + true);
    }
}
