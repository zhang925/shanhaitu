<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="commentList" title="评论" actionUrl="commentController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="创建者ID" field="useId"   width="120"></t:dgCol>
   <t:dgCol title="创建者姓名" field="useName"   width="120"></t:dgCol>
   <t:dgCol title="服务ID" field="serviceId"   width="120"></t:dgCol>
   <t:dgCol title="印象ID" field="impressId"   width="120"></t:dgCol>
   <t:dgCol title="评论内容" field="content"   width="120"></t:dgCol>
   <t:dgCol title="订单ID" field="orderId"   width="120"></t:dgCol>
   <t:dgCol title="评分" field="score"   width="120"></t:dgCol>
   <t:dgCol title="创建时间" field="createdTime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="commentController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="commentController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="commentController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="commentController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>