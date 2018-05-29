-- -------------------------1 用户表表 -------------------------
-- 可以使用系统的  t_s_base_user
-- -------------------------2 用户登录关系表 -------------------------
-- 可以使用系统的 t_s_user

-- -------------------------3 商务考察表 -------------------------
DROP TABLE IF EXISTS `sht_bus_inspection`;
CREATE TABLE `sht_bus_inspection` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `summary` longtext  COMMENT '概要',
  `period` varchar(256)  COMMENT '考察时间',
  `mem_count` int(11)  COMMENT '团员人数',
  `departure_date` varchar(512)  COMMENT '档期',
  `price` float  COMMENT '价格',
  `unit` varchar(20)   COMMENT '价格单位',
  `inspect_detail` longtext COMMENT '活动说明',
  `schedule` longtext COMMENT '行程安排',
  `created_time` datetime  COMMENT '创建时间',
  `status` int(11)  COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ---------------- 4 调研报告表 -------------------------
DROP TABLE IF EXISTS `sht_investigate_report`;
CREATE TABLE `sht_investigate_report` (
  `id` varchar(32)  COMMENT 'id',
  `title` varchar(512)  COMMENT '摘要',
  `category_id` varchar(32)  COMMENT '分类ID',
  `delivery` varchar(32)  COMMENT '交付方式',
  `summary` longtext COMMENT '摘要',
  `price` float  COMMENT '价格',
  `unit` varchar(20)  COMMENT '价格单位',
  `total_page` int(11)  COMMENT '总页数',
  `attch_count` int(11)  COMMENT '附件数',
  `created_time` datetime  COMMENT '创建时间',
  `updated_time` datetime  COMMENT '更新时间',
  `format` varchar(100)  COMMENT '格式',
  `status` varchar(11)  COMMENT '状体',
  `order` varchar(11)  COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ---------------- 5 问题表 -------------------------
DROP TABLE IF EXISTS `sht_question`;
CREATE TABLE `sht_question` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `title` varchar(512)  COMMENT '标题',
  `summary` longtext COMMENT '概要',
  `content` longtext COMMENT '内容',
  `created_time` datetime COMMENT '创建时间',
  `visit_count` int(11)  COMMENT '访问量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ---------------- 6 问题标签表 -------------------------
DROP TABLE IF EXISTS `sht_question_tag`;
CREATE TABLE `sht_question_tag` (
  `id` varchar(32)  COMMENT 'id',
  `tag_name` varchar(512)  COMMENT '标签名字',
  `question_category_id` varchar(32)  COMMENT '问题分类ID',
  `visit_count` int(11)  COMMENT '访问次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ---------------- 7 问题分类表 -------------------------
DROP TABLE IF EXISTS `sht_question_category`;
CREATE TABLE `sht_question_category` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `category_name` varchar(512) DEFAULT NULL COMMENT '分类名字',
  `status` varchar(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ---------------- 8 问题标签关联表 -------------------------
DROP TABLE IF EXISTS `sht_question_relation_tag`;
CREATE TABLE `sht_question_relation_tag` (
  `id` varchar(32) NOT NULL,
  `tag_id` varchar(32) DEFAULT NULL COMMENT '标签id',
  `question_id` varchar(32) DEFAULT NULL COMMENT '问题id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------  9 文章新闻表 -------------------------
DROP TABLE IF EXISTS `sht_article_news`;
CREATE TABLE `sht_article_news` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT 'id',
  `title` varchar(512) COLLATE utf8_bin NOT NULL COMMENT '标题',
  `summary` longtext COLLATE utf8_bin COMMENT '概要',
  `content` longtext COLLATE utf8_bin COMMENT '内容',
  `author` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '作者',
  `creator_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建者ID',
  `editor_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '修改者ID',
  `creator` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '创建者名字',
  `editor` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '修改者名字',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `cate_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '分类ID',
  `status` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---------------- 10 热门文章表 -------------------------
DROP TABLE IF EXISTS `sht_hot_article`;
CREATE TABLE `sht_hot_article` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT 'id',
  `article_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '文章新闻ID',
  `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
  `closing_time` datetime DEFAULT NULL COMMENT '下架时间',
  `order` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '排序',
  `status` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '文章状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------11 文章访问渠道表 -------------------------
DROP TABLE IF EXISTS `sht_article_visit_relation`;
CREATE TABLE `sht_article_visit_relation` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT 'id',
  `article_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '文章ID',
  `visit_channel` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '访问渠道',
  `visit_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---------------- 12 文章分类表 -------------------------
DROP TABLE IF EXISTS `sht_arti_category`;
CREATE TABLE `sht_arti_category` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT 'id',
  `category_name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '分类名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------13 评论表 -------------------------
DROP TABLE IF EXISTS `sht_comment`;
CREATE TABLE `sht_comment` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT 'id',
  `use_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建者ID',
  `use_name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建者姓名',
  `service_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '服务ID',
  `impress_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '印象ID',
  `content` longtext COLLATE utf8_bin COMMENT '评论内容',
  `order_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '订单ID',
  `score` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '评分',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ---------------- 14 服务表 -------------------------
DROP TABLE IF EXISTS `sht_service`;
CREATE TABLE `sht_service` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT 'id',
  `bus_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '业务表ID',
  `serv_name` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '服务名字',
  `company` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '公司名',
  `location` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `serv_category_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '服务大类ID',
  `serv_category_name` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '服务大类名字',
  `bus_type_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '业务类型ID',
  `bus_type_name` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '业务类型名字',
  `icon_url` varchar(1500) COLLATE utf8_bin DEFAULT NULL COMMENT '服务缩略图url',
  `status` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '状态',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---------------- 15  服务大类表 -------------------------
DROP TABLE IF EXISTS `sht_serv_category`;
CREATE TABLE `sht_serv_category` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT 'id',
  `category_name` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '大类名称',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ---------------- 16  业务类型表 -------------------------
DROP TABLE IF EXISTS `sht_bus_type`;
CREATE TABLE `sht_bus_type` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT 'id',
  `type_name` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '业务类型名称',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
