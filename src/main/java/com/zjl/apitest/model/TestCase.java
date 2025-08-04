package com.zjl.apitest.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试用例模型
 */
@Entity
@Table(name = "test_cases")
@Data
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    @OneToMany(mappedBy = "testCase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestStep> steps = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "test_suite_id")
    private TestSuite testSuite;

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

    @Column(name = "priority")
    private int priority = 0;

    @Column(name = "timeout_seconds")
    private int timeoutSeconds = 30;

    @Column(name = "retry_count")
    private int retryCount = 0;

    // 添加测试步骤
    public void addStep(TestStep step) {
        steps.add(step);
        step.setTestCase(this);
    }

    // 移除测试步骤
    public void removeStep(TestStep step) {
        steps.remove(step);
        step.setTestCase(null);
    }
}
