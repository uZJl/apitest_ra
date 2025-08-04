package com.zjl.apitest.repository;

import com.zjl.apitest.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 测试用例数据访问层
 */
@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {

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
    List<TestCase> findByTagsContaining(String tag);

    /**
     * 根据名称查找测试用例
     * @param name 测试用例名称
     * @return 测试用例列表
     */
    List<TestCase> findByNameContaining(String name);

    /**
     * 查找活跃的测试用例
     * @return 活跃的测试用例列表
     */
    List<TestCase> findByActiveTrue();

    /**
     * 根据优先级查找测试用例
     * @param priority 优先级
     * @return 测试用例列表
     */
    List<TestCase> findByPriority(int priority);
}
