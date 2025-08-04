package com.zjl.apitest.repository;

import com.zjl.apitest.BaseTest;
import com.zjl.apitest.model.TestSuite;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestSuiteRepositoryTest extends BaseTest {

    @Autowired
    private TestSuiteRepository testSuiteRepository;

    @Test
    public void testFindAll() {
        List<TestSuite> suites = testSuiteRepository.findAll();
        assertNotNull(suites);
        assertEquals(2, suites.size());
    }

    @Test
    public void testFindByName() {
        TestSuite suite = testSuiteRepository.findByName("用户管理API测试");
        assertNotNull(suite);
        assertEquals("dev", suite.getEnvironment());
    }

    @Test
    public void testSaveAndDelete() {
        TestSuite newSuite = new TestSuite();
        newSuite.setName("支付网关测试");
        newSuite.setDescription("测试支付相关接口");
        newSuite.setTags("payment,gateway");
        newSuite.setEnvironment("production");

        TestSuite saved = testSuiteRepository.save(newSuite);
        assertNotNull(saved.getId());

        testSuiteRepository.delete(saved);
        assertFalse(testSuiteRepository.findById(saved.getId()).isPresent());
    }
}
