<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>活动图集</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body  >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="activityPicturesController.do?save">
		<input id="id" name="id" type="hidden" value="${activityPicturesPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">活动id:</label>
		      <input class="inputxt" id="activityId" name="activityId" ignore="ignore"   value="${activityPicturesPage.activityId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">文件名字:</label>
		      <input class="inputxt" id="name" name="name" ignore="ignore"   value="${activityPicturesPage.name}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">路径:</label>
		      <input class="inputxt" id="pictureUrl" name="pictureUrl" ignore="ignore"   value="${activityPicturesPage.pictureUrl}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>