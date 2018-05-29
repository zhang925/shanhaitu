<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>问题标签关联表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="questionRelationTagController.do?save">
		<input id="id" name="id" type="hidden" value="${questionRelationTagPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">标签id:</label>
		      <input class="inputxt" id="tagId" name="tagId" ignore="ignore"   value="${questionRelationTagPage.tagId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">问题id:</label>
		      <input class="inputxt" id="questionId" name="questionId" ignore="ignore"   value="${questionRelationTagPage.questionId}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>