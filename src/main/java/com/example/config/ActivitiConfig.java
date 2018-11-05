package com.example.config;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/1 14:20
 * @desc
 */
@Configuration
public class ActivitiConfig {

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String jdbcUsername;

    @Value("${spring.datasource.password}")
    private String jdbcPassword;

    @Value("${spring.datasource.driver-class-name}")
    private String jdbcDriver;

//    @Bean
    public ProcessEngineConfiguration processEngineConfiguration(){
        //获取ProcessEngineConfiguration对象
        ProcessEngineConfiguration engineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        //设置数据库属性
        engineConfiguration.setJdbcDriver(jdbcDriver);
        engineConfiguration.setJdbcUrl(jdbcUrl);
        engineConfiguration.setJdbcUsername(jdbcUsername);
        engineConfiguration.setJdbcPassword(jdbcPassword);

        engineConfiguration.setDatabaseSchemaUpdate("true");
        ProcessEngine processEngine = engineConfiguration.buildProcessEngine();
        System.out.println("流程引擎创建成功");
        return engineConfiguration;
    }
}
