<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="translatorInfoList" title="翻译人员信息" actionUrl="translatorInfoController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="姓名" field="name"   width="120"></t:dgCol>
   <t:dgCol title="性别" field="sex"   width="120"></t:dgCol>
   <t:dgCol title="地址" field="address"   width="120"></t:dgCol>
   <t:dgCol title="身份证号" field="identityId"   width="120"></t:dgCol>
   <t:dgCol title="电话1" field="phone1"   width="120"></t:dgCol>
   <t:dgCol title="电话2" field="phone2"   width="120"></t:dgCol>
   <t:dgCol title="邮箱" field="email"   width="120"></t:dgCol>
   <t:dgCol title="一种交流工具whatsapp" field="whatsapp"   width="120"></t:dgCol>
   <t:dgCol title="微信" field="wechat"   width="120"></t:dgCol>
   <t:dgCol title="头像地址" field="pictureUrl"   width="120"></t:dgCol>
   <t:dgCol title="学校" field="college"   width="120"></t:dgCol>
   <t:dgCol title="学历" field="educationBg"   width="120"></t:dgCol>
   <t:dgCol title="工作年限" field="workYears"   width="120"></t:dgCol>
   <t:dgCol title="工作经历" field="workExper"   width="120"></t:dgCol>
   <t:dgCol title="中文水平" field="chineseLevel"   width="120"></t:dgCol>
   <t:dgCol title="印度语水平" field="indonesianLevel"   width="120"></t:dgCol>
   <t:dgCol title="英语水平" field="englishLevel"   width="120"></t:dgCol>
   <t:dgCol title="其他语言" field="otherLang"   width="120"></t:dgCol>
   <t:dgCol title="评定等级" field="ratings"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="translatorInfoController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="translatorInfoController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="translatorInfoController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="translatorInfoController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>