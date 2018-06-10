<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>业务类型</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body  >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="busTypeController.do?save">
		<input id="id" name="id" type="hidden" value="${busTypePage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">业务类型名称:</label>
		      <input class="inputxt" id="typeName" name="typeName" ignore="ignore"   value="${busTypePage.typeName}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">创建时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="createdTime" name="createdTime" ignore="ignore"     value="<fmt:formatDate value='${busTypePage.createdTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>