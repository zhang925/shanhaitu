<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="questionTagList" title="问题标签表" actionUrl="questionTagController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="标签名字" field="tagName"   width="120"></t:dgCol>
   <t:dgCol title="问题分类ID" field="questionCategoryId"   width="120"></t:dgCol>
   <t:dgCol title="访问次数" field="visitCount"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="questionTagController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="questionTagController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="questionTagController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="questionTagController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>