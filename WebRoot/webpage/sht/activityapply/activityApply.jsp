<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>活动报名</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body  >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="activityApplyController.do?save">
		<input id="id" name="id" type="hidden" value="${activityApplyPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">活动表ID:</label>
		      <input class="inputxt" id="activityId" name="activityId" ignore="ignore"   value="${activityApplyPage.activityId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">目的:</label>
		      <input class="inputxt" id="aim" name="aim" ignore="ignore"   value="${activityApplyPage.aim}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">是否允许发言:</label>
		      <input class="inputxt" id="needShare" name="needShare" ignore="ignore"   value="${activityApplyPage.needShare}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>