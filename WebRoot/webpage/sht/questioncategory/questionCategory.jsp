<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>问题分类表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body  >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="questionCategoryController.do?save">
		<input id="id" name="id" type="hidden" value="${questionCategoryPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">分类名字:</label>
		      <input class="inputxt" id="categoryName" name="categoryName" ignore="ignore"   value="${questionCategoryPage.categoryName}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">状态:</label>
		      <input class="inputxt" id="status" name="status" ignore="ignore"   value="${questionCategoryPage.status}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>