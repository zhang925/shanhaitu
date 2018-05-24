<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>经典语录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="classicController.do?save">
		<input id="id" name="id" type="hidden" value="${classicPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">uid:</label>
		      <input class="inputxt" id="uid" name="uid" ignore="ignore"   value="${classicPage.uid}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">title:</label>
		      <input class="inputxt" id="title" name="title" ignore="ignore"   value="${classicPage.title}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">content:</label>
		      <input class="inputxt" id="content" name="content" ignore="ignore"   value="${classicPage.content}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">createtime:</label>
		      <input class="inputxt" id="createtime" name="createtime" ignore="ignore"   value="${classicPage.createtime}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>