package com.zjl.apitest.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 环境配置模型
 */
@Entity
@Table(name = "environments")
@Data
public class Environment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // 环境名称: DEV, TEST, STAGING, PROD, etc.

    @Column(length = 500)
    private String description;

    @Column(name = "base_url", length = 500)
    private String baseUrl; // 环境基础URL

    @Column(name = "variables", length = 10000)
    @Type(type = "text")
    private String variables; // JSON格式存储环境变量

    @Column(name = "headers", length = 5000)
    private String headers; // JSON格式存储环境通用请求头

    @Column(name = "auth_type")
    private String authType; // NONE, BASIC, BEARER, OAUTH2, etc.

    @Column(name = "auth_config", length = 2000)
    private String authConfig; // JSON格式存储认证配置

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "is_active")
    private boolean active = true;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "proxy_config", length = 1000)
    private String proxyConfig; // JSON格式存储代理配置

    @Column(name = "timeout_seconds")
    private int timeoutSeconds = 30;

    @Column(name = "ssl_verification")
    private boolean sslVerification = true;
}
