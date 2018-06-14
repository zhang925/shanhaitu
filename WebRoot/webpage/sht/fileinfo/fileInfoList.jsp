<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="fileInfoList" title="山海图文件信息" actionUrl="fileInfoController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" ></t:dgCol>
   <t:dgCol title="附件原始名称" field="fileOriginName"   width="120"></t:dgCol>
   <t:dgCol title="附件名称" field="fileName"   width="120"></t:dgCol>
   <t:dgCol title="附件大小" field="fileSize"   width="120"></t:dgCol>
   <t:dgCol title="附件大小的单位" field="fileSizeUnit"   width="120"></t:dgCol>
   <t:dgCol title="扩展名" field="extend"   width="120"></t:dgCol>
   <t:dgCol title="附件路径" field="realpath"   width="120"></t:dgCol>
   <t:dgCol title="用户ID" field="userid"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="用户名字" field="user"   width="120" ></t:dgCol>
   <t:dgCol title="对应模块" field="modular"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="实体类名字，一定要和实体照应" field="className" hidden="true"  width="120"></t:dgCol>
   <t:dgCol title="对应表的名字" field="tableName"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="对应数据的id" field="columnid"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="fileInfoController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="fileInfoController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="fileInfoController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="fileInfoController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>