<h1 align="center">Easy Vben</h1>

<div align="center">

</div>

基于SpringBoot2、Druid、Mybatis Plus、Apache Shiro、Activiti、Beetl、HuTool、Quartz等开源框架开发，内置权限、部门、参数、字典、定时任务、代码生成等模块。  
建议与 [Easy-Vben-Admin](https://github.com/TengChongChong/Easy-Vben-Admin) 前端开源项目一起使用
## 文档
[在线文档](http://ev-doc.easy-frame.top/ '在线文档')

## 下载

从 码云 仓库中直接安装最新的代码

```
$ git clone --depth=1 https://github.com/TengChongChong/Easy-Vben.git easy-vben
```

## 目录结构

```
├── db                   # Sql脚本
│   ├── activiti         # 工作流
│   ├── easy-vben.sql    # 基础 sql
│   ├── easy-cms.sql     # CMS sql
│   └── quartz.sql       # 定时任务
├── easy-activiti        # 工作流
├── easy-api             # 入口
├── easy-cms             # CMS
├── easy-common          # 工具
│   ├── easy-core        # 基础
│   ├── easy-mybatis     # MyBatis
│   └── easy-redis       # Redis
├── easy-file            # 文件
├── easy-generator       # 代码生成
├── easy-sample          # 示例
├── easy-scheduler       # 定时任务
└── easy-sys             # 系统
```

## 创建数据库

- 创建数据库并执行`/easy-admin/db/easy-vben.sql`初始化表
- 如需使用CMS功能执行`/easy-admin/db/easy-cms.sql`初始化表
- 执行`/easy-admin/db/activiti/*`创建工作流表
- 执行`/easy-admin/db/quartz.sql`创建定时任务表

## 配置数据源&Redis
打开`/easy-admin/easy-api/src/main/resources/application-dev.yml`文件，修改`Redis`与`数据源`配置。 如果你使用默认的参数安装的`Redis`和`MySQL`
只需修改`spring.datasource.password`即可。

```yaml {19}
spring:
  # Redis
  redis:
    # 数据库索引（默认为0）
    database: 0
    # 服务器地址
    host: 127.0.0.1
    # 服务器连接端口
    port: 6379
    # 服务器连接密码（默认为空）
    password:
  # 数据源，集成多数据源，此处仅需配置主数据源
  datasource:
    dynamic:
      datasource:
        master:
          url: jdbc:mysql://localhost:3306/easy-admin?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowMulQueries=true&allowMultiQueries=true&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true&nullDatabaseMeansCurrent=true&useInformationSchema=true
          username: root
          password: xxx
```
多数据源配置请参考[多数据源配置](xxx, '多数据源配置')
## 配置上传的文件存放路径

打开`/easy-admin/easy-api/src/main/resources/application-dev.yml`文件，修改文件存放路径

```yaml {3}
project:
  # 文件上传路径(不要写以~开头的路径会导致无法访问)
  file-upload-path: /Users/tengchong/development/easy-admin
```

> 此路径会被添加为静态资源映射地址

## 启动服务

执行`com.easy.admin.Application`启动服务