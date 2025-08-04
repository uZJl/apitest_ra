package com.zjl.apitest.repository;

import com.zjl.apitest.model.TestSuite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestSuiteRepository extends JpaRepository<TestSuite, Long> {

    TestSuite findByName(String name);

    List<TestSuite> findAll();
}
