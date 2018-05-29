<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>商务考察</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="busInspectionController.do?save">
		<input id="id" name="id" type="hidden" value="${busInspectionPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">概要:</label>
		      <input class="inputxt" id="summary" name="summary" ignore="ignore"   value="${busInspectionPage.summary}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">考察时间:</label>
		      <input class="inputxt" id="period" name="period" ignore="ignore"   value="${busInspectionPage.period}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">团员人数:</label>
		      <input class="inputxt" id="memCount" name="memCount" ignore="ignore"   value="${busInspectionPage.memCount}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">档期:</label>
		      <input class="inputxt" id="departureDate" name="departureDate" ignore="ignore"   value="${busInspectionPage.departureDate}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">价格:</label>
		      <input class="inputxt" id="price" name="price" ignore="ignore"   value="${busInspectionPage.price}" datatype="d" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">价格单位:</label>
		      <input class="inputxt" id="unit" name="unit" ignore="ignore"   value="${busInspectionPage.unit}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">活动说明:</label>
		      <input class="inputxt" id="inspectDetail" name="inspectDetail" ignore="ignore"   value="${busInspectionPage.inspectDetail}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">行程安排:</label>
		      <input class="inputxt" id="schedule" name="schedule" ignore="ignore"   value="${busInspectionPage.schedule}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">创建时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="createdTime" name="createdTime" ignore="ignore"     value="<fmt:formatDate value='${busInspectionPage.createdTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">状态:</label>
		      <input class="inputxt" id="status" name="status" ignore="ignore"   value="${busInspectionPage.status}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>