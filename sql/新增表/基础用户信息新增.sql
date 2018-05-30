alter table t_s_user add dept varchar(256)  COMMENT '部门'; 

alter table t_s_user add duty varchar(256)  COMMENT '职位'; 

alter table t_s_user add  birth datetime COMMENT '生日'; 

alter table t_s_user add wechat varchar(256)  COMMENT '微信'; 

alter table t_s_user add facebook varchar(256)  COMMENT 'facebook'; 

alter table t_s_user add self_resource  longtext COMMENT '我的资源'; 

alter table t_s_user add need_resource  longtext COMMENT '需要的资源'; 

alter table t_s_user add company varchar(500)  COMMENT '公司'; 

alter table t_s_user add city varchar(200)  COMMENT '所在城市'; 

alter table t_s_user add com_desc  longtext COMMENT '公司描述'; 

alter table t_s_user add `level` varchar(32)  COMMENT '用户级别'; 


alter table t_s_user add `bn_type_id` varchar(32)  COMMENT '业务类型ID';


