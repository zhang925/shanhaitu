<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>活动资料</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body  >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="activityDocsController.do?save">
		<input id="id" name="id" type="hidden" value="${activityDocsPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">活动ID:</label>
		      <input class="inputxt" id="activityId" name="activityId" ignore="ignore"   value="${activityDocsPage.activityId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">资料路径:</label>
		      <input class="inputxt" id="docUrl" name="docUrl" ignore="ignore"   value="${activityDocsPage.docUrl}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">名字:</label>
		      <input class="inputxt" id="docName" name="docName" ignore="ignore"   value="${activityDocsPage.docName}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">分享嘉宾:</label>
		      <input class="inputxt" id="shareBy" name="shareBy" ignore="ignore"   value="${activityDocsPage.shareBy}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">公司:</label>
		      <input class="inputxt" id="company" name="company" ignore="ignore"   value="${activityDocsPage.company}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>