package com.zjl.apitest.service;

import com.zjl.apitest.model.TestSuite;
import com.zjl.apitest.repository.TestSuiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TestSuiteServiceImpl implements TestSuiteService {

    @Autowired
    private TestSuiteRepository testSuiteRepository;

    @Override
    public List<TestSuite> getAllTestSuites() {
        return testSuiteRepository.findAll();
    }

    @Override
    public TestSuite getTestSuiteById(Long id) {
        return testSuiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TestSuite not found with id: " + id));
    }

    @Override
    public TestSuite createTestSuite(TestSuite testSuite) {
        return testSuiteRepository.save(testSuite);
    }
}
