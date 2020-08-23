package com.magic.www.permissions.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2020/7/21
 * Time: 17:03
 * To change this template use File | Settings | File Templates.
 * 任务线程配置类
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(3));
    }
}
