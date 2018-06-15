<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="activityApplyList" title="活动报名" actionUrl="activityApplyController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" ></t:dgCol>
   <t:dgCol title="活动表ID" field="activityId"   width="120"></t:dgCol>
   <t:dgCol title="目的" field="aim"   width="120"></t:dgCol>
   <t:dgCol title="是否允许发言" field="needShare"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="activityApplyController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="activityApplyController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="activityApplyController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="activityApplyController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>