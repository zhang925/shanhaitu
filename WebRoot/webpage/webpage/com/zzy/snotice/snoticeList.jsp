<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="snoticeList" title="测试公告" queryMode="group" actionUrl="snoticeController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="标题" field="title" query="true"  width="120"></t:dgCol>
   <t:dgCol title="内容" field="content" query="true"   width="120"></t:dgCol>
   <t:dgCol title="通知公告类型" field="type" query="true"   width="120"></t:dgCol>
   <t:dgCol title="公开范围" field="level" query="true"   width="120"></t:dgCol>
   <t:dgCol title="链接地址" field="linkurl" query="true"  width="120"></t:dgCol>
   <t:dgCol title="有效日期" field="expirydate" query="true"  width="120"></t:dgCol>
   <t:dgCol title="创建者ID" hidden="true" field="createuserid"   width="120"></t:dgCol>
   <t:dgCol title="创建者名字" field="createusername" query="true" width="120"></t:dgCol>
   <t:dgCol title="创建时间" field="createtime" query="true"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="snoticeController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="snoticeController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="snoticeController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="snoticeController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>