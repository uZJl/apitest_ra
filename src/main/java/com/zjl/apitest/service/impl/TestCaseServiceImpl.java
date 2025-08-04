package com.zjl.apitest.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.zjl.apitest.model.TestCase;
import com.zjl.apitest.repository.TestCaseRepository;
import com.zjl.apitest.service.TestCaseService;
import com.zjl.apitest.service.TestExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * 测试用例服务实现
 */
@Service
@Transactional
public class TestCaseServiceImpl implements TestCaseService {

    @Autowired
    private TestCaseRepository testCaseRepository;

    @Autowired
    private TestExecutionService testExecutionService;

    private final ObjectMapper jsonMapper = new ObjectMapper();
    private final ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

    @Override
    public TestCase saveTestCase(TestCase testCase) {
        return testCaseRepository.save(testCase);
    }

    @Override
    public Optional<TestCase> findById(Long id) {
        return testCaseRepository.findById(id);
    }

    @Override
    public List<TestCase> findAll() {
        return testCaseRepository.findAll();
    }

    @Override
    public List<TestCase> findByTestSuiteId(Long testSuiteId) {
        return testCaseRepository.findByTestSuiteId(testSuiteId);
    }

    @Override
    public List<TestCase> findByTag(String tag) {
        return testCaseRepository.findByTagsContaining(tag);
    }

    @Override
    public void deleteById(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    public String executeTestCase(Long id, Long environmentId) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("测试用例不存在: " + id));

        String executionId = UUID.randomUUID().toString();
        testExecutionService.executeTestCase(testCase, environmentId, executionId);
        return executionId;
    }

    @Override
    public TestCase importTestCase(String content) {
        try {
            TestCase testCase;
            if (content.trim().startsWith("{")) {
                // JSON格式
                testCase = jsonMapper.readValue(content, TestCase.class);
            } else {
                // YAML格式
                testCase = yamlMapper.readValue(content, TestCase.class);
            }
            return saveTestCase(testCase);
        } catch (IOException e) {
            throw new IllegalArgumentException("导入测试用例失败: " + e.getMessage(), e);
        }
    }

    @Override
    public String exportTestCase(Long id, String format) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("测试用例不存在: " + id));

        try {
            if ("yaml".equalsIgnoreCase(format) || "yml".equalsIgnoreCase(format)) {
                return yamlMapper.writeValueAsString(testCase);
            } else {
                return jsonMapper.writeValueAsString(testCase);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("导出测试用例失败: " + e.getMessage(), e);
        }
    }
}
