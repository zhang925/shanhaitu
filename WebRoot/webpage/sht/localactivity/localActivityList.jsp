<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="localActivityList" title="本地活动" actionUrl="localActivityController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" ></t:dgCol>
   <t:dgCol title="时间" field="time" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="地点" field="address"   width="120"></t:dgCol>
   <t:dgCol title="目的" field="aim"   width="120"></t:dgCol>
   <t:dgCol title="形式" field="form"   width="120"></t:dgCol>
   <t:dgCol title="peopleNum" field="peopleNum"   width="120"></t:dgCol>
   <t:dgCol title="参加对象" field="participatePeople"   width="120"></t:dgCol>
   <t:dgCol title="状态" field="status"   width="120"></t:dgCol>
   <t:dgCol title="会议议程" field="agenda"   width="120"></t:dgCol>
   <t:dgCol title="是否允许发言" field="allowShare"   width="120"></t:dgCol>
   <t:dgCol title="嘉宾介绍" field="guestIntroduce"   width="120"></t:dgCol>
   <t:dgCol title="合作商机" field="cooperOpportunity"   width="120"></t:dgCol>
   <t:dgCol title="活动报道链接" field="articalUrl"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="localActivityController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="localActivityController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="localActivityController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="localActivityController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>