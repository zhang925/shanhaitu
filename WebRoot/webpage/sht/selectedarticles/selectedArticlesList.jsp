<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="selectedArticlesList" title="精选文章" actionUrl="selectedArticlesController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="发布时间" field="publishTime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="下架时间" field="closingTime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="排序" field="orders"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="selectedArticlesController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="selectedArticlesController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="selectedArticlesController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="selectedArticlesController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>