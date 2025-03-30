/*
 Navicat Premium Dump SQL

 Source Server         : MariaDB
 Source Server Type    : MariaDB
 Source Server Version : 110102 (11.1.2-MariaDB)
 Source Host           : localhost:3306
 Source Schema         : easy-vben

 Target Server Type    : MariaDB
 Target Server Version : 110102 (11.1.2-MariaDB)
 File Encoding         : 65001

 Date: 04/09/2024 16:35:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cms_article
-- ----------------------------
DROP TABLE IF EXISTS `cms_article`;
CREATE TABLE `cms_article` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `site_id` varchar(32) NOT NULL COMMENT '站点Id',
  `column_id` varchar(32) NOT NULL COMMENT '栏目Id',
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
  `order_no` int(11) DEFAULT NULL COMMENT '排序值',
  `status` varchar(32) NOT NULL COMMENT '状态',
  `version` int(11) NOT NULL DEFAULT 0 COMMENT '乐观锁',
  `dept_id` varchar(32) NOT NULL COMMENT '部门Id',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `edit_user` varchar(32) NOT NULL COMMENT '更新人',
  `edit_date` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='文章';

-- ----------------------------
-- Records of cms_article
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for cms_column
-- ----------------------------
DROP TABLE IF EXISTS `cms_column`;
CREATE TABLE `cms_column` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父Id',
  `site_id` varchar(32) NOT NULL COMMENT '站点Id',
  `name` varchar(32) NOT NULL COMMENT '名称',
  `slug` varchar(32) NOT NULL COMMENT '别名',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `is_release` varchar(32) NOT NULL COMMENT '是否可以发布文章',
  `cover_proportion_width` int(11) DEFAULT NULL COMMENT '封面比例-宽',
  `cover_proportion_height` int(11) DEFAULT NULL COMMENT '封面比例-宽',
  `description` varchar(900) DEFAULT NULL COMMENT '描述',
  `remarks` varchar(900) DEFAULT NULL COMMENT '备注',
  `order_no` int(11) DEFAULT NULL COMMENT '排序值',
  `status` varchar(32) NOT NULL COMMENT '状态',
  `version` int(11) NOT NULL DEFAULT 0 COMMENT '乐观锁',
  `dept_id` varchar(32) NOT NULL COMMENT '部门Id',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `edit_user` varchar(32) NOT NULL COMMENT '更新人',
  `edit_date` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='栏目';

-- ----------------------------
-- Records of cms_column
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for cms_column_user
-- ----------------------------
DROP TABLE IF EXISTS `cms_column_user`;
CREATE TABLE `cms_column_user` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `column_id` varchar(32) NOT NULL COMMENT '栏目id',
  `user_id` varchar(32) NOT NULL COMMENT '用户Id',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='栏目用户权限';

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
  `status` varchar(32) NOT NULL COMMENT '状态',
  `version` int(11) NOT NULL DEFAULT 0 COMMENT '乐观锁',
  `dept_id` varchar(32) DEFAULT NULL COMMENT '部门Id',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='反馈';

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
  `site_id` varchar(32) NOT NULL COMMENT '站点id',
  `name` varchar(256) NOT NULL COMMENT '名称',
  `type` varchar(32) NOT NULL COMMENT '类型',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `version` int(11) NOT NULL DEFAULT 0 COMMENT '乐观锁',
  `dept_id` varchar(32) NOT NULL COMMENT '部门Id',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `edit_user` varchar(32) NOT NULL COMMENT '更新人',
  `edit_date` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='资源';

-- ----------------------------
-- Records of cms_media
-- ----------------------------
BEGIN;
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
  `version` int(11) NOT NULL DEFAULT 0 COMMENT '乐观锁',
  `dept_id` varchar(32) NOT NULL COMMENT '部门Id',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `edit_user` varchar(32) NOT NULL COMMENT '更新人',
  `edit_date` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='页面';

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
  `dept_id` varchar(32) NOT NULL COMMENT '部门Id',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='发布';

-- ----------------------------
-- Records of cms_release
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for cms_release_queue
-- ----------------------------
DROP TABLE IF EXISTS `cms_release_queue`;
CREATE TABLE `cms_release_queue` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `parent_id` varchar(32) NOT NULL COMMENT '列队id',
  `site_id` varchar(32) NOT NULL COMMENT '站点Id',
  `type` varchar(32) NOT NULL COMMENT '类型',
  `data_id` varchar(32) NOT NULL COMMENT '数据Id',
  `title` varchar(128) NOT NULL COMMENT '标题',
  `weight` int(11) NOT NULL COMMENT '权重',
  `receipt` varchar(1024) DEFAULT NULL COMMENT '发布回执',
  `duration` int(11) DEFAULT NULL COMMENT '耗时 毫秒',
  `status` varchar(32) NOT NULL COMMENT '发布状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='发布列队详情';

-- ----------------------------
-- Records of cms_release_queue
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for cms_site
-- ----------------------------
DROP TABLE IF EXISTS `cms_site`;
CREATE TABLE `cms_site` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父Id',
  `name` varchar(64) NOT NULL COMMENT '名称',
  `keyword` varchar(900) DEFAULT NULL COMMENT '关键字',
  `description` varchar(900) DEFAULT NULL COMMENT '描述',
  `domain_name` varchar(255) NOT NULL COMMENT '域名',
  `deployment_path` varchar(255) NOT NULL COMMENT '部署路径',
  `theme` varchar(32) DEFAULT NULL COMMENT '主题路径',
  `status` varchar(32) NOT NULL COMMENT '状态',
  `order_no` int(11) DEFAULT NULL COMMENT '排序值',
  `tenant_id` varchar(32) DEFAULT NULL COMMENT '租户Id',
  `version` int(11) NOT NULL DEFAULT 0 COMMENT '乐观锁',
  `dept_id` varchar(32) DEFAULT NULL COMMENT '部门Id',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `edit_user` varchar(32) NOT NULL COMMENT '更新人',
  `edit_date` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='站点';

-- ----------------------------
-- Records of cms_site
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for cms_site_user
-- ----------------------------
DROP TABLE IF EXISTS `cms_site_user`;
CREATE TABLE `cms_site_user` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `site_id` varchar(32) NOT NULL COMMENT '站点id',
  `user_id` varchar(32) NOT NULL COMMENT '用户Id',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='站点用户权限';

-- ----------------------------
-- Records of cms_site_user
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
