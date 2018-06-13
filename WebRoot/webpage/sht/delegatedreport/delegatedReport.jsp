<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>委托调研报告表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="delegatedReportController.do?save">
		<input id="id" name="id" type="hidden" value="${delegatedReportPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">概要:</label>
		      <input class="inputxt" id="content" name="content" ignore="ignore"   value="${delegatedReportPage.content}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">联系电话:</label>
		      <input class="inputxt" id="telphone" name="telphone" ignore="ignore"   value="${delegatedReportPage.telphone}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">邮箱:</label>
		      <input class="inputxt" id="email" name="email" ignore="ignore"   value="${delegatedReportPage.email}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">微信:</label>
		      <input class="inputxt" id="wechat" name="wechat" ignore="ignore"   value="${delegatedReportPage.wechat}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>