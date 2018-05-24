<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>测试用</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="testBeanController.do?save">
		<input id="id" name="id" type="hidden" value="${testBeanPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">标题:</label>
		      <input class="inputxt" id="title" name="title" ignore="ignore"   value="${testBeanPage.title}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>