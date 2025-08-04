package com.zjl.apitest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 示例测试类
 */
public class SampleTest {

    @Test
    public void testSample() {
        // 简单的断言测试
        Assert.assertTrue(true, "这个测试应该通过");
        System.out.println("示例测试执行成功");
    }

    @Test
    public void testEnvironmentSetup() {
        // 检查环境变量
        String javaHome = System.getProperty("java.home");
        Assert.assertNotNull(javaHome, "Java Home 应该存在");
        System.out.println("Java Home: " + javaHome);
    }
}
