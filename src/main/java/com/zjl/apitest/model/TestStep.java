package com.zjl.apitest.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试步骤模型
 */
@Entity
@Table(name = "test_steps")
@Data
public class TestStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    @ManyToOne
    @JoinColumn(name = "test_case_id")
    private TestCase testCase;

    @Column(name = "step_order")
    private int order;

    @Column(name = "request_method")
    private String requestMethod; // GET, POST, PUT, DELETE, etc.

    @Column(name = "request_url", length = 1000)
    private String requestUrl;

    @Column(name = "request_headers", length = 2000)
    private String requestHeaders;

    @Column(name = "request_body", length = 10000)
    @Type(type = "text")
    private String requestBody;

    @Column(name = "request_content_type")
    private String requestContentType;

    @Column(name = "timeout_seconds")
    private int timeoutSeconds = 30;

    @Column(name = "delay_before_ms")
    private int delayBeforeMs = 0;

    @Column(name = "delay_after_ms")
    private int delayAfterMs = 0;

    @OneToMany(mappedBy = "testStep", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Assertion> assertions = new ArrayList<>();

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "variable_extractions", length = 2000)
    private String variableExtractions; // JSON格式存储变量提取规则

    @Column(name = "depends_on_step")
    private Long dependsOnStep; // 依赖的步骤ID

    @Column(name = "skip_condition", length = 500)
    private String skipCondition; // 跳过条件表达式

    // 添加断言
    public void addAssertion(Assertion assertion) {
        assertions.add(assertion);
        assertion.setTestStep(this);
    }

    // 移除断言
    public void removeAssertion(Assertion assertion) {
        assertions.remove(assertion);
        assertion.setTestStep(null);
    }
}
