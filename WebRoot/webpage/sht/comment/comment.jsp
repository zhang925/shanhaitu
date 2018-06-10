<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>评论</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body  >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="commentController.do?save">
		<input id="id" name="id" type="hidden" value="${commentPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">创建者ID:</label>
		      <input class="inputxt" id="useId" name="useId" ignore="ignore"   value="${commentPage.useId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">创建者姓名:</label>
		      <input class="inputxt" id="useName" name="useName" ignore="ignore"   value="${commentPage.useName}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">服务ID:</label>
		      <input class="inputxt" id="serviceId" name="serviceId" ignore="ignore"   value="${commentPage.serviceId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">印象ID:</label>
		      <input class="inputxt" id="impressId" name="impressId" ignore="ignore"   value="${commentPage.impressId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">评论内容:</label>
		      <input class="inputxt" id="content" name="content" ignore="ignore"   value="${commentPage.content}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">订单ID:</label>
		      <input class="inputxt" id="orderId" name="orderId" ignore="ignore"   value="${commentPage.orderId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">评分:</label>
		      <input class="inputxt" id="score" name="score" ignore="ignore"   value="${commentPage.score}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">创建时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="createdTime" name="createdTime" ignore="ignore"     value="<fmt:formatDate value='${commentPage.createdTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>