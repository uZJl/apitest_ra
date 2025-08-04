package com.zjl.apitest.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试套件模型
 */
@Entity
@Table(name = "test_suites")
@Data
public class TestSuite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    @OneToMany(mappedBy = "testSuite", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestCase> testCases = new ArrayList<>();

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "is_active")
    private boolean active = true;

    @Column(name = "tags")
    private String tags;

    @Column(name = "environment")
    private String environment;

    @Column(name = "parallel_execution")
    private boolean parallelExecution = false;

    @Column(name = "setup_script")
    private String setupScript;

    @Column(name = "teardown_script")
    private String teardownScript;

    // 添加测试用例
    public void addTestCase(TestCase testCase) {
        testCases.add(testCase);
        testCase.setTestSuite(this);
    }

    // 移除测试用例
    public void removeTestCase(TestCase testCase) {
        testCases.remove(testCase);
        testCase.setTestSuite(null);
    }
}
