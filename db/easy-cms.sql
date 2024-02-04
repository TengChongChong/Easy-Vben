/*
 Navicat Premium Data Transfer

 Source Server         : MariaDB
 Source Server Type    : MariaDB
 Source Server Version : 110102
 Source Host           : localhost:3306
 Source Schema         : easy-vben

 Target Server Type    : MariaDB
 Target Server Version : 110102
 File Encoding         : 65001

 Date: 04/02/2024 16:31:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cms_article
-- ----------------------------
DROP TABLE IF EXISTS `cms_article`;
CREATE TABLE `cms_article` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `site_id` varchar(32) NOT NULL COMMENT '站点id',
  `column_id` varchar(32) NOT NULL COMMENT '栏目id',
  `title` varchar(128) NOT NULL COMMENT '标题',
  `title_font_family` varchar(32) DEFAULT NULL COMMENT '标题字体',
  `title_color` varchar(32) DEFAULT NULL COMMENT '标题颜色',
  `title_font_weight` varchar(32) DEFAULT NULL COMMENT '标题字重',
  `title_font_size` int(11) DEFAULT NULL COMMENT '标题文字大小',
  `subtitle` varchar(256) DEFAULT NULL COMMENT '副标题',
  `excerpt` varchar(1024) DEFAULT NULL COMMENT '摘要',
  `content` longtext DEFAULT NULL COMMENT '内容',
  `keyword` varchar(128) DEFAULT NULL COMMENT '关键字',
  `description` varchar(1024) DEFAULT NULL COMMENT '描述',
  `tags` varchar(128) DEFAULT NULL COMMENT '标签',
  `source` varchar(128) DEFAULT NULL COMMENT '信息来源',
  `author` varchar(32) DEFAULT NULL COMMENT '作者',
  `release_type` varchar(32) NOT NULL COMMENT '发布方式 1.手动 2.定时',
  `release_date` datetime DEFAULT NULL COMMENT '发布时间',
  `offline_date` datetime DEFAULT NULL COMMENT '下线时间',
  `view_count` int(11) NOT NULL DEFAULT 0 COMMENT '浏览次数',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `url` varchar(512) DEFAULT NULL COMMENT '访问地址',
  `dept_id` varchar(32) DEFAULT NULL COMMENT '部门id',
  `order_no` int(11) DEFAULT NULL COMMENT '排序值',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `version` int(11) DEFAULT 0 COMMENT '乐观锁',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='文章';

-- ----------------------------
-- Records of cms_article
-- ----------------------------
BEGIN;
INSERT INTO `cms_article` (`id`, `site_id`, `column_id`, `title`, `title_font_family`, `title_color`, `title_font_weight`, `title_font_size`, `subtitle`, `excerpt`, `content`, `keyword`, `description`, `tags`, `source`, `author`, `release_type`, `release_date`, `offline_date`, `view_count`, `type`, `url`, `dept_id`, `order_no`, `status`, `version`, `create_user`, `create_date`, `edit_user`, `edit_date`) VALUES ('1677153536992989185', '1670632009719926785', '1677138157587517441', '外部化配置文件', NULL, NULL, NULL, NULL, NULL, NULL, '<h1 data-id=\"heading-0\">简介</h1>\n<p>为方便后期更新，建议将项目配置文件放到项目外部，防止更新时将配置文件覆盖</p>\n<h1 data-id=\"heading-1\">jar包部署</h1>\n<p>jar包部署可以在启动的时候通过<code><span style=\"color: #e67e23;\">spring.config.location</span></code>去指定配置文件所在的目录，<code><span style=\"color: #e67e23;\">spring.profiles.active</span></code>指定环境</p>\n<pre class=\"language-shell\"><code>java -jar easy-api.jar --spring.config.location=/home/soft/api/config/ --spring.profiles.active=prod</code></pre>\n<h1 data-id=\"heading-2\">war包部署</h1>\n<p>war包部署可以通过设置<span style=\"color: #e67e23;\"><code>JAVA_OPTS</code></span>来自定义参数，这里以<span style=\"color: #e67e23;\"><code>apache-tomcat-8.5.40</code></span>为例说明</p>\n<ol>\n<li>修改<code>bin/catalina.sh</code>\n<pre class=\"language-shell\"><code>vi ./bin/catalina.sh</code></pre>\n</li>\n<li>添加参数，在250行左右\n<pre class=\"language-shell\"><code>JAVA_OPTS=\"$JAVA_OPTS -java.protocol.handler.pkgs=org.apache.catalina.webresources -spring.config.location=/home/soft/api/config/ -spring.profiles.active=prod\"</code></pre>\n</li>\n</ol>', NULL, NULL, '配置文件,SpringBoot,外部', NULL, '系统管理员', '1', '2023-07-07 14:19:13', NULL, 0, NULL, NULL, NULL, NULL, '1', 12, '1', '2023-07-07 11:12:18', '1', '2023-07-07 16:14:25');
INSERT INTO `cms_article` (`id`, `site_id`, `column_id`, `title`, `title_font_family`, `title_color`, `title_font_weight`, `title_font_size`, `subtitle`, `excerpt`, `content`, `keyword`, `description`, `tags`, `source`, `author`, `release_type`, `release_date`, `offline_date`, `view_count`, `type`, `url`, `dept_id`, `order_no`, `status`, `version`, `create_user`, `create_date`, `edit_user`, `edit_date`) VALUES ('1677216524122836994', '1670632009719926785', '1677138157587517441', 'Centos系统项目部署', NULL, NULL, NULL, NULL, NULL, NULL, '<h1>环境配置</h1>\n<h2>软硬件清单</h2>\n<table style=\"border-collapse: collapse; width: 100%;\" border=\"1\">\n<tbody>\n<tr>\n<td style=\"width: 24.7027%; text-align: center;\"><strong>序号</strong></td>\n<td style=\"width: 24.7027%; text-align: center;\"><strong>名称</strong></td>\n<td style=\"width: 24.7027%; text-align: center;\"><strong>版本</strong></td>\n<td style=\"width: 24.7027%; text-align: center;\"><strong>数量</strong></td>\n</tr>\n<tr>\n<td style=\"width: 24.7027%; text-align: center;\">1</td>\n<td style=\"width: 24.7027%; text-align: center;\">Jdk</td>\n<td style=\"width: 24.7027%; text-align: center;\">1.8</td>\n<td style=\"width: 24.7027%; text-align: center;\">1</td>\n</tr>\n<tr>\n<td style=\"width: 24.7027%; text-align: center;\">2</td>\n<td style=\"width: 24.7027%; text-align: center;\">Redis</td>\n<td style=\"width: 24.7027%; text-align: center;\">6.x</td>\n<td style=\"width: 24.7027%; text-align: center;\">1</td>\n</tr>\n<tr>\n<td style=\"width: 24.7027%; text-align: center;\">3</td>\n<td style=\"width: 24.7027%; text-align: center;\">MariaDB</td>\n<td style=\"width: 24.7027%; text-align: center;\">10.x</td>\n<td style=\"width: 24.7027%; text-align: center;\">1</td>\n</tr>\n</tbody>\n</table>\n<h2>&nbsp;</h2>\n<h2>JDK</h2>\n<ol>\n<li>查看yum包含的jdk版本\n<pre class=\"language-powershell\"><code>yum search java</code></pre>\n</li>\n<li>安装jdk，此次选择java-1.8.0-openjdk-devel.x86_64 : OpenJDK Development Environment\n<pre class=\"language-powershell\"><code>yum install java-1.8.0-openjdk-devel.x86_64</code></pre>\n</li>\n</ol>\n<h2>&nbsp;</h2>\n<h2>Redis</h2>\n<ol>\n<li>下载fedora的epel仓库\n<pre class=\"language-powershell\"><code>yum install epel-release</code></pre>\n</li>\n<li>安装\n<pre class=\"language-powershell\"><code>yum install redis</code></pre>\n</li>\n<li>设置密码\n<pre class=\"language-powershell\"><code># 打开Redis配置文件\nvi /etc/redis.conf\n# 找到requirepass，取消注释设置密码，如\nrequirepass Redis密码\n</code></pre>\n</li>\n<li>设置开机自启动\n<pre class=\"language-powershell\"><code>systemctl enable redis</code></pre>\n</li>\n</ol>\n<h2>&nbsp;</h2>\n<h2>MariaDB</h2>\n<ol>\n<li>安装\n<pre class=\"language-powershell\"><code>yum install -y mariadb-server</code></pre>\n</li>\n<li>制作系统服务\n<pre class=\"language-powershell\"><code>systemctl start mariadb  # 开启服务\nsystemctl enable mariadb  # 设置为开机自启动服务</code></pre>\n</li>\n<li>初始化配置\n<ol style=\"list-style-type: lower-alpha;\">\n<li>\n<p>首次安装需要进行数据库的配置</p>\n<pre class=\"language-powershell\"><code>mysql_secure_installation</code></pre>\n</li>\n<li>\n<p>配置时出现的各个选项以及建议的操作</p>\n<pre class=\"language-powershell\"><code>Enter current password for root (enter for none):  # 输入数据库超级管理员root的密码(注意不是系统root的密码)，第一次进入还没有设置密码则直接回车\n\nSet root password? [Y/n]  # 设置密码，y\n\nNew password:  # 新密码\nRe-enter new password:  # 再次输入密码\n\nRemove anonymous users? [Y/n]  # 移除匿名用户， y\n\nDisallow root login remotely? [Y/n]  # 拒绝root远程登录，n，不管y/n，都会拒绝root远程登录\n\nRemove test database and access to it? [Y/n]  # 删除test数据库，y：删除。n：不删除，数据库中会有一个test数据库，一般不需要\n\nReload privilege tables now? [Y/n]  # 重新加载权限表，y。</code></pre>\n</li>\n<li>测试是否能够登录成功，出现`MariaDB [(none)]&gt;`就表示已经能够正常登录使用MariaDB数据库了\n<pre class=\"language-powershell\"><code>mysql -u root -p\nEnter password:\nWelcome to the MariaDB monitor.  Commands end with ; or \\g.\nYour MariaDB connection id is 8\nServer version: 5.5.60-MariaDB MariaDB Server\n\nCopyright (c) 2000, 2018, Oracle, MariaDB Corporation Ab and others.\n\nType \'help;\' or \'\\h\' for help. Type \'\\c\' to clear the current input statement.\n\nMariaDB [(none)]&gt;</code></pre>\n</li>\n</ol>\n</li>\n<li>设置MariaDB字符集为utf-8\n<ol style=\"list-style-type: lower-alpha;\">\n<li>配置 <span style=\"color: #e67e23;\">/etc/my.cnf</span> 文件,在[mysqld]标签下添加如下内容\n<pre class=\"language-properties\"><code>init_connect=\'SET collation_connection = utf8_unicode_ci\'\ninit_connect=\'SET NAMES utf8\'\ncharacter-set-server=utf8\ncollation-server=utf8_unicode_ci\nskip-character-set-client-handshake\n# 大小写不敏感\nlower_case_table_names=1</code></pre>\n</li>\n<li>配置 <span style=\"color: #e67e23;\">/etc/my.cnf.d/client.cnf</span> 文件,在[client]标签下添加\n<pre class=\"language-properties\"><code>default-character-set=utf8</code></pre>\n</li>\n<li>配置 <span style=\"color: #e67e23;\">/etc/my.cnf.d/mysql-clients.cnf</span> 文件,在[mysql]标签下添加\n<pre class=\"language-properties\"><code>default-character-set=utf8</code></pre>\n</li>\n<li>重启服务\n<pre class=\"language-powershell\"><code>systemctl restart mariadb</code></pre>\n</li>\n</ol>\n</li>\n</ol>\n<h1>部署应用</h1>\n<h2>后端</h2>\n<ol>\n<li>上传 <span style=\"color: #e67e23;\">easy-api.jar </span>到到服务器 <span style=\"color: #e67e23;\">/home/soft/api/ </span>目录下</li>\n<li>上传配置文件 <span style=\"color: #e67e23;\">application.yml、application-prod.yml</span> 到服务器目录 <span style=\"color: #e67e23;\">/home/soft/api/config</span></li>\n<li>启动项目\n<pre class=\"language-powershell\"><code>nohup java -jar /home/soft/api/easy-api.jar --spring.config.location=/home/soft/api/config/ --spring.profiles.active=prod &gt; /home/soft/api/log/log.file 2&gt;&amp;1 &amp;</code></pre>\n</li>\n</ol>\n<h2>前端</h2>\n<ol>\n<li>打包\n<pre class=\"language-powershell\"><code>pnpm run build</code></pre>\n</li>\n<li>上传打包后的项目（dist）到 <span style=\"color: #e67e23;\">/home/soft/admin</span></li>\n</ol>\n<h2>配置Nginx</h2>\n<ol>\n<li>在服务器 <span style=\"color: #e67e23;\">/etc/nginx/conf.d/</span>&nbsp;目录下添加以下配置文件\n<ol style=\"list-style-type: lower-alpha;\">\n<li>api.conf\n<pre class=\"language-apache\"><code>server {\n    listen  80;\n    server_name api.sample.com;\n    charset utf-8;\n\n    location / {\n        proxy_set_header  X-Real-IP $remote_addr;\n        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;\n        proxy_set_header  Host $http_host;\n        proxy_set_header  X-NginX-Proxy true;\n        proxy_pass  http://127.0.0.1:8080/;\n    }\n}</code></pre>\n</li>\n<li>admin.conf\n<pre class=\"language-apache\"><code>server {\n    listen  80;\n    # gzip config\n    gzip on;\n    gzip_min_length 1k;\n    gzip_comp_level 9;\n    gzip_types text/plain application/javascript application/x-javascript text/css application/xml text/javascript application/x-httpd-php image/jpeg image/gif image/png;\n    gzip_vary on;\n    gzip_disable \"MSIE [1-6]\\.\";\n\n    root /home/soft/admin;\n\n    server_name admin.sample.com;\n    charset utf-8;\n    location / {\n        try_files $uri $uri/ /index.html;\n    }\n}</code></pre>\n</li>\n</ol>\n</li>\n<li>更新Nginx配置\n<pre class=\"language-powershell\"><code>nginx -t; nginx -s reload</code></pre>\n</li>\n</ol>', NULL, NULL, 'Centos,部署,Nginx', NULL, '系统管理员', '1', '2023-07-07 15:22:43', NULL, 0, NULL, NULL, NULL, NULL, '1', 29, '1', '2023-07-07 15:22:35', '1', '2023-07-10 17:24:03');
INSERT INTO `cms_article` (`id`, `site_id`, `column_id`, `title`, `title_font_family`, `title_color`, `title_font_weight`, `title_font_size`, `subtitle`, `excerpt`, `content`, `keyword`, `description`, `tags`, `source`, `author`, `release_type`, `release_date`, `offline_date`, `view_count`, `type`, `url`, `dept_id`, `order_no`, `status`, `version`, `create_user`, `create_date`, `edit_user`, `edit_date`) VALUES ('1677249450298429441', '1670632009719926785', '1671337766148923394', '工作流', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '系统管理员', '1', NULL, NULL, 0, NULL, NULL, NULL, NULL, '0', 0, '1', '2023-07-07 17:33:25', '1', '2023-07-07 17:33:25');
INSERT INTO `cms_article` (`id`, `site_id`, `column_id`, `title`, `title_font_family`, `title_color`, `title_font_weight`, `title_font_size`, `subtitle`, `excerpt`, `content`, `keyword`, `description`, `tags`, `source`, `author`, `release_type`, `release_date`, `offline_date`, `view_count`, `type`, `url`, `dept_id`, `order_no`, `status`, `version`, `create_user`, `create_date`, `edit_user`, `edit_date`) VALUES ('1677249969800728578', '1670632009719926785', '1671337766148923394', '定时任务', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '系统管理员', '1', NULL, NULL, 0, NULL, NULL, NULL, NULL, '0', 0, '1', '2023-07-07 17:35:29', '1', '2023-07-07 17:35:29');
INSERT INTO `cms_article` (`id`, `site_id`, `column_id`, `title`, `title_font_family`, `title_color`, `title_font_weight`, `title_font_size`, `subtitle`, `excerpt`, `content`, `keyword`, `description`, `tags`, `source`, `author`, `release_type`, `release_date`, `offline_date`, `view_count`, `type`, `url`, `dept_id`, `order_no`, `status`, `version`, `create_user`, `create_date`, `edit_user`, `edit_date`) VALUES ('1677250038742503425', '1670632009719926785', '1671337766148923394', '权限管理', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '系统管理员', '1', NULL, NULL, 0, NULL, NULL, NULL, NULL, '0', 0, '1', '2023-07-07 17:35:46', '1', '2023-07-07 17:35:46');
INSERT INTO `cms_article` (`id`, `site_id`, `column_id`, `title`, `title_font_family`, `title_color`, `title_font_weight`, `title_font_size`, `subtitle`, `excerpt`, `content`, `keyword`, `description`, `tags`, `source`, `author`, `release_type`, `release_date`, `offline_date`, `view_count`, `type`, `url`, `dept_id`, `order_no`, `status`, `version`, `create_user`, `create_date`, `edit_user`, `edit_date`) VALUES ('1677250093490753538', '1670632009719926785', '1671337766148923394', '字典管理', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '系统管理员', '1', NULL, NULL, 0, NULL, NULL, NULL, NULL, '0', 0, '1', '2023-07-07 17:35:59', '1', '2023-07-07 17:35:59');
INSERT INTO `cms_article` (`id`, `site_id`, `column_id`, `title`, `title_font_family`, `title_color`, `title_font_weight`, `title_font_size`, `subtitle`, `excerpt`, `content`, `keyword`, `description`, `tags`, `source`, `author`, `release_type`, `release_date`, `offline_date`, `view_count`, `type`, `url`, `dept_id`, `order_no`, `status`, `version`, `create_user`, `create_date`, `edit_user`, `edit_date`) VALUES ('1677250117532504066', '1670632009719926785', '1671337766148923394', '数据导入', NULL, NULL, NULL, NULL, NULL, NULL, '<html>\n <head></head>\n <body>\n  <p><img class=\"editor-media editor-image\" style=\"max-width: 100%;\" src=\"http://127.0.0.1:8888/static/easy-cms/formal/20231228/c7794104-05ed-40fe-8fff-94240bca610e.gif\" alt=\"2023-08-16 10.02.26.gif\" data-bucket-name=\"easy-cms\" data-object-name=\"formal/20231228/c7794104-05ed-40fe-8fff-94240bca610e.gif\"></p>\n </body>\n</html>', NULL, NULL, NULL, NULL, '系统管理员', '1', NULL, NULL, 0, NULL, NULL, NULL, NULL, '0', 5, '1', '2023-07-07 17:36:04', '1', '2023-12-28 14:32:47');
INSERT INTO `cms_article` (`id`, `site_id`, `column_id`, `title`, `title_font_family`, `title_color`, `title_font_weight`, `title_font_size`, `subtitle`, `excerpt`, `content`, `keyword`, `description`, `tags`, `source`, `author`, `release_type`, `release_date`, `offline_date`, `view_count`, `type`, `url`, `dept_id`, `order_no`, `status`, `version`, `create_user`, `create_date`, `edit_user`, `edit_date`) VALUES ('1677250263016132609', '1670632009719926785', '1671337766148923394', '异常日志', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '系统管理员', '1', NULL, NULL, 0, NULL, NULL, NULL, NULL, '0', 0, '1', '2023-07-07 17:36:39', '1', '2023-07-07 17:36:39');
INSERT INTO `cms_article` (`id`, `site_id`, `column_id`, `title`, `title_font_family`, `title_color`, `title_font_weight`, `title_font_size`, `subtitle`, `excerpt`, `content`, `keyword`, `description`, `tags`, `source`, `author`, `release_type`, `release_date`, `offline_date`, `view_count`, `type`, `url`, `dept_id`, `order_no`, `status`, `version`, `create_user`, `create_date`, `edit_user`, `edit_date`) VALUES ('1678223918294487041', '1670632009719926785', '1677138157587517441', '代码生成', NULL, NULL, NULL, NULL, NULL, NULL, '<h1>简介</h1>\n<p>为方便快捷开发，我们基于Mybatis Plus代码生成实现了更适用于本项目的生成工具，包含自定义模版、自定义生成文件与方法、导入导出、添加菜单、可视化拖动等功能。</p>\n<p>&nbsp;</p>\n<h1>默认字段</h1>\n<p>为了满足代码生成中的部分功能，在生成策略中我们默认了一些字段，如有特殊需求可自行调整，字段如下：</p>\n<table class=\"table table-striped table-hover table-bordered\" style=\"width: 100%;\">\n<tbody>\n<tr>\n<td style=\"text-align: center;\"><strong>序号</strong></td>\n<td style=\"text-align: center;\"><strong>字段</strong></td>\n<td style=\"text-align: center;\"><strong>类型</strong></td>\n<td style=\"text-align: center;\"><strong>是否必须</strong></td>\n<td><strong>说明</strong></td>\n</tr>\n<tr>\n<td style=\"text-align: center;\">1</td>\n<td style=\"text-align: center;\">id</td>\n<td style=\"text-align: center;\">varchar(32)</td>\n<td style=\"text-align: center;\">是</td>\n<td>主键</td>\n</tr>\n<tr>\n<td style=\"text-align: center;\">2</td>\n<td style=\"text-align: center;\">parent_id</td>\n<td style=\"text-align: center;\">varchar(32)</td>\n<td style=\"text-align: center;\">否</td>\n<td>父Id，当生成树表格时必须</td>\n</tr>\n<tr>\n<td style=\"text-align: center;\">3</td>\n<td style=\"text-align: center;\">order_no</td>\n<td style=\"text-align: center;\">int</td>\n<td style=\"text-align: center;\">否</td>\n<td>排序值，用于用户排序树节点顺序，当生成树表格时必须</td>\n</tr>\n<tr>\n<td style=\"text-align: center;\">4</td>\n<td style=\"text-align: center;\">version</td>\n<td style=\"text-align: center;\">int</td>\n<td style=\"text-align: center;\">否</td>\n<td>乐观锁</td>\n</tr>\n<tr>\n<td style=\"text-align: center;\">5</td>\n<td style=\"text-align: center;\">create_user</td>\n<td style=\"text-align: center;\">varchar(32)</td>\n<td style=\"text-align: center;\">否</td>\n<td>创建人</td>\n</tr>\n<tr>\n<td style=\"text-align: center;\">6</td>\n<td style=\"text-align: center;\">create_date</td>\n<td style=\"text-align: center;\">datetime</td>\n<td style=\"text-align: center;\">否</td>\n<td>创建时间</td>\n</tr>\n<tr>\n<td style=\"text-align: center;\">7</td>\n<td style=\"text-align: center;\">edit_user</td>\n<td style=\"text-align: center;\">varchar(32)</td>\n<td style=\"text-align: center;\">否</td>\n<td>编辑人</td>\n</tr>\n<tr>\n<td style=\"text-align: center;\">8</td>\n<td style=\"text-align: center;\">edit_date</td>\n<td style=\"text-align: center;\">datetime</td>\n<td style=\"text-align: center;\">否</td>\n<td>编辑时间</td>\n</tr>\n</tbody>\n</table>\n<p>&nbsp;</p>\n<h1>列表页表格字段</h1>\n<p>我们根据预设、字典、属性类型、字段长度等预设表格显示字段以及字段属性，规则如下：</p>\n<p><img class=\"editor-media editor-image\" style=\"max-width: 100%; display: block; margin-left: auto; margin-right: auto;\" src=\"http://localhost/static/formal/2023/7/10/449a5a50-aa51-4267-8936-ddb8e4474c52.png\" alt=\"表格.drawio.png\" /></p>\n<p>&nbsp;</p>\n<h1>列表页查询条件字段</h1>\n<p>我们根据预设、字段注释、字典、属性类型等预设查询条件所需的字段以及字段属性，规则如下：</p>\n<p><img class=\"editor-media editor-image\" style=\"max-width: 100%;\" src=\"http://localhost/static/formal/2023/7/10/44b456b0-f33b-4d93-9b30-cbe23d2e354a.png\" alt=\"查询条件.drawio.png\" /></p>\n<p>&nbsp;</p>\n<h1>生成模版</h1>\n<h2>列表模版</h2>\n<h3>表格-Table</h3>\n<p>适用于展示行列数据，支持排序、搜索、分页等操作。</p>\n<h3>树表格-TreeTable</h3>\n<p>适用于树形结构数据显示，支持搜索、展开、收起、拖动设置排序&amp;结构等操作。</p>\n<p>&nbsp;</p>\n<h2>表单模版</h2>\n<h3>对话框-Modal</h3>\n<p>适用于简单表单，1~8个字段</p>\n<p><img class=\"editor-media editor-image\" style=\"max-width: 520px; display: block; margin-left: auto; margin-right: auto;\" src=\"http://localhost/static/formal/2023/7/10/5e85be69-d624-4f7c-a7e0-0c506d4b14a2.png\" alt=\"modal.png\" /></p>\n<h3>抽屉 - Drawer</h3>\n<p>适用于常规表单，6个及以上字段</p>\n<p><img class=\"editor-media editor-image\" style=\"max-width: 520px; display: block; margin-left: auto; margin-right: auto;\" src=\"http://localhost/static/formal/2023/7/11/85f861b0-4e5e-4f60-b5e1-3478d4427e35.png\" alt=\"Drawer.png\" /></p>\n<h3>页面 - Page</h3>\n<p>适用于复杂表单，使用新标签页打开</p>\n<p><img class=\"editor-media editor-image\" style=\"max-width: 520px; display: block; margin-left: auto; margin-right: auto;\" src=\"http://localhost/static/formal/2023/7/10/9f55fc48-adb9-4dda-b3d7-34629ed38717.png\" alt=\"Page.png\" /></p>\n<h1>操作步骤</h1>\n<h2>基本信息</h2>\n<p>选择需要生成的方法、文件和表，将根据所选信息自动填充表单</p>\n<p><img class=\"editor-media editor-image\" style=\"max-width: 100%;\" src=\"http://localhost/static/formal/2023/7/10/7b632aac-390b-4368-9e69-c6a6074a7f5b.jpg\" alt=\"基本信息.jpg\" /></p>\n<h2>列表页面</h2>\n<p>更改查询条件与表格顺序</p>\n<p><img class=\"editor-media editor-image\" style=\"max-width: 100%;\" src=\"http://localhost/static/formal/2023/7/10/486283df-36fb-4f20-8705-5f3cbb4bdb8c.png\" alt=\"列表页面.png\" /></p>\n<p>设置查询条件字段</p>\n<p><img class=\"editor-media editor-image\" style=\"max-width: 100%;\" src=\"http://localhost/static/formal/2023/7/10/ab79fb23-6323-49ee-9396-23d42c6c595f.png\" alt=\"列表页面-查询条件配置.png\" /></p>\n<p>设置表格显示字段</p>\n<p><img class=\"editor-media editor-image\" style=\"max-width: 100%;\" src=\"http://localhost/static/formal/2023/7/10/3d90cfbc-9dd1-4f34-ad40-3af43f65dc4e.png\" alt=\"列表页面-表格配置.png\" /></p>\n<h2>详情页面</h2>\n<p>新增&amp;修改页面，可设置录入字段以及录入规则</p>\n<p><img class=\"editor-media editor-image\" style=\"max-width: 100%;\" src=\"http://localhost/static/formal/2023/7/10/8430cf9d-d552-46e5-b152-ced49809dea4.png\" alt=\"详情页面.png\" /></p>\n<h2>导入&amp;导出</h2>\n<p>导入：配置导入时需要导入的字段以及导入规则，如需调整可到 <span style=\"color: #e67e23;\">系统管理 &gt; 导入模版 </span>中修改</p>\n<p>导出：配置需要导出的字段</p>\n<p><img class=\"editor-media editor-image\" style=\"max-width: 100%;\" src=\"http://localhost/static/formal/2023/7/10/928a7235-da3d-4b2a-a656-2a62259a3944.png\" alt=\"导入导出.png\" /></p>\n<h2>完成</h2>\n<p>预览需要生成的文件列表</p>\n<p><img class=\"editor-media editor-image\" style=\"max-width: 100%;\" src=\"http://localhost/static/formal/2023/7/10/1194df31-ab21-4f18-86a7-08397dafd0bf.png\" alt=\"完成.png\" /></p>\n<p>&nbsp;</p>', NULL, NULL, '代码生成', NULL, '系统管理员', '1', '2023-07-10 10:05:43', NULL, 0, NULL, NULL, NULL, NULL, '1', 31, '1', '2023-07-10 10:05:37', '1', '2023-07-11 10:03:35');
COMMIT;

-- ----------------------------
-- Table structure for cms_column
-- ----------------------------
DROP TABLE IF EXISTS `cms_column`;
CREATE TABLE `cms_column` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父id',
  `site_id` varchar(32) NOT NULL COMMENT '站点id',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `slug` varchar(32) DEFAULT NULL COMMENT '别名',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `is_release` varchar(32) DEFAULT NULL COMMENT '是否可以发布文章',
  `cover_proportion_width` int(11) DEFAULT NULL COMMENT '封面比例-宽',
  `cover_proportion_height` int(11) DEFAULT NULL COMMENT '封面比例-宽',
  `description` varchar(900) DEFAULT NULL COMMENT '描述',
  `remarks` varchar(900) DEFAULT NULL COMMENT '备注',
  `order_no` int(11) DEFAULT NULL COMMENT '排序值',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `version` int(11) DEFAULT 0 COMMENT '乐观锁',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `cms_column_pk` (`site_id`,`slug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='栏目';

-- ----------------------------
-- Records of cms_column
-- ----------------------------
BEGIN;
INSERT INTO `cms_column` (`id`, `parent_id`, `site_id`, `name`, `slug`, `type`, `is_release`, `cover_proportion_width`, `cover_proportion_height`, `description`, `remarks`, `order_no`, `status`, `version`, `create_user`, `create_date`, `edit_user`, `edit_date`) VALUES ('1671337766148923394', NULL, '1670632009719926785', '内置功能', 'built-in', NULL, '1', NULL, NULL, NULL, NULL, 2, '1', 0, '1', '2023-06-21 10:02:32', '1', '2023-06-21 10:02:32');
INSERT INTO `cms_column` (`id`, `parent_id`, `site_id`, `name`, `slug`, `type`, `is_release`, `cover_proportion_width`, `cover_proportion_height`, `description`, `remarks`, `order_no`, `status`, `version`, `create_user`, `create_date`, `edit_user`, `edit_date`) VALUES ('1677138157587517441', NULL, '1670632009719926785', '使用教程', 'course', NULL, '1', NULL, NULL, NULL, NULL, 1, '1', 0, '1', '2023-07-07 10:11:11', '1', '2023-07-07 10:11:11');
INSERT INTO `cms_column` (`id`, `parent_id`, `site_id`, `name`, `slug`, `type`, `is_release`, `cover_proportion_width`, `cover_proportion_height`, `description`, `remarks`, `order_no`, `status`, `version`, `create_user`, `create_date`, `edit_user`, `edit_date`) VALUES ('1677138406649483266', NULL, '1670632009719926785', '更新日志', 'change-log', NULL, '1', NULL, NULL, NULL, NULL, 3, '1', 0, '1', '2023-07-07 10:12:11', '1', '2023-07-07 10:12:11');
COMMIT;

-- ----------------------------
-- Table structure for cms_column_user
-- ----------------------------
DROP TABLE IF EXISTS `cms_column_user`;
CREATE TABLE `cms_column_user` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `column_id` varchar(32) DEFAULT NULL COMMENT '栏目id',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户id',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='栏目用户权限';

-- ----------------------------
-- Records of cms_column_user
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for cms_feedback
-- ----------------------------
DROP TABLE IF EXISTS `cms_feedback`;
CREATE TABLE `cms_feedback` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `site_id` varchar(32) NOT NULL COMMENT '站点id',
  `nickname` varchar(32) NOT NULL COMMENT '昵称',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `phone_number` varchar(32) DEFAULT NULL COMMENT '手机号',
  `content` varchar(256) NOT NULL COMMENT '内容',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `version` int(11) DEFAULT 0 COMMENT '乐观锁',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='反馈';

-- ----------------------------
-- Records of cms_feedback
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for cms_media
-- ----------------------------
DROP TABLE IF EXISTS `cms_media`;
CREATE TABLE `cms_media` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `site_id` varchar(32) DEFAULT NULL COMMENT '站点id',
  `name` varchar(256) DEFAULT NULL COMMENT '名称',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `version` int(11) DEFAULT 0 COMMENT '乐观锁',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='媒体';

-- ----------------------------
-- Records of cms_media
-- ----------------------------
BEGIN;
INSERT INTO `cms_media` (`id`, `site_id`, `name`, `type`, `status`, `version`, `create_user`, `create_date`, `edit_user`, `edit_date`) VALUES ('1740259471332077569', '1670632009719926785', '2023-08-16 10.02.26.gif', 'image', NULL, 0, '1', '2023-12-28 14:32:45', '1', '2023-12-28 14:32:45');
INSERT INTO `cms_media` (`id`, `site_id`, `name`, `type`, `status`, `version`, `create_user`, `create_date`, `edit_user`, `edit_date`) VALUES ('1744184726193545218', '1670632009719926785', 'funny_lazy_cat-wallpaper-1680x1050.jpg', 'image', NULL, 0, '1', '2024-01-08 10:30:18', '1', '2024-01-08 10:30:18');
INSERT INTO `cms_media` (`id`, `site_id`, `name`, `type`, `status`, `version`, `create_user`, `create_date`, `edit_user`, `edit_date`) VALUES ('1744184744631705602', '1670632009719926785', 'best_beaches_in_the_world-wallpaper-1920x1200.jpg', 'image', NULL, 0, '1', '2024-01-08 10:30:23', '1', '2024-01-08 10:30:23');
COMMIT;

-- ----------------------------
-- Table structure for cms_page
-- ----------------------------
DROP TABLE IF EXISTS `cms_page`;
CREATE TABLE `cms_page` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `site_id` varchar(32) NOT NULL COMMENT '站点id',
  `title` varchar(128) NOT NULL COMMENT '标题',
  `subtitle` varchar(256) DEFAULT NULL COMMENT '副标题',
  `content` longtext DEFAULT NULL COMMENT '内容',
  `slug` varchar(32) NOT NULL COMMENT '别名',
  `template` varchar(128) NOT NULL COMMENT '模板',
  `status` varchar(32) NOT NULL COMMENT '状态',
  `version` int(11) DEFAULT 0 COMMENT '乐观锁',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='页面';

-- ----------------------------
-- Records of cms_page
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for cms_release
-- ----------------------------
DROP TABLE IF EXISTS `cms_release`;
CREATE TABLE `cms_release` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `site_id` varchar(32) NOT NULL COMMENT '站点id',
  `page_ids` tinytext DEFAULT NULL COMMENT '页面id',
  `column_ids` tinytext DEFAULT NULL COMMENT '栏目id',
  `release_article` varchar(1) NOT NULL COMMENT '是否发布栏目下文章',
  `total` int(11) NOT NULL DEFAULT 0 COMMENT '总任务',
  `done` int(11) NOT NULL DEFAULT 0 COMMENT '已完成数量',
  `fail` int(11) NOT NULL DEFAULT 0 COMMENT '发布失败数量',
  `release_date` datetime DEFAULT NULL COMMENT '发布时间',
  `end_date` varchar(32) DEFAULT NULL COMMENT '结束时间',
  `receipt` varchar(1024) DEFAULT NULL COMMENT '发布回执',
  `status` varchar(32) NOT NULL COMMENT '状态',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='发布';

-- ----------------------------
-- Records of cms_release
-- ----------------------------
BEGIN;
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('0dab43ef53ec4709bbf0a64bfb13d753', '1670632009719926785', 'index,search', '1677138157587517441,1671337766148923394,1677138406649483266', '1', 8, 5, 3, '2023-07-13 16:43:12', '2023-07-13 16:43:12.658', NULL, '2', '1', '2023-07-13 16:43:12');
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('0fcb2d541fab4b909b99702fae676b0c', '1670632009719926785', 'index,search', '1677138157587517441,1671337766148923394,1677138406649483266', '1', 8, 8, 0, '2023-07-13 17:17:29', '2023-07-13 17:17:29.951', NULL, '2', '1', '2023-07-13 17:17:29');
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('145990fcf9fd419f8c0f078bc77c1443', '1670632009719926785', 'index,search', '1677138157587517441,1671337766148923394,1677138406649483266', '1', 8, 1, 7, '2023-07-13 17:33:46', '2023-07-13 17:33:46.803', NULL, '2', '1', '2023-07-13 17:33:46');
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('19d1204fe34e4946b96633a70873cab6', '1670632009719926785', 'index,search', '1677138157587517441,1671337766148923394,1677138406649483266', '0', 5, 2, 3, '2023-07-13 16:30:55', '2023-07-13 16:30:55.782', NULL, '2', '1', '2023-07-13 16:30:55');
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('21a01497c2d14473a073fbff4c7ceadc', '1670632009719926785', 'index,search', '1677138157587517441,1671337766148923394,1677138406649483266', '0', 5, 5, 0, '2023-07-13 17:13:51', '2023-07-13 17:13:57.005', NULL, '2', '1', '2023-07-13 17:13:51');
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('33d321a051274efbbc4d49ef500be28d', '1670632009719926785', 'index,search', '1677138157587517441,1671337766148923394,1677138406649483266', '0', 5, 2, 3, '2023-07-13 16:22:47', '2023-07-13 16:22:48.78', NULL, '2', '1', '2023-07-13 16:22:47');
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('47abe9be724346d195c2d001b4d573fe', '1670632009719926785', 'index,search', '1677138157587517441,1671337766148923394,1677138406649483266', '1', 8, 8, 0, '2023-07-13 17:16:56', '2023-07-13 17:16:57.098', NULL, '2', '1', '2023-07-13 17:16:56');
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('49565a938d9a4b4885ba5fad700d3e30', '1670632009719926785', '', '1677138157587517441', '0', 1, 0, 1, '2023-07-13 17:11:46', '2023-07-13 17:12:19.284', NULL, '2', '1', '2023-07-13 17:11:46');
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('593b7dc523fe4465bf2d5c7cbe357c32', '1670632009719926785', 'index,search', '1677138157587517441,1671337766148923394,1677138406649483266', '0', 5, 2, 3, '2023-07-13 16:28:13', '2023-07-13 16:28:14.134', NULL, '2', '1', '2023-07-13 16:28:13');
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('62ae250bb5eb4250a85d245a3000da26', '1670632009719926785', 'index,search', '1677138157587517441,1671337766148923394,1677138406649483266', '0', 5, 2, 3, '2023-07-13 16:29:35', '2023-07-13 16:29:35.477', NULL, '2', '1', '2023-07-13 16:29:35');
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('6db5b7fcfb6b4ff78bad494cd7f9f9ff', '1670632009719926785', '', '1677138157587517441', '0', 1, 0, 1, '2023-07-13 17:12:25', '2023-07-13 17:13:33.602', NULL, '2', '1', '2023-07-13 17:12:25');
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('89354c3e898f480096f3ad0fa7614753', '1670632009719926785', '', '1671337766148923394', '0', 1, 0, 1, '2023-07-13 17:09:00', '2023-07-13 17:11:39.454', NULL, '2', '1', '2023-07-13 17:09:00');
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('a7e2e3cd8fdc49869d238d12043e5621', '1670632009719926785', 'index,search', '1677138157587517441,1671337766148923394,1677138406649483266', '0', 5, 2, 3, '2023-07-13 16:26:32', '2023-07-13 16:26:33.057', NULL, '2', '1', '2023-07-13 16:26:32');
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('aadf56315372474cb0603983a636229d', '1670632009719926785', 'index,search', '1677138157587517441,1671337766148923394,1677138406649483266', '1', 8, 5, 3, '2023-07-13 16:40:47', '2023-07-13 16:40:48.128', NULL, '2', '1', '2023-07-13 16:40:47');
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('afa05da939ae4e45bfeb36213ad13117', '1670632009719926785', 'index,search', '1677138157587517441,1671337766148923394,1677138406649483266', '1', 8, 5, 3, '2023-07-13 16:31:10', '2023-07-13 16:31:10.978', NULL, '2', '1', '2023-07-13 16:31:10');
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('b2ccfe73571947f0b5cedfba821e376b', '1670632009719926785', 'index,search', '1677138157587517441,1671337766148923394,1677138406649483266', '1', 8, 5, 3, '2023-07-13 16:39:38', '2023-07-13 16:39:38.76', NULL, '2', '1', '2023-07-13 16:39:38');
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('d33ad658382146b895f882ed646a06bb', '1670632009719926785', 'index,search', '1677138157587517441,1671337766148923394,1677138406649483266', '1', 8, 8, 0, '2023-07-13 17:35:57', '2023-07-13 17:35:57.775', NULL, '2', '1', '2023-07-13 17:35:57');
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('e29cbc6a632a4b348ba339c9c3fe3e6a', '1670632009719926785', 'index,search', '1677138157587517441,1671337766148923394,1677138406649483266', '1', 8, 5, 3, '2023-07-13 16:44:25', '2023-07-13 16:44:25.788', NULL, '2', '1', '2023-07-13 16:44:25');
INSERT INTO `cms_release` (`id`, `site_id`, `page_ids`, `column_ids`, `release_article`, `total`, `done`, `fail`, `release_date`, `end_date`, `receipt`, `status`, `create_user`, `create_date`) VALUES ('f9413269a1914b54ae9947ff0ed0db8e', '1670632009719926785', 'index,search', '1677138157587517441,1671337766148923394,1677138406649483266', '1', 8, 1, 7, '2023-07-13 17:19:11', '2023-07-13 17:19:11.804', NULL, '2', '1', '2023-07-13 17:19:11');
COMMIT;

-- ----------------------------
-- Table structure for cms_release_queue
-- ----------------------------
DROP TABLE IF EXISTS `cms_release_queue`;
CREATE TABLE `cms_release_queue` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `parent_id` varchar(32) NOT NULL COMMENT '列队id',
  `site_id` varchar(32) NOT NULL COMMENT '站点id',
  `type` varchar(32) NOT NULL COMMENT '类型',
  `data_id` varchar(32) NOT NULL COMMENT '数据id',
  `title` varchar(128) NOT NULL COMMENT '标题',
  `weight` int(11) NOT NULL COMMENT '权重',
  `receipt` varchar(1024) DEFAULT NULL COMMENT '发布回执',
  `duration` int(11) DEFAULT NULL COMMENT '耗时 毫秒',
  `status` varchar(32) NOT NULL COMMENT '发布状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='发布列队详情';

-- ----------------------------
-- Records of cms_release_queue
-- ----------------------------
BEGIN;
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679406001582837762', '33d321a051274efbbc4d49ef500be28d', '1670632009719926785', 'page', 'index', '首页', 0, NULL, 754, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679406001591226370', '33d321a051274efbbc4d49ef500be28d', '1670632009719926785', 'page', 'search', '搜索', 0, NULL, 1, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679406001591226371', '33d321a051274efbbc4d49ef500be28d', '1670632009719926785', 'column', '1671337766148923394', '内置功能', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 8, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679406001595420673', '33d321a051274efbbc4d49ef500be28d', '1670632009719926785', 'column', '1677138157587517441', '使用教程', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 2, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679406001595420674', '33d321a051274efbbc4d49ef500be28d', '1670632009719926785', 'column', '1677138406649483266', '更新日志', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 2, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679406945313820673', 'a7e2e3cd8fdc49869d238d12043e5621', '1670632009719926785', 'page', 'index', '首页', 0, NULL, 58, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679406945326403586', 'a7e2e3cd8fdc49869d238d12043e5621', '1670632009719926785', 'page', 'search', '搜索', 0, NULL, 0, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679406945326403587', 'a7e2e3cd8fdc49869d238d12043e5621', '1670632009719926785', 'column', '1671337766148923394', '内置功能', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 4, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679406945330597889', 'a7e2e3cd8fdc49869d238d12043e5621', '1670632009719926785', 'column', '1677138157587517441', '使用教程', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 2, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679406945330597890', 'a7e2e3cd8fdc49869d238d12043e5621', '1670632009719926785', 'column', '1677138406649483266', '更新日志', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 1, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679407369504755713', '593b7dc523fe4465bf2d5c7cbe357c32', '1670632009719926785', 'page', 'index', '首页', 0, NULL, 52, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679407369508950018', '593b7dc523fe4465bf2d5c7cbe357c32', '1670632009719926785', 'page', 'search', '搜索', 0, NULL, 0, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679407369508950019', '593b7dc523fe4465bf2d5c7cbe357c32', '1670632009719926785', 'column', '1671337766148923394', '内置功能', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 3, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679407369513144321', '593b7dc523fe4465bf2d5c7cbe357c32', '1670632009719926785', 'column', '1677138157587517441', '使用教程', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 3, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679407369513144322', '593b7dc523fe4465bf2d5c7cbe357c32', '1670632009719926785', 'column', '1677138406649483266', '更新日志', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 2, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679407710396813314', '62ae250bb5eb4250a85d245a3000da26', '1670632009719926785', 'page', 'index', '首页', 0, NULL, 43, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679407710405201921', '62ae250bb5eb4250a85d245a3000da26', '1670632009719926785', 'page', 'search', '搜索', 0, NULL, 0, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679407710405201922', '62ae250bb5eb4250a85d245a3000da26', '1670632009719926785', 'column', '1671337766148923394', '内置功能', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 1, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679407710409396225', '62ae250bb5eb4250a85d245a3000da26', '1670632009719926785', 'column', '1677138157587517441', '使用教程', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 1, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679407710409396226', '62ae250bb5eb4250a85d245a3000da26', '1670632009719926785', 'column', '1677138406649483266', '更新日志', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 1, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679408046645776385', '19d1204fe34e4946b96633a70873cab6', '1670632009719926785', 'page', 'index', '首页', 0, NULL, 49, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679408046662553602', '19d1204fe34e4946b96633a70873cab6', '1670632009719926785', 'page', 'search', '搜索', 0, NULL, 0, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679408046662553603', '19d1204fe34e4946b96633a70873cab6', '1670632009719926785', 'column', '1671337766148923394', '内置功能', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 4, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679408046670942210', '19d1204fe34e4946b96633a70873cab6', '1670632009719926785', 'column', '1677138157587517441', '使用教程', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 1, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679408046670942211', '19d1204fe34e4946b96633a70873cab6', '1670632009719926785', 'column', '1677138406649483266', '更新日志', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 2, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679408111502299138', 'afa05da939ae4e45bfeb36213ad13117', '1670632009719926785', 'page', 'index', '首页', 0, NULL, 66, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679408111502299139', 'afa05da939ae4e45bfeb36213ad13117', '1670632009719926785', 'page', 'search', '搜索', 0, NULL, 0, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679408111506493441', 'afa05da939ae4e45bfeb36213ad13117', '1670632009719926785', 'column', '1671337766148923394', '内置功能', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 1, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679408111506493442', 'afa05da939ae4e45bfeb36213ad13117', '1670632009719926785', 'column', '1677138157587517441', '使用教程', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 2, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679408111510687745', 'afa05da939ae4e45bfeb36213ad13117', '1670632009719926785', 'column', '1677138406649483266', '更新日志', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 2, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679408111514882049', 'afa05da939ae4e45bfeb36213ad13117', '1670632009719926785', 'article', '1677153536992989185', '外部化配置文件', 0, NULL, 133, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679408111519076354', 'afa05da939ae4e45bfeb36213ad13117', '1670632009719926785', 'article', '1677216524122836994', 'Centos系统项目部署', 0, NULL, 8, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679408111519076355', 'afa05da939ae4e45bfeb36213ad13117', '1670632009719926785', 'article', '1678223918294487041', '代码生成', 0, NULL, 6, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679410240103190529', 'b2ccfe73571947f0b5cedfba821e376b', '1670632009719926785', 'page', 'index', '首页', 0, NULL, 53, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679410240103190530', 'b2ccfe73571947f0b5cedfba821e376b', '1670632009719926785', 'page', 'search', '搜索', 0, NULL, 0, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679410240107384834', 'b2ccfe73571947f0b5cedfba821e376b', '1670632009719926785', 'column', '1671337766148923394', '内置功能', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 3, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679410240107384835', 'b2ccfe73571947f0b5cedfba821e376b', '1670632009719926785', 'column', '1677138157587517441', '使用教程', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 4, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679410240107384836', 'b2ccfe73571947f0b5cedfba821e376b', '1670632009719926785', 'column', '1677138406649483266', '更新日志', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 1, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679410240107384837', 'b2ccfe73571947f0b5cedfba821e376b', '1670632009719926785', 'article', '1677153536992989185', '外部化配置文件', 0, NULL, 29, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679410240111579137', 'b2ccfe73571947f0b5cedfba821e376b', '1670632009719926785', 'article', '1677216524122836994', 'Centos系统项目部署', 0, NULL, 15, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679410240111579138', 'b2ccfe73571947f0b5cedfba821e376b', '1670632009719926785', 'article', '1678223918294487041', '代码生成', 0, NULL, 22, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679410531284357121', 'aadf56315372474cb0603983a636229d', '1670632009719926785', 'page', 'index', '首页', 0, NULL, 56, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679410531284357122', 'aadf56315372474cb0603983a636229d', '1670632009719926785', 'page', 'search', '搜索', 0, NULL, 0, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679410531284357123', 'aadf56315372474cb0603983a636229d', '1670632009719926785', 'column', '1671337766148923394', '内置功能', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 1, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679410531288551425', 'aadf56315372474cb0603983a636229d', '1670632009719926785', 'column', '1677138157587517441', '使用教程', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 2, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679410531288551426', 'aadf56315372474cb0603983a636229d', '1670632009719926785', 'column', '1677138406649483266', '更新日志', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 2, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679410531288551427', 'aadf56315372474cb0603983a636229d', '1670632009719926785', 'article', '1677153536992989185', '外部化配置文件', 0, NULL, 13, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679410531292745729', 'aadf56315372474cb0603983a636229d', '1670632009719926785', 'article', '1677216524122836994', 'Centos系统项目部署', 0, NULL, 12, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679410531292745730', 'aadf56315372474cb0603983a636229d', '1670632009719926785', 'article', '1678223918294487041', '代码生成', 0, NULL, 13, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679411138221117441', '0dab43ef53ec4709bbf0a64bfb13d753', '1670632009719926785', 'page', 'index', '首页', 0, NULL, 38, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679411138225311745', '0dab43ef53ec4709bbf0a64bfb13d753', '1670632009719926785', 'page', 'search', '搜索', 0, NULL, 0, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679411138229506049', '0dab43ef53ec4709bbf0a64bfb13d753', '1670632009719926785', 'column', '1671337766148923394', '内置功能', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 2, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679411138229506050', '0dab43ef53ec4709bbf0a64bfb13d753', '1670632009719926785', 'column', '1677138157587517441', '使用教程', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 2, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679411138233700354', '0dab43ef53ec4709bbf0a64bfb13d753', '1670632009719926785', 'column', '1677138406649483266', '更新日志', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 1, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679411138233700355', '0dab43ef53ec4709bbf0a64bfb13d753', '1670632009719926785', 'article', '1677153536992989185', '外部化配置文件', 0, NULL, 15, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679411138237894658', '0dab43ef53ec4709bbf0a64bfb13d753', '1670632009719926785', 'article', '1677216524122836994', 'Centos系统项目部署', 0, NULL, 7, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679411138237894659', '0dab43ef53ec4709bbf0a64bfb13d753', '1670632009719926785', 'article', '1678223918294487041', '代码生成', 0, NULL, 6, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679411445210615810', 'e29cbc6a632a4b348ba339c9c3fe3e6a', '1670632009719926785', 'page', 'index', '首页', 0, NULL, 34, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679411445214810114', 'e29cbc6a632a4b348ba339c9c3fe3e6a', '1670632009719926785', 'page', 'search', '搜索', 0, NULL, 0, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679411445214810115', 'e29cbc6a632a4b348ba339c9c3fe3e6a', '1670632009719926785', 'column', '1671337766148923394', '内置功能', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 2, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679411445219004417', 'e29cbc6a632a4b348ba339c9c3fe3e6a', '1670632009719926785', 'column', '1677138157587517441', '使用教程', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 1, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679411445219004418', 'e29cbc6a632a4b348ba339c9c3fe3e6a', '1670632009719926785', 'column', '1677138406649483266', '更新日志', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 1, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679411445219004419', 'e29cbc6a632a4b348ba339c9c3fe3e6a', '1670632009719926785', 'article', '1677153536992989185', '外部化配置文件', 0, NULL, 6, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679411445219004420', 'e29cbc6a632a4b348ba339c9c3fe3e6a', '1670632009719926785', 'article', '1677216524122836994', 'Centos系统项目部署', 0, NULL, 8, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679411445223198721', 'e29cbc6a632a4b348ba339c9c3fe3e6a', '1670632009719926785', 'article', '1678223918294487041', '代码生成', 0, NULL, 13, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679417633042075650', '89354c3e898f480096f3ad0fa7614753', '1670632009719926785', 'column', '1671337766148923394', '内置功能', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 12, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679418326486355970', '49565a938d9a4b4885ba5fad700d3e30', '1670632009719926785', 'column', '1677138157587517441', '使用教程', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 4, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679418492517879809', '6db5b7fcfb6b4ff78bad494cd7f9f9ff', '1670632009719926785', 'column', '1677138157587517441', '使用教程', 0, 'Cannot invoke \"com.easy.admin.cms.model.CmsColumn.getSlug()\" because \"cmsColumn\" is null', 64939, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679418852372385793', '21a01497c2d14473a073fbff4c7ceadc', '1670632009719926785', 'page', 'index', '首页', 0, NULL, 515, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679418852376580097', '21a01497c2d14473a073fbff4c7ceadc', '1670632009719926785', 'page', 'search', '搜索', 0, NULL, 0, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679418852376580098', '21a01497c2d14473a073fbff4c7ceadc', '1670632009719926785', 'column', '1671337766148923394', '内置功能', 0, NULL, 4638, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679418852376580099', '21a01497c2d14473a073fbff4c7ceadc', '1670632009719926785', 'column', '1677138157587517441', '使用教程', 0, NULL, 11, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679418852376580100', '21a01497c2d14473a073fbff4c7ceadc', '1670632009719926785', 'column', '1677138406649483266', '更新日志', 0, NULL, 8, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679419628759027714', '47abe9be724346d195c2d001b4d573fe', '1670632009719926785', 'page', 'index', '首页', 0, NULL, 47, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679419628767416321', '47abe9be724346d195c2d001b4d573fe', '1670632009719926785', 'page', 'search', '搜索', 0, NULL, 1, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679419628767416322', '47abe9be724346d195c2d001b4d573fe', '1670632009719926785', 'column', '1671337766148923394', '内置功能', 0, NULL, 6, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679419628767416323', '47abe9be724346d195c2d001b4d573fe', '1670632009719926785', 'column', '1677138157587517441', '使用教程', 0, NULL, 8, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679419628767416324', '47abe9be724346d195c2d001b4d573fe', '1670632009719926785', 'column', '1677138406649483266', '更新日志', 0, NULL, 4, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679419628767416325', '47abe9be724346d195c2d001b4d573fe', '1670632009719926785', 'article', '1677153536992989185', '外部化配置文件', 0, NULL, 66, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679419628767416326', '47abe9be724346d195c2d001b4d573fe', '1670632009719926785', 'article', '1677216524122836994', 'Centos系统项目部署', 0, NULL, 10, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679419628775804929', '47abe9be724346d195c2d001b4d573fe', '1670632009719926785', 'article', '1678223918294487041', '代码生成', 0, NULL, 10, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679419767452078081', '0fcb2d541fab4b909b99702fae676b0c', '1670632009719926785', 'page', 'index', '首页', 0, NULL, 36, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679419767456272386', '0fcb2d541fab4b909b99702fae676b0c', '1670632009719926785', 'page', 'search', '搜索', 0, NULL, 0, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679419767456272387', '0fcb2d541fab4b909b99702fae676b0c', '1670632009719926785', 'column', '1671337766148923394', '内置功能', 0, NULL, 5, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679419767456272388', '0fcb2d541fab4b909b99702fae676b0c', '1670632009719926785', 'column', '1677138157587517441', '使用教程', 0, NULL, 5, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679419767460466689', '0fcb2d541fab4b909b99702fae676b0c', '1670632009719926785', 'column', '1677138406649483266', '更新日志', 0, NULL, 4, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679419767460466690', '0fcb2d541fab4b909b99702fae676b0c', '1670632009719926785', 'article', '1677153536992989185', '外部化配置文件', 0, NULL, 7, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679419767460466691', '0fcb2d541fab4b909b99702fae676b0c', '1670632009719926785', 'article', '1677216524122836994', 'Centos系统项目部署', 0, NULL, 7, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679419767464660994', '0fcb2d541fab4b909b99702fae676b0c', '1670632009719926785', 'article', '1678223918294487041', '代码生成', 0, NULL, 6, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679420194067320834', 'f9413269a1914b54ae9947ff0ed0db8e', '1670632009719926785', 'page', 'index', '首页', 0, '>>变量未定义(VAR_NOT_DEFINED):keyword 位于8行 资源:easy-vben/./common/header/header.html5|\n6|<meta charset=\"utf-8\">\n7|<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n8|<meta name=\"keywords\" content=\"${keyword}\">\n9|<meta name=\"description\" content=\"${description}\">\n10|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/open-iconic-bootstrap.min.css\">\n11|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/animate.css\">\n  ========================\n  调用栈:\n  easy-vben/./common/header/header.html 行：8\n  easy-vben/index.html 行：1\n', 22, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679420194067320835', 'f9413269a1914b54ae9947ff0ed0db8e', '1670632009719926785', 'page', 'search', '搜索', 0, NULL, 0, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679420194067320836', 'f9413269a1914b54ae9947ff0ed0db8e', '1670632009719926785', 'column', '1671337766148923394', '内置功能', 0, '>>变量未定义(VAR_NOT_DEFINED):keyword 位于8行 资源:easy-vben/column/../common/header/header.html5|\n6|<meta charset=\"utf-8\">\n7|<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n8|<meta name=\"keywords\" content=\"${keyword}\">\n9|<meta name=\"description\" content=\"${description}\">\n10|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/open-iconic-bootstrap.min.css\">\n11|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/animate.css\">\n  ========================\n  调用栈:\n  easy-vben/column/../common/header/header.html 行：8\n  easy-vben/column/column.html 行：1\n', 7, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679420194067320837', 'f9413269a1914b54ae9947ff0ed0db8e', '1670632009719926785', 'column', '1677138157587517441', '使用教程', 0, '>>变量未定义(VAR_NOT_DEFINED):keyword 位于8行 资源:easy-vben/column/../common/header/header.html5|\n6|<meta charset=\"utf-8\">\n7|<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n8|<meta name=\"keywords\" content=\"${keyword}\">\n9|<meta name=\"description\" content=\"${description}\">\n10|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/open-iconic-bootstrap.min.css\">\n11|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/animate.css\">\n  ========================\n  调用栈:\n  easy-vben/column/../common/header/header.html 行：8\n  easy-vben/column/column.html 行：1\n', 6, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679420194071515138', 'f9413269a1914b54ae9947ff0ed0db8e', '1670632009719926785', 'column', '1677138406649483266', '更新日志', 0, '>>变量未定义(VAR_NOT_DEFINED):keyword 位于8行 资源:easy-vben/column/../common/header/header.html5|\n6|<meta charset=\"utf-8\">\n7|<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n8|<meta name=\"keywords\" content=\"${keyword}\">\n9|<meta name=\"description\" content=\"${description}\">\n10|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/open-iconic-bootstrap.min.css\">\n11|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/animate.css\">\n  ========================\n  调用栈:\n  easy-vben/column/../common/header/header.html 行：8\n  easy-vben/column/column.html 行：1\n', 5, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679420194071515139', 'f9413269a1914b54ae9947ff0ed0db8e', '1670632009719926785', 'article', '1677153536992989185', '外部化配置文件', 0, '>>变量未定义(VAR_NOT_DEFINED):keyword 位于8行 资源:easy-vben/article/../common/header/header.html5|\n6|<meta charset=\"utf-8\">\n7|<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n8|<meta name=\"keywords\" content=\"${keyword}\">\n9|<meta name=\"description\" content=\"${description}\">\n10|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/open-iconic-bootstrap.min.css\">\n11|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/animate.css\">\n  ========================\n  调用栈:\n  easy-vben/article/../common/header/header.html 行：8\n  easy-vben/article/article.html 行：1\n', 14, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679420194071515140', 'f9413269a1914b54ae9947ff0ed0db8e', '1670632009719926785', 'article', '1677216524122836994', 'Centos系统项目部署', 0, '>>变量未定义(VAR_NOT_DEFINED):keyword 位于8行 资源:easy-vben/article/../common/header/header.html5|\n6|<meta charset=\"utf-8\">\n7|<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n8|<meta name=\"keywords\" content=\"${keyword}\">\n9|<meta name=\"description\" content=\"${description}\">\n10|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/open-iconic-bootstrap.min.css\">\n11|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/animate.css\">\n  ========================\n  调用栈:\n  easy-vben/article/../common/header/header.html 行：8\n  easy-vben/article/article.html 行：1\n', 9, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679420194071515141', 'f9413269a1914b54ae9947ff0ed0db8e', '1670632009719926785', 'article', '1678223918294487041', '代码生成', 0, '>>变量未定义(VAR_NOT_DEFINED):keyword 位于8行 资源:easy-vben/article/../common/header/header.html5|\n6|<meta charset=\"utf-8\">\n7|<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n8|<meta name=\"keywords\" content=\"${keyword}\">\n9|<meta name=\"description\" content=\"${description}\">\n10|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/open-iconic-bootstrap.min.css\">\n11|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/animate.css\">\n  ========================\n  调用栈:\n  easy-vben/article/../common/header/header.html 行：8\n  easy-vben/article/article.html 行：1\n', 6, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679423864032989186', '145990fcf9fd419f8c0f078bc77c1443', '1670632009719926785', 'page', 'index', '首页', 0, '>>变量未定义(VAR_NOT_DEFINED):description 位于9行 资源:easy-vben/./common/header/header.html6|<meta charset=\"utf-8\">\n7|<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n8|<meta name=\"keywords\" content=\"${keywords}\">\n9|<meta name=\"description\" content=\"${description}\">\n10|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/open-iconic-bootstrap.min.css\">\n11|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/animate.css\">\n  ========================\n  调用栈:\n  easy-vben/./common/header/header.html 行：9\n  easy-vben/index.html 行：1\n', 19, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679423864032989187', '145990fcf9fd419f8c0f078bc77c1443', '1670632009719926785', 'page', 'search', '搜索', 0, NULL, 2, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679423864037183490', '145990fcf9fd419f8c0f078bc77c1443', '1670632009719926785', 'column', '1671337766148923394', '内置功能', 0, '>>变量未定义(VAR_NOT_DEFINED):description 位于9行 资源:easy-vben/column/../common/header/header.html6|<meta charset=\"utf-8\">\n7|<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n8|<meta name=\"keywords\" content=\"${keywords}\">\n9|<meta name=\"description\" content=\"${description}\">\n10|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/open-iconic-bootstrap.min.css\">\n11|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/animate.css\">\n  ========================\n  调用栈:\n  easy-vben/column/../common/header/header.html 行：9\n  easy-vben/column/column.html 行：1\n', 13, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679423864041377793', '145990fcf9fd419f8c0f078bc77c1443', '1670632009719926785', 'column', '1677138157587517441', '使用教程', 0, '>>变量未定义(VAR_NOT_DEFINED):description 位于9行 资源:easy-vben/column/../common/header/header.html6|<meta charset=\"utf-8\">\n7|<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n8|<meta name=\"keywords\" content=\"${keywords}\">\n9|<meta name=\"description\" content=\"${description}\">\n10|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/open-iconic-bootstrap.min.css\">\n11|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/animate.css\">\n  ========================\n  调用栈:\n  easy-vben/column/../common/header/header.html 行：9\n  easy-vben/column/column.html 行：1\n', 3, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679423864045572098', '145990fcf9fd419f8c0f078bc77c1443', '1670632009719926785', 'column', '1677138406649483266', '更新日志', 0, '>>变量未定义(VAR_NOT_DEFINED):description 位于9行 资源:easy-vben/column/../common/header/header.html6|<meta charset=\"utf-8\">\n7|<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n8|<meta name=\"keywords\" content=\"${keywords}\">\n9|<meta name=\"description\" content=\"${description}\">\n10|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/open-iconic-bootstrap.min.css\">\n11|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/animate.css\">\n  ========================\n  调用栈:\n  easy-vben/column/../common/header/header.html 行：9\n  easy-vben/column/column.html 行：1\n', 5, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679423864045572099', '145990fcf9fd419f8c0f078bc77c1443', '1670632009719926785', 'article', '1677153536992989185', '外部化配置文件', 0, '>>变量未定义(VAR_NOT_DEFINED):description 位于9行 资源:easy-vben/article/../common/header/header.html6|<meta charset=\"utf-8\">\n7|<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n8|<meta name=\"keywords\" content=\"${keywords}\">\n9|<meta name=\"description\" content=\"${description}\">\n10|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/open-iconic-bootstrap.min.css\">\n11|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/animate.css\">\n  ========================\n  调用栈:\n  easy-vben/article/../common/header/header.html 行：9\n  easy-vben/article/article.html 行：1\n', 27, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679423864049766402', '145990fcf9fd419f8c0f078bc77c1443', '1670632009719926785', 'article', '1677216524122836994', 'Centos系统项目部署', 0, '>>变量未定义(VAR_NOT_DEFINED):description 位于9行 资源:easy-vben/article/../common/header/header.html6|<meta charset=\"utf-8\">\n7|<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n8|<meta name=\"keywords\" content=\"${keywords}\">\n9|<meta name=\"description\" content=\"${description}\">\n10|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/open-iconic-bootstrap.min.css\">\n11|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/animate.css\">\n  ========================\n  调用栈:\n  easy-vben/article/../common/header/header.html 行：9\n  easy-vben/article/article.html 行：1\n', 9, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679423864053960705', '145990fcf9fd419f8c0f078bc77c1443', '1670632009719926785', 'article', '1678223918294487041', '代码生成', 0, '>>变量未定义(VAR_NOT_DEFINED):description 位于9行 资源:easy-vben/article/../common/header/header.html6|<meta charset=\"utf-8\">\n7|<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n8|<meta name=\"keywords\" content=\"${keywords}\">\n9|<meta name=\"description\" content=\"${description}\">\n10|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/open-iconic-bootstrap.min.css\">\n11|<link rel=\"stylesheet\" href=\"${themeUrl}/assets/css/animate.css\">\n  ========================\n  调用栈:\n  easy-vben/article/../common/header/header.html 行：9\n  easy-vben/article/article.html 行：1\n', 8, '-2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679424414065627138', 'd33ad658382146b895f882ed646a06bb', '1670632009719926785', 'page', 'index', '首页', 0, NULL, 34, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679424414069821442', 'd33ad658382146b895f882ed646a06bb', '1670632009719926785', 'page', 'search', '搜索', 0, NULL, 0, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679424414069821443', 'd33ad658382146b895f882ed646a06bb', '1670632009719926785', 'column', '1671337766148923394', '内置功能', 0, NULL, 6, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679424414069821444', 'd33ad658382146b895f882ed646a06bb', '1670632009719926785', 'column', '1677138157587517441', '使用教程', 0, NULL, 8, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679424414069821445', 'd33ad658382146b895f882ed646a06bb', '1670632009719926785', 'column', '1677138406649483266', '更新日志', 0, NULL, 6, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679424414069821446', 'd33ad658382146b895f882ed646a06bb', '1670632009719926785', 'article', '1677153536992989185', '外部化配置文件', 0, NULL, 6, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679424414074015745', 'd33ad658382146b895f882ed646a06bb', '1670632009719926785', 'article', '1677216524122836994', 'Centos系统项目部署', 0, NULL, 6, '2');
INSERT INTO `cms_release_queue` (`id`, `parent_id`, `site_id`, `type`, `data_id`, `title`, `weight`, `receipt`, `duration`, `status`) VALUES ('1679424414074015746', 'd33ad658382146b895f882ed646a06bb', '1670632009719926785', 'article', '1678223918294487041', '代码生成', 0, NULL, 6, '2');
COMMIT;

-- ----------------------------
-- Table structure for cms_site
-- ----------------------------
DROP TABLE IF EXISTS `cms_site`;
CREATE TABLE `cms_site` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父id',
  `name` varchar(64) NOT NULL COMMENT '名称',
  `keyword` varchar(900) DEFAULT NULL COMMENT '关键字',
  `description` varchar(900) DEFAULT NULL COMMENT '描述',
  `domain_name` varchar(255) NOT NULL COMMENT '域名',
  `deployment_path` varchar(255) NOT NULL COMMENT '部署路径',
  `theme` varchar(32) DEFAULT NULL COMMENT '主题路径',
  `status` varchar(32) NOT NULL COMMENT '状态',
  `order_no` int(11) DEFAULT NULL COMMENT '排序值',
  `tenant_id` varchar(32) DEFAULT NULL COMMENT '租户Id',
  `version` int(11) DEFAULT 0 COMMENT '乐观锁',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='站点';

-- ----------------------------
-- Records of cms_site
-- ----------------------------
BEGIN;
INSERT INTO `cms_site` (`id`, `parent_id`, `name`, `keyword`, `description`, `domain_name`, `deployment_path`, `theme`, `status`, `order_no`, `tenant_id`, `version`, `create_user`, `create_date`, `edit_user`, `edit_date`) VALUES ('1670632009719926785', NULL, 'Easy Vben', 'Easy Vben Admin,Java,SpringBoot,vue,admin', 'Easy Vben是一个基于SpringBoot、Vue3.0、Vite、Ant-Design-Vue 、TypeScript的后台解决方案', 'http://127.0.0.1:8080', '/Users/tengchong/soft/tomcat/apache-tomcat-10.0.12/webapps/ROOT/', 'easy-vben', '1', 2, NULL, 3, '1', '2023-06-19 11:18:05', '1', '2023-07-05 16:24:08');
COMMIT;

-- ----------------------------
-- Table structure for cms_site_user
-- ----------------------------
DROP TABLE IF EXISTS `cms_site_user`;
CREATE TABLE `cms_site_user` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `site_id` varchar(32) DEFAULT NULL COMMENT '站点id',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户id',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='站点用户权限';

-- ----------------------------
-- Records of cms_site_user
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
