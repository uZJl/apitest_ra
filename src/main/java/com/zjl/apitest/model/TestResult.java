package com.zjl.apitest.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 测试结果模型
 */
@Entity
@Table(name = "test_results")
@Data
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "test_case_id")
    private Long testCaseId;

    @Column(name = "test_step_id")
    private Long testStepId;

    @Column(name = "test_suite_id")
    private Long testSuiteId;

    @Column(name = "execution_id", nullable = false)
    private String executionId; // 执行ID，用于关联同一次执行的所有结果

    @Column(name = "status", nullable = false)
    private String status; // PASSED, FAILED, SKIPPED, ERROR

    @Column(name = "response_status_code")
    private Integer responseStatusCode;

    @Column(name = "response_time_ms")
    private Long responseTimeMs;

    @Column(name = "response_headers", length = 5000)
    private String responseHeaders;

    @Column(name = "response_body", length = 100000)
    @Type(type = "text")
    private String responseBody;

    @Column(name = "error_message", length = 2000)
    private String errorMessage;

    @Column(name = "assertion_results", length = 10000)
    @Type(type = "text")
    private String assertionResults; // JSON格式存储断言结果

    @Column(name = "executed_at")
    @CreationTimestamp
    private LocalDateTime executedAt;

    @Column(name = "environment")
    private String environment;

    @Column(name = "executed_by")
    private String executedBy;

    @Column(name = "request_details", length = 10000)
    @Type(type = "text")
    private String requestDetails; // JSON格式存储请求详情

    @Column(name = "test_case_name")
    private String testCaseName;

    @Column(name = "test_step_name")
    private String testStepName;

    @Column(name = "test_suite_name")
    private String testSuiteName;
}
