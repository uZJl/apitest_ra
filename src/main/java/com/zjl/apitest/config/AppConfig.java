package com.zjl.apitest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * 应用主配置类
 */
@Configuration
@ComponentScan(basePackages = {"com.zjl.apitest.service", "com.zjl.apitest.engine", "com.zjl.apitest.util"})
@PropertySource("classpath:application.properties")
@Import({PersistenceConfig.class})
public class AppConfig {
    // 全局应用配置
}
