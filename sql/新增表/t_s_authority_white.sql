-- 请求免过滤表
-- DROP TABLE IF EXISTS `t_s_authority_white`;
CREATE TABLE `t_s_authority_white` (
  `ID` varchar(32) NOT NULL COMMENT 'id',
  `authority_uri` varchar(1000) DEFAULT NULL COMMENT '可以免过滤的请求地址',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

