-- 创建数据库（如果不存在）
CREATE DATABASE IF NOT EXISTS job_records DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 使用该数据库
USE job_records;

-- 创建岗位表
CREATE TABLE IF NOT EXISTS job_position (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '岗位ID',
    company_name VARCHAR(100) NOT NULL COMMENT '企业名称',
    position_name VARCHAR(100) NOT NULL COMMENT '岗位名称',
    salary VARCHAR(50) COMMENT '薪资',
    requirements TEXT COMMENT '具体要求',
    location VARCHAR(50) COMMENT '工作地点',
    contact_info VARCHAR(100) COMMENT '联系方式',
    note TEXT COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='IT岗位信息表';

-- 插入示例数据
INSERT INTO job_position (company_name, position_name, salary, requirements, location, contact_info, note) VALUES
('阿里巴巴', 'Java开发工程师', '25K-35K', '1. 本科及以上学历，计算机相关专业\n2. 3年以上Java开发经验\n3. 熟悉Spring、Spring Boot等框架\n4. 熟悉微服务架构\n5. 良好的沟通能力和团队协作精神', '杭州', '张经理 13812345678', '知名互联网公司，待遇好'),
('腾讯', '前端开发工程师', '20K-30K', '1. 本科及以上学历\n2. 2年以上前端开发经验\n3. 精通HTML、CSS、JavaScript\n4. 熟悉Vue.js或React框架\n5. 了解前端工程化', '深圳', '李经理 13987654321', '大厂，工作压力较大'),
('百度', '测试工程师', '18K-25K', '1. 本科及以上学历\n2. 2年以上软件测试经验\n3. 熟悉测试用例设计方法\n4. 熟悉自动化测试工具\n5. 了解软件开发流程', '北京', '王经理 13712345678', '技术氛围好'),
('字节跳动', '产品经理', '25K-40K', '1. 本科及以上学历\n2. 2年以上互联网产品经验\n3. 良好的产品思维\n4. 优秀的沟通协调能力\n5. 能承受较大工作压力', '北京', '赵经理 13687654321', '加班较多，成长快'),
('华为', '网络工程师', '20K-30K', '1. 本科及以上学历，计算机相关专业\n2. 熟悉网络协议和网络设备\n3. 有CCNA/CCNP认证优先\n4. 良好的沟通能力', '深圳', '刘经理 13512345678', '福利待遇好');