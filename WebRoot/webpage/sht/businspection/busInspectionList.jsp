<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="busInspectionList" title="商务考察" actionUrl="busInspectionController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="概要" field="summary"   width="120"></t:dgCol>
   <t:dgCol title="考察时间" field="period"   width="120"></t:dgCol>
   <t:dgCol title="团员人数" field="memCount"   width="120"></t:dgCol>
   <t:dgCol title="档期" field="departureDate"   width="120"></t:dgCol>
   <t:dgCol title="价格" field="price"   width="120"></t:dgCol>
   <t:dgCol title="价格单位" field="unit"   width="120"></t:dgCol>
   <t:dgCol title="活动说明" field="inspectDetail"   width="120"></t:dgCol>
   <t:dgCol title="行程安排" field="schedule"   width="120"></t:dgCol>
   <t:dgCol title="创建时间" field="createdTime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="状态" field="status"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="busInspectionController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="busInspectionController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="busInspectionController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" height="80%" url="busInspectionController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>