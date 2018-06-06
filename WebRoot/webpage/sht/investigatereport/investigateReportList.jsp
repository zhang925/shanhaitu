<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="investigateReportList" title="调研报告" actionUrl="investigateReportController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="摘要" field="title"   width="120"></t:dgCol>
   <t:dgCol title="分类ID" field="categoryId"   width="120"></t:dgCol>
   <t:dgCol title="交付方式" field="delivery"   width="120"></t:dgCol>f
   <t:dgCol title="摘要" field="summary"   width="120"></t:dgCol>
   <t:dgCol title="价格" field="price"   width="120"></t:dgCol>
   <t:dgCol title="价格单位" field="unit"   width="120"></t:dgCol>
   <t:dgCol title="总页数" field="totalPage"   width="120"></t:dgCol>
   <t:dgCol title="附件数" field="attchCount"   width="120"></t:dgCol>
   <t:dgCol title="创建时间" field="createdTime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="更新时间" field="updatedTime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="格式" field="format"   width="120"></t:dgCol>
   <t:dgCol title=" 状态" field="status"   width="120"></t:dgCol>
   <t:dgCol title="排序" field="orders"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="investigateReportController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="investigateReportController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="investigateReportController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="investigateReportController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>