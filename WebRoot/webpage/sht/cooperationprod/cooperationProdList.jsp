<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="cooperationProdList" title="合作对接" actionUrl="cooperationProdController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id"></t:dgCol>
   <t:dgCol title="用户ID" field="userId"   width="120"></t:dgCol>
   <t:dgCol title="合作类型" field="coopType"   width="120"></t:dgCol>
   <t:dgCol title="标题" field="title"   width="120"></t:dgCol>
   <t:dgCol title="对接内容" field="content"   width="120"></t:dgCol>
   <t:dgCol title="联系人" field="linkman"   width="120"></t:dgCol>
   <t:dgCol title="联系人信息" field="contactInfo"   width="120"></t:dgCol>
   <t:dgCol title="时间" field="time" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="状态" field="status"   width="120"></t:dgCol>
   <t:dgCol title="排序" field="orders"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="cooperationProdController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="cooperationProdController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="cooperationProdController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="cooperationProdController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>