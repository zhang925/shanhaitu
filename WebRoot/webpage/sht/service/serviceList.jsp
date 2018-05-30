<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="serviceList" title="服务" actionUrl="serviceController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="业务表ID" field="busId"   width="120"></t:dgCol>
   <t:dgCol title="服务名字" field="servName"   width="120"></t:dgCol>
   <t:dgCol title="公司名" field="company"   width="120"></t:dgCol>
   <t:dgCol title="地址" field="location"   width="120"></t:dgCol>
   <t:dgCol title="服务大类ID" field="servCategoryId"   width="120"></t:dgCol>
   <t:dgCol title="服务大类名字" field="servCategoryName"   width="120"></t:dgCol>
   <t:dgCol title="业务类型ID" field="busTypeId"   width="120"></t:dgCol>
   <t:dgCol title="业务类型名字" field="busTypeName"   width="120"></t:dgCol>
   <t:dgCol title="服务缩略图url" field="iconUrl"   width="120"></t:dgCol>
   <t:dgCol title="状态" field="status"   width="120"></t:dgCol>
   <t:dgCol title="创建时间" field="createdTime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="serviceController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="serviceController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="serviceController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="serviceController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>