<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="lawdocCatalogList" title="政策法规目录" actionUrl="lawdocCatalogController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id"  ></t:dgCol>
   <t:dgCol title="父级ID" field="parentId"   width="120"></t:dgCol>
   <t:dgCol title="标题" field="title"   width="120"></t:dgCol>
   <t:dgCol title="所属层级" field="level"   width="120"></t:dgCol>
   <t:dgCol title="是否有子节点" field="haveLeaf"   width="120"></t:dgCol>
   <t:dgCol title="排序" field="orders"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="lawdocCatalogController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="lawdocCatalogController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="lawdocCatalogController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="lawdocCatalogController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>