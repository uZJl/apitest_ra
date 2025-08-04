package com.zjl.apitest.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 断言模型
 */
@Entity
@Table(name = "assertions")
@Data
public class Assertion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "test_step_id")
    private TestStep testStep;

    @Column(name = "assertion_type", nullable = false)
    private String type; // 断言类型: STATUS, JSON_PATH, HEADER, RESPONSE_TIME, etc.

    @Column(name = "field_path", length = 500)
    private String fieldPath; // JSON路径或Header名称

    @Column(name = "operator", nullable = false)
    private String operator; // 操作符: EQUALS, CONTAINS, GREATER_THAN, LESS_THAN, etc.

    @Column(name = "expected_value", length = 1000)
    private String expectedValue; // 期望值

    @Column(name = "assertion_order")
    private int order; // 断言执行顺序

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "is_active")
    private boolean active = true;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "failure_message", length = 500)
    private String failureMessage; // 自定义失败消息
}
