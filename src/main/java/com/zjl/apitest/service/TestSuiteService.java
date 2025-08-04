package com.zjl.apitest.service;

import com.zjl.apitest.model.TestSuite;
import java.util.List;

public interface TestSuiteService {

    List<TestSuite> getAllTestSuites();

    TestSuite getTestSuiteById(Long id);

    TestSuite createTestSuite(TestSuite testSuite);
}
