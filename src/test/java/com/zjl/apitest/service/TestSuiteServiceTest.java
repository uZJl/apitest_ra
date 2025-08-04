package com.zjl.apitest.service;

import com.zjl.apitest.BaseTest;
import com.zjl.apitest.model.TestSuite;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestSuiteServiceTest extends BaseTest {

    @Autowired
    private TestSuiteService testSuiteService;

    @Test
    public void testGetAllTestSuites() {
        List<TestSuite> suites = testSuiteService.getAllTestSuites();
        assertNotNull(suites);
        assertEquals(2, suites.size());
    }

    @Test
    public void testCreateTestSuite() {
        TestSuite newSuite = new TestSuite();
        newSuite.setName("新测试套件");
        newSuite.setDescription("新描述");
        newSuite.setTags("new,tag");
        newSuite.setEnvironment("test");

        TestSuite created = testSuiteService.createTestSuite(newSuite);
        assertNotNull(created.getId());
        assertEquals("新测试套件", created.getName());
    }

    @Test
    public void testGetTestSuiteById() {
        TestSuite suite = testSuiteService.getTestSuiteById(1L);
        assertNotNull(suite);
        assertEquals("用户管理API测试", suite.getName());
    }

    @Test
    public void testGetTestSuiteByIdNotFound() {
        assertThrows(RuntimeException.class, () -> {
            testSuiteService.getTestSuiteById(999L);
        });
    }
}
