<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>精选文章</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="selectedArticlesController.do?save">
		<input id="id" name="id" type="hidden" value="${selectedArticlesPage.id }">
		<fieldset class="step">
			<div class="form">
				<label class="Validform_label">文章ID:</label>
				<input class="inputxt" id="articleId" name="articleId" ignore="ignore"   value="${selectedArticlesPage.articleId}" />
				<span class="Validform_checktip"></span>
			</div>

			<div class="form">
		      <label class="Validform_label">发布时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="publishTime" name="publishTime" ignore="ignore"     value="<fmt:formatDate value='${selectedArticlesPage.publishTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">下架时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="closingTime" name="closingTime" ignore="ignore"     value="<fmt:formatDate value='${selectedArticlesPage.closingTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">排序:</label>
		      <input class="inputxt" id="orders" name="orders" ignore="ignore"   value="${selectedArticlesPage.orders}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>