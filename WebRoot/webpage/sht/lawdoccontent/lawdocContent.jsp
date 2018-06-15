<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>政策法规内容</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body  >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="lawdocContentController.do?save">
		<input id="id" name="id" type="hidden" value="${lawdocContentPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">目录ID:</label>
		      <input class="inputxt" id="catalogtId" name="catalogtId" ignore="ignore"   value="${lawdocContentPage.catalogtId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">标题:</label>
		      <input class="inputxt" id="title" name="title" ignore="ignore"   value="${lawdocContentPage.title}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">内容:</label>
		      <input class="inputxt" id="content" name="content" ignore="ignore"   value="${lawdocContentPage.content}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>