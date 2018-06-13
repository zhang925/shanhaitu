<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>调研报告相关图集</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="reportRelatedImagesController.do?save">
		<input id="id" name="id" type="hidden" value="${reportRelatedImagesPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">调研报告ID:</label>
		      <input class="inputxt" id="investReportId" name="investReportId" ignore="ignore"   value="${reportRelatedImagesPage.investReportId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">图片描述:</label>
		      <input class="inputxt" id="summary" name="summary" ignore="ignore"   value="${reportRelatedImagesPage.summary}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">资源路径:</label>
		      <input class="inputxt" id="url" name="url" ignore="ignore"   value="${reportRelatedImagesPage.url}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">状态:</label>
		      <input class="inputxt" id="status" name="status" ignore="ignore"   value="${reportRelatedImagesPage.status}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>