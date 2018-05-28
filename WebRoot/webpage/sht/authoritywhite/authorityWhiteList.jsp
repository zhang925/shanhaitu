<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
    <div region="center" style="padding:0px;border:0px">
        <t:datagrid name="authorityWhiteList" title="请求过滤白名单" actionUrl="authorityWhiteController.do?datagrid" idField="id" fit="true">
            <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
            <t:dgCol title="可以免过滤的请求地址" field="authorityUri"   width="120"></t:dgCol>
            <t:dgCol title="创建时间" field="createTime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
            <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
            <t:dgDelOpt title="删除" url="authorityWhiteController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
            <t:dgToolBar title="录入" icon="icon-add" url="authorityWhiteController.do?addorupdate" funname="add"></t:dgToolBar>
            <t:dgToolBar title="编辑" icon="icon-edit" url="authorityWhiteController.do?addorupdate" funname="update"></t:dgToolBar>
            <t:dgToolBar title="查看" icon="icon-search" url="authorityWhiteController.do?addorupdate" funname="detail"></t:dgToolBar>
        </t:datagrid>
    </div>
</div>