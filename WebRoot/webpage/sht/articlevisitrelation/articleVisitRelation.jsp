<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>文章访问渠道</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="articleVisitRelationController.do?save">
		<input id="id" name="id" type="hidden" value="${articleVisitRelationPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">文章ID:</label>
		      <input class="inputxt" id="articleId" name="articleId" ignore="ignore"   value="${articleVisitRelationPage.articleId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">访问渠道:</label>
		      <input class="inputxt" id="visitChannel" name="visitChannel" ignore="ignore"   value="${articleVisitRelationPage.visitChannel}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">访问时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="visitTime" name="visitTime" ignore="ignore"     value="<fmt:formatDate value='${articleVisitRelationPage.visitTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>