仓库管理系统（Warehouse Management System）
---------

https://www.bilibili.com/video/BV1Qe411V7TZ

## 前置

### 创建后端项目

- 创建目录

- IDEA打开目录

- 创建模块≤

#### 数据库

```mysql
create table user (
    id int auto_increment comment '主键' primary key,
    no varchar(20) null comment '账号',
    name varchar(100) not null comment '名字',
    password varchar(20) not null comment '密码',
    age int null,
    sex int null comment '性别',
    phone varchar(20) null comment '电话',
    role_id int null comment '角色 0超级管理员，1管理员，2普通账号',
    isValid varchar(4) default 'Y' null comment '是否有效，Y有效，其它无效'
) charset = utf8;
```

#### yml文件的配置

端口和数据源的配置

```yaml
server:
  port: 8090
spring:
  application:
    name: wms
  datasource:
    druid:
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://localhost:3306/wms?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowPublicKeyRetrieval=true
      username: root
      password: 33824
```

### 代码生成
