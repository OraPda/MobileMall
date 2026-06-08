# MobileMall

<div align="center">

# 🛒 MobileMall E-Commerce Platform

基于 **Spring Boot + Vue** 的前后端分离商城系统

支持：用户商城｜后台管理｜订单管理｜JWT认证｜RBAC权限控制

</div>

---

## 项目简介

MobileMall 是一套基于 **Spring Boot + Vue** 开发的前后端分离商城系统，包含 **用户商城端** 与 **后台管理端** 两套系统，实现商品管理、购物车、订单管理、用户管理及权限控制等核心电商业务。

项目采用前后端分离架构，后端提供 RESTful API 服务，前端基于 Vue 构建商城页面与后台管理界面，支持完整的电商业务流程。

本项目为 **成都中慧集团校企合作项目**。

---

## 核心功能

### 1. 用户商城端

#### 👤 用户认证

* 用户注册
* 用户登录
* JWT 登录认证
* 用户信息管理

---

#### 🛍️ 商品展示

支持：

* 商品分类浏览
* 商品搜索
* 商品详情查看
* 商品推荐展示

---

#### 🛒 购物车功能

支持：

* 添加商品
* 删除商品
* 商品数量修改
* 购物车结算

---

#### 📦 订单管理

支持：

* 创建订单
* 提交订单
* 查看订单状态
* 历史订单查询

---

#### ⭐ 商品评价

支持：

* 商品评论
* 商品评分
* 用户评价展示

---

### 2. 后台管理端

#### 📊 商品管理

支持：

* 商品新增
* 商品编辑
* 商品删除
* 商品分类管理

---

#### 👥 用户管理

支持：

* 用户信息管理
* 用户状态管理
* 用户数据查看

---

#### 📦 订单管理

支持：

* 订单查询
* 订单状态修改
* 发货管理

---

#### 🔐 权限管理

基于：

```text id="q02lzw"
JWT + RBAC
```

实现：

* 登录认证
* 角色权限控制
* 动态菜单管理

支持管理员权限隔离。

---

## 技术栈

### 前端技术

| 技术         | 说明    |
| ---------- | ----- |
| Vue 2      | 前端框架  |
| Vuex       | 状态管理  |
| Axios      | 网络请求  |
| Element UI | UI组件库 |

---

### 后端技术

| 技术           | 说明        |
| ------------ | --------- |
| Java 8       | 核心开发语言    |
| Spring Boot  | 后端框架      |
| Spring MVC   | MVC Web框架 |
| MyBatis-Plus | ORM持久层框架  |
| MySQL        | 数据库       |
| Redis        | 缓存中间件     |
| JWT          | 登录认证      |
| Maven        | 项目构建工具    |

---

## 系统架构

项目采用：

```text id="fuv2m7"
Vue（用户商城端 / 后台管理端）
                    ↓
             Spring Boot
                    ↓
             MySQL + Redis
```

采用：

```text id="4sghs6"
前后端分离架构
```

实现商城业务逻辑与数据交互。

---

## 项目亮点

### 1. 双系统架构

系统包含：

* 用户商城端
* 后台管理端

实现商城业务与后台运营管理分离。

---

### 2. JWT 登录认证

基于：

```text id="0w62t2"
JWT
```

实现无状态登录认证，提高系统安全性。

---

### 3. RBAC 权限控制

采用：

```text id="o2w4fg"
RBAC（基于角色的权限控制）
```

实现：

```text id="ip7zdr"
用户（User）
      ↓
角色（Role）
      ↓
权限（Permission）
```

支持动态权限分配与菜单控制。

---

### 4. Redis 缓存优化

使用：

```text id="l52q0m"
Redis
```

缓存热点商品数据，提高接口响应速度并降低数据库访问压力。

---

## 项目结构

```text id="qj1jz5"
mobile-mall/

├── mall-admin          # 后台管理端
├── mall-web            # 用户商城端
├── mall-server         # Spring Boot后端
├── sql                 # 数据库脚本
└── doc                 # 项目文档
```

---

## 环境要求

| 环境      | 版本     |
| ------- | ------ |
| JDK     | 1.8+   |
| Maven   | 3.6+   |
| MySQL   | 5.7+   |
| Redis   | Latest |
| Node.js | 14+    |

---

## 项目启动

### 1. 克隆项目

```bash id="pqu9u2"
git clone https://github.com/OraPda/MobileMall.git
```

---

### 2. 初始化数据库

执行：

```sql id="q09fgh"
sql/mobilemall.sql
```

初始化数据库。

---

### 3. 修改配置

修改：

```text id="8lbj3v"
application.yml
```

配置：

* MySQL 数据库连接
* Redis 地址
* 服务端口

---

### 4. 安装依赖

后端：

```bash id="hml4s1"
mvn clean install
```

前端：

```bash id="vn9xv7"
npm install
```

---

### 5. 启动项目

启动后端：

```bash id="j3f0f2"
mvn spring-boot:run
```

启动前端：

```bash id="3pvf2q"
npm run dev
```

默认地址：

```text id="x4f9mq"
http://localhost:8080
```

---

## 接口文档

项目支持：

```text id="3t8wlk"
Swagger API
```

用于接口测试与调试。

---

## 项目亮点总结

* 基于 **Spring Boot + Vue** 前后端分离架构
* 包含 **用户商城端 + 后台管理端** 双系统
* 使用 **JWT + RBAC** 实现权限控制
* 使用 **Redis** 优化热点商品查询
* 支持完整电商业务流程
* 成都中慧集团 **校企合作项目**

---

## License

MIT License
