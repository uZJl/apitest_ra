package com.zjl.apitest.service;

import com.zjl.apitest.model.TestCase;

import java.util.List;
import java.util.Optional;

/**
 * 测试用例服务接口
 */
public interface TestCaseService {

    /**
     * 保存测试用例
     * @param testCase 测试用例
     * @return 保存后的测试用例
     */
    TestCase saveTestCase(TestCase testCase);

    /**
     * 根据ID查找测试用例
     * @param id 测试用例ID
     * @return 测试用例
     */
    Optional<TestCase> findById(Long id);

    /**
     * 查找所有测试用例
     * @return 测试用例列表
     */
    List<TestCase> findAll();

    /**
     * 根据测试套件ID查找测试用例
     * @param testSuiteId 测试套件ID
     * @return 测试用例列表
     */
    List<TestCase> findByTestSuiteId(Long testSuiteId);

    /**
     * 根据标签查找测试用例
     * @param tag 标签
     * @return 测试用例列表
     */
    List<TestCase> findByTag(String tag);

    /**
     * 删除测试用例
     * @param id 测试用例ID
     */
    void deleteById(Long id);

    /**
     * 执行测试用例
     * @param id 测试用例ID
     * @param environmentId 环境ID
     * @return 执行ID
     */
    String executeTestCase(Long id, Long environmentId);

    /**
     * 导入测试用例
     * @param content 测试用例内容（JSON/YAML格式）
     * @return 导入的测试用例
     */
    TestCase importTestCase(String content);

    /**
     * 导出测试用例
     * @param id 测试用例ID
     * @param format 导出格式（JSON/YAML）
     * @return 导出的内容
     */
    String exportTestCase(Long id, String format);
}
