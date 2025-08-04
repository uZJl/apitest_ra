package com.zjl.apitest.service;

import com.zjl.apitest.model.TestCase;
import com.zjl.apitest.model.TestResult;
import com.zjl.apitest.model.TestStep;
import com.zjl.apitest.model.TestSuite;

import java.util.List;
import java.util.Map;

/**
 * 测试执行服务接口
 */
public interface TestExecutionService {

    /**
     * 执行测试用例
     * @param testCase 测试用例
     * @param environmentId 环境ID
     * @param executionId 执行ID
     * @return 测试结果列表
     */
    List<TestResult> executeTestCase(TestCase testCase, Long environmentId, String executionId);

    /**
     * 执行测试步骤
     * @param testStep 测试步骤
     * @param environmentId 环境ID
     * @param executionId 执行ID
     * @param variables 变量映射
     * @return 测试结果
     */
    TestResult executeTestStep(TestStep testStep, Long environmentId, String executionId, Map<String, Object> variables);

    /**
     * 执行测试套件
     * @param testSuite 测试套件
     * @param environmentId 环境ID
     * @return 执行ID
     */
    String executeTestSuite(TestSuite testSuite, Long environmentId);

    /**
     * 根据执行ID获取测试结果
     * @param executionId 执行ID
     * @return 测试结果列表
     */
    List<TestResult> getResultsByExecutionId(String executionId);

    /**
     * 获取测试用例的最新执行结果
     * @param testCaseId 测试用例ID
     * @return 测试结果列表
     */
    List<TestResult> getLatestResultsByTestCaseId(Long testCaseId);

    /**
     * 获取测试套件的最新执行结果
     * @param testSuiteId 测试套件ID
     * @return 测试结果列表
     */
    List<TestResult> getLatestResultsByTestSuiteId(Long testSuiteId);

    /**
     * 取消测试执行
     * @param executionId 执行ID
     * @return 是否成功取消
     */
    boolean cancelExecution(String executionId);

    /**
     * 获取执行状态
     * @param executionId 执行ID
     * @return 执行状态
     */
    String getExecutionStatus(String executionId);
}
