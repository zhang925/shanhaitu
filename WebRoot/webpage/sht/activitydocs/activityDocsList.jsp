<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="activityDocsList" title="活动资料" actionUrl="activityDocsController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" ></t:dgCol>
   <t:dgCol title="活动ID" field="activityId"   width="120"></t:dgCol>
   <t:dgCol title="资料路径" field="docUrl"   width="120"></t:dgCol>
   <t:dgCol title="名字" field="docName"   width="120"></t:dgCol>
   <t:dgCol title="分享嘉宾" field="shareBy"   width="120"></t:dgCol>
   <t:dgCol title="公司" field="company"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="activityDocsController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="activityDocsController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="activityDocsController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="activityDocsController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>