<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>合作对接</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body  >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="cooperationProdController.do?save">
		<input id="id" name="id" type="hidden" value="${cooperationProdPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">用户ID:</label>
		      <input class="inputxt" id="userId" name="userId" ignore="ignore"   value="${cooperationProdPage.userId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">合作类型:</label>
		      <input class="inputxt" id="coopType" name="coopType" ignore="ignore"   value="${cooperationProdPage.coopType}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">标题:</label>
		      <input class="inputxt" id="title" name="title" ignore="ignore"   value="${cooperationProdPage.title}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">对接内容:</label>
		      <input class="inputxt" id="content" name="content" ignore="ignore"   value="${cooperationProdPage.content}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">联系人:</label>
		      <input class="inputxt" id="linkman" name="linkman" ignore="ignore"   value="${cooperationProdPage.linkman}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">联系人信息:</label>
		      <input class="inputxt" id="contactInfo" name="contactInfo" ignore="ignore"   value="${cooperationProdPage.contactInfo}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="time" name="time" ignore="ignore"     value="<fmt:formatDate value='${cooperationProdPage.time}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">状态:</label>
		      <input class="inputxt" id="status" name="status" ignore="ignore"   value="${cooperationProdPage.status}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">排序:</label>
		      <input class="inputxt" id="orders" name="orders" ignore="ignore"   value="${cooperationProdPage.orders}" datatype="d" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>