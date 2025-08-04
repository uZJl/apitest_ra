-- 测试套件数据
INSERT INTO test_suites (name, description, created_at, updated_at, is_active, tags, environment, parallel_execution, setup_script, teardown_script) VALUES
('用户管理API测试', '测试用户相关的所有API', NOW(), NOW(), true, 'api,user', 'dev', false, '初始化用户数据', '清理测试数据'),
('订单流程测试', '测试订单创建到完成的完整流程', NOW(), NOW(), true, 'order,workflow', 'staging', true, '初始化商品数据', '清理订单数据');

-- 测试用例数据
INSERT INTO test_cases (name, description, test_suite_id, created_at, updated_at, is_active, tags, priority, timeout_seconds, retry_count) VALUES
('创建用户测试', '测试POST /api/users接口', 1, NOW(), NOW(), true, 'user,create', 1, 30, 0),
('用户登录测试', '测试POST /api/auth/login接口', 1, NOW(), NOW(), true, 'auth,login', 1, 30, 0),
('创建订单测试', '测试POST /api/orders接口', 2, NOW(), NOW(), true, 'order,create', 2, 60, 1),
('订单支付测试', '测试POST /api/orders/{id}/pay接口', 2, NOW(), NOW(), true, 'order,payment', 2, 90, 2);
