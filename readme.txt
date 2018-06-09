1、项目采用 Spring SpringMVC  4.0.9 + Hibernate 4.1 + Mysql 5.7
    1.1、前端底层框架为easyui
    1.2、基础框架为jeecg，当前版本为 jeecg 3.7.1
    1.3、jeecg官方社区：http://www.jeecg.org/
2、管理员：
    2.1、管理员账号：admin
    2.2、密码：147258369
3、配置文件介绍：
    3.1、src 下的 dbconfig.properties 是配置数据库的
    3.2、支持MySql、SQL Server、Oracle其他种类的数据库，需要修改基础代码，这里不做介绍
    3.3、p3-cg-onfig.properties 是代码生成 时候路径等的配置
    3.4、3-cg-dbconfig.properties 是代码生成映射数据库的配置
    3.5、acer_main.jsp、hplus_main.jsp、main.jsp、shotcut_main.jsp的<%@include file="/context/layui.jsp"%>注释掉 就没有 聊天了
    3.6、hplus_main.jsp 修改，登陆后，后台主界面的信息
    3.7、jeecg-aceplus.png为首页的logo
    3.8、login.jsp 设置语言选项。等登陆的设计。
    3.9、WebRoot下的images的favicon.ico为HTML的标题图标
    3.10、org.jeecgframework.core.interceptors  AuthInterceptor 方法是 拦截没有登录的
    3.11、与项目有关的代码待在 com.sht 目录下
    3.12、controller 控制层 entity 实体 server 服务层
    3.13、与项目有关的后台管理界面在 WebRoot/webpage/sht 目录下
4、接口规范
    4.1 接口规范
        rest 接口规范 api/*
        {
            responsecode：xxx
            model：{

            }
        }
    4.2 项目 webservice 的拦截过滤器在com.jeecg.CORSFilter 类中，详情请看CORSFilter类。


