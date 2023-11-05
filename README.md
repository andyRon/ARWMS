仓库管理系统（Warehouse Management System）
---------

https://www.bilibili.com/video/BV1Qe411V7TZ



使用Element-ui直接编写前端页面，没有使用其它脚手架

浏览扩展：Vue DevTools 

## 后端创建

### 1 创建后端项目

- 创建目录

- IDEA打开目录

- 创建模块≤

### 2 加入**mybatis-plus**支持

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

### 3 使用代码生成器生成代码





### 4 实现增删改查



### 5 分页的处理

#### 入参的封装

```json
{   
    "pageSize": 15,
    "pageNum": 2,
    "param": {
        "name":"小戎",
        "no": "admin",
      	...
    }

}
```

```java
@Data
public class QueryPageParam {
    /**
     * 默认
     */
    private static int PAGE_SIZE = 20;
    private static int PAGE_NUM = 1;

    public int pageSize = PAGE_SIZE;
    public int pageNum = PAGE_NUM;

    public HashMap param;
}
```

#### 添加分页拦截器



#### 编写分页的Mapper方法



#### 自定义SQL使用Wrapper



### 6 返回给前端数据的封装

  



## 前端创建

### 7 创建前端项目

Vue 2



### 8 vue项目导入IDEA并运行

vue脚手架：

```
npm install -g @vue/cli
```



先创建，在拷贝进相关目录（直接拷贝进IDEA容易卡顿）

### 9 导入Element-ui



```shell
npm i element-ui -S
```

mainjs全局引入

```js
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'; Vue.use(ElementUI);
```



运行项目：

```shell
npm run serve  
```



### 10 搭建页面布局

Element-ui的 Container 布局容器

 

### 11 页面布局的拆分

分解的好处

### 12 编写Header头页面

1. dropdown下拉
2. 菜单伸缩图标
3. 欢迎字样
4. 去除背景，加入下边框



### 13 菜单导航页面编写

一级菜单



### 14 菜单导航页面伸缩🔖

伸缩的思路：

header点击图标 -> 提交 -> 父组件 -> 改变 -> aside子组件(collapse)

```
@click="collapse

collapse() {
	this.$emit('doCollapse')
}
```

```
<Header @doCollapse="doCollapse"></Header>
    
doCollapse() {
  console.log(1234)
}
```



### 15 安装axios与处理跨域

```
npm install axios --save
```

在main.js全局引入axios

```js
import axios from ‘axios’; 
Vue.prototype.$axios =axios;
```



> Spring 跨域处理的几种方式？🔖



可以是库：request.js处理域名问题

## 综合

### 16 列表展示



1. 列表数据
2. 用tag转换列
3. header-cell-style设置表头样式 
3. 加上边框
5. 按钮(编辑、删除)
6. 后端返回结果封装(Result)

### 17 分页处理

1. ⻚面加上分⻚代码
2. 修改查询方法和参数
3. 处理翻⻚、设置条数逻辑(注意一个问题)

🔖

### 18 查询处理

1. 查询的布局(包含 查询、重置按钮)
2. 输入框
3. 下拉框
4. 回⻋事件(查询) `@keyup.enter.native` ，查询框回车和点击按钮效果一样都是查询
4. 重置处理

🔖重置后数据不复原

### 19 新增

1. 新增按钮
2. 弹出窗口
3. 编写表单
4. 提交数据(提示信息、列表刷新) 
4. 数据的检查



6. 账号的唯一验证



7. 表单重置



🔖p21



### 20 修改

1. 传递数据到表单 
2. 提交数据到后台 
3. 表单重置

### 21 删除

1. 获取数据(id) 
1. 删除确认
3. 提交到后台



### 22 登录

1. 登录⻚面
2. 后台查询代码
3. 登录⻚面的路由

安装路由插件(npm i vue-router@3.5.4 ) 

创建路由文件

```js
import VueRouter from 'vue-router';
const routes =[
    {
        path:'/',
        name:'login',
        component:()=>import('../components/Login')
} ]

const router = new VueRouter({
    mode:'history',
routes })
export  default router;
```

mainjs注册



4. 主⻚的路由

### 23 退出登录

1. 展示名字
2. 退出登录事件
3. 退出跳转、清空相关数据 
3. 退出确认

### 24 首页个人中心

1. 编写⻚面
2. 路由跳转
3. 路由错误解决

```js
const VueRouterPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
}
```



### 25 菜单跳转

1. 菜单增加router、高亮 
1. 配置子菜单
3. 模拟动态menu

### 26 动态路由





### 27 管理员管理、用户管理



### 28 仓库管理

1. 表设计
2. 根据表生成后端代码
3. 编写后端增删改成代码 
3. postman测试查询代码 
3. 编写前端相关代码

### 29 物品类型管理

1. 表设计
2. 根据表生成后端代码
3. 编写后端增删改成代码 
3. postman测试查询代码 
3. 编写前端相关代码

### 30 物品管理

1. 表设计
2. 根据表生成后端代码
3. 编写后端增删改成代码 
3. postman测试查询代码 
3. 编写前端相关代码

```js
count: [
{required: true, message: '请输入数量', trigger: 'blur'},
{pattern: /^([1-9][0-9]*){1,4}$/,message: '数量必须为正整数字',trigger: "blur"}, {validator:checkCount,trigger: 'blur'}
],
```

```js
let checkCount = (rule, value, callback) => {
    if(value>9999){
callback(new Error('数量输入过大')); }else{
        callback();
    }
};
```

6. 仓库和分类的列表展现

7. 查询条件中增加仓库和分类的条件 
7. 表单中仓库和分类下拉实现

### 31 记录管理

1. 表设计
2. 根据表生成后端代码
3. 编写后端查询代码
4. 编写前端相关代码
5. 优化
   - 列表展示商品名、仓库、分类名
   - 按物品名查询、仓库、分类查询

### 32 出入库管理

1. 表单编写
2. 入库操作(记录、更新物品数量、自动填充时间)
  
3. 用户选择

### 33 优化

1. 出入库权限控制 
2. 记录查询权限控制

## 如何部署前后端分离项目（springboot+vue）

【已三连关注 + 欣欣向戎rm】
