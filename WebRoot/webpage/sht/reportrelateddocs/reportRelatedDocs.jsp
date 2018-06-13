<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>调研报告相关资料</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="reportRelatedDocsController.do?save">
		<input id="id" name="id" type="hidden" value="${reportRelatedDocsPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">调研报告ID:</label>
		      <input class="inputxt" id="investReportId" name="investReportId" ignore="ignore"   value="${reportRelatedDocsPage.investReportId}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">资料title:</label>
		      <input class="inputxt" id="title" name="title" ignore="ignore"   value="${reportRelatedDocsPage.title}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">文件格式:</label>
		      <input class="inputxt" id="format" name="format" ignore="ignore"   value="${reportRelatedDocsPage.format}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">资源路径:</label>
		      <input class="inputxt" id="url" name="url" ignore="ignore"   value="${reportRelatedDocsPage.url}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">状态:</label>
		      <input class="inputxt" id="status" name="status" ignore="ignore"   value="${reportRelatedDocsPage.status}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>