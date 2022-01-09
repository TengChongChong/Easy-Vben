/*
 Navicat Premium Data Transfer

 Source Server         : 本地 - MySql
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 127.0.0.1:3306
 Source Schema         : easy-admin

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 24/12/2021 14:28:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cms_article
-- ----------------------------
DROP TABLE IF EXISTS `cms_article`;
CREATE TABLE `cms_article` (
  `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `site_id` varchar(60) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '站点id',
  `column_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '栏目id',
  `order_no` int(11) DEFAULT NULL COMMENT '排序值',
  `title` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标题',
  `title_font_family` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标题字体',
  `title_color` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标题颜色',
  `title_font_weight` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标题字重',
  `title_font_size` int(11) DEFAULT NULL COMMENT '标题文字大小',
  `subtitle` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '副标题',
  `content` longtext COLLATE utf8mb4_bin COMMENT '内容',
  `keyword` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '关键字',
  `description` varchar(1024) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `source` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '信息来源',
  `author` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '作者',
  `tags` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标签',
  `excerpt` varchar(1024) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '摘要',
  `release_type` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '发布方式 1.手动 2.定时',
  `release_date` datetime DEFAULT NULL COMMENT '发布时间',
  `offline_date` datetime DEFAULT NULL COMMENT '下线时间',
  `view_count` int(11) DEFAULT NULL COMMENT '浏览次数',
  `type` varchar(60) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '类型',
  `url` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '访问地址',
  `dept_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '部门id',
  `status` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `version` int(11) DEFAULT NULL COMMENT '乐观锁',
  `create_user` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='文章';

-- ----------------------------
-- Table structure for cms_column
-- ----------------------------
DROP TABLE IF EXISTS `cms_column`;
CREATE TABLE `cms_column` (
  `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `p_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '父id',
  `site_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '站点id',
  `name` varchar(60) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名称',
  `slug` varchar(60) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '别名',
  `type` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '类型',
  `is_release` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '是否可以发布文章',
  `cover_proportion_width` int(11) DEFAULT NULL COMMENT '封面比例-宽',
  `cover_proportion_height` int(11) DEFAULT NULL COMMENT '封面比例-高',
  `description` varchar(900) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `remarks` varchar(900) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `order_no` int(11) DEFAULT NULL COMMENT '排序值',
  `status` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `version` int(11) DEFAULT NULL COMMENT '乐观锁',
  `create_user` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `cms_column_site_id_slug_pk` (`site_id`,`slug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='栏目';

-- ----------------------------
-- Table structure for cms_column_user
-- ----------------------------
DROP TABLE IF EXISTS `cms_column_user`;
CREATE TABLE `cms_column_user` (
  `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `column_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '栏目id',
  `user_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户id',
  `create_user` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='栏目用户权限';

-- ----------------------------
-- Table structure for cms_media
-- ----------------------------
DROP TABLE IF EXISTS `cms_media`;
CREATE TABLE `cms_media` (
  `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `site_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '站点id',
  `name` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名称',
  `type` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '类型',
  `status` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `version` int(11) DEFAULT NULL COMMENT '乐观锁',
  `create_user` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='媒体';

-- ----------------------------
-- Table structure for cms_page
-- ----------------------------
DROP TABLE IF EXISTS `cms_page`;
CREATE TABLE `cms_page` (
  `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `site_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '站点id',
  `title` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标题',
  `slug` varchar(60) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '别名',
  `template` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '模板',
  `status` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `version` int(11) DEFAULT NULL COMMENT '乐观锁',
  `create_user` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='页面';

-- ----------------------------
-- Table structure for cms_release
-- ----------------------------
DROP TABLE IF EXISTS `cms_release`;
CREATE TABLE `cms_release` (
  `site_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `page_ids` text COLLATE utf8mb4_bin COMMENT '页面id',
  `column_ids` text COLLATE utf8mb4_bin COMMENT '栏目id',
  `release_article` varchar(1) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '是否发布栏目下文章',
  `status` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `total` bigint(20) DEFAULT NULL COMMENT '总任务',
  `done` bigint(20) DEFAULT NULL COMMENT '已完成数量',
  `fail` bigint(20) DEFAULT NULL COMMENT '发布失败数量',
  `release_date` datetime DEFAULT NULL COMMENT '发布时间',
  `end_date` datetime DEFAULT NULL COMMENT '结束时间',
  `receipt` varchar(1024) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '发布回执',
  `create_user` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `id` varchar(32) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='网站发布';

-- ----------------------------
-- Table structure for cms_release_queue
-- ----------------------------
DROP TABLE IF EXISTS `cms_release_queue`;
CREATE TABLE `cms_release_queue` (
  `id` varchar(32) COLLATE utf8mb4_bin NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标题',
  `type` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '类型',
  `site_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '站点id',
  `weight` int(11) DEFAULT NULL COMMENT '权重',
  `data_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '数据id',
  `status` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '发布状态',
  `receipt` varchar(1024) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '发布回执',
  `duration` int(11) DEFAULT NULL COMMENT '耗时 毫秒',
  `p_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '列队id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='发布列队详情';

-- ----------------------------
-- Table structure for cms_site
-- ----------------------------
DROP TABLE IF EXISTS `cms_site`;
CREATE TABLE `cms_site` (
  `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `p_id` varchar(60) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '父id',
  `name` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名称',
  `keywords` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '关键字',
  `description` varchar(1024) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `domain_name` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '域名',
  `deployment_path` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '部署路径',
  `theme` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '当前主题',
  `status` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `order_no` int(11) DEFAULT NULL COMMENT '排序值',
  `version` int(11) DEFAULT NULL COMMENT '乐观锁',
  `create_user` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_user` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新人',
  `edit_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='站点';

-- ----------------------------
-- Table structure for cms_site_user
-- ----------------------------
DROP TABLE IF EXISTS `cms_site_user`;
CREATE TABLE `cms_site_user` (
  `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `site_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '站点id',
  `user_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户id',
  `create_user` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='站点用户权限';

SET FOREIGN_KEY_CHECKS = 1;
