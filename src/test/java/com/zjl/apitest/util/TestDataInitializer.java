package com.zjl.apitest.util;

import com.zjl.apitest.model.TestSuite;
import com.zjl.apitest.repository.TestSuiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class TestDataInitializer {

    @Autowired
    private TestSuiteRepository testSuiteRepository;

    @PostConstruct
    @Transactional
    public void init() {
        // 初始化测试套件数据
        TestSuite userSuite = new TestSuite();
        userSuite.setName("用户管理API测试");
        userSuite.setDescription("测试用户相关的所有API");
        userSuite.setTags("api,user");
        userSuite.setEnvironment("dev");
        testSuiteRepository.save(userSuite);

        TestSuite orderSuite = new TestSuite();
        orderSuite.setName("订单流程测试");
        orderSuite.setDescription("测试订单创建到完成的完整流程");
        orderSuite.setTags("order,workflow");
        orderSuite.setEnvironment("staging");
        testSuiteRepository.save(orderSuite);
    }
}
