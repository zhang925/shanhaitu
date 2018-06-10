<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>服务</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="serviceController.do?save">
		<input id="id" name="id" type="hidden" value="${servicePage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">业务表ID:</label>
		      <input class="inputxt" id="busId" name="busId" ignore="ignore"   value="${servicePage.busId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">服务名字:</label>
		      <input class="inputxt" id="servName" name="servName" ignore="ignore"   value="${servicePage.servName}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">公司名:</label>
		      <input class="inputxt" id="company" name="company" ignore="ignore"   value="${servicePage.company}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">地址:</label>
		      <input class="inputxt" id="location" name="location" ignore="ignore"   value="${servicePage.location}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">服务大类ID:</label>
		      <input class="inputxt" id="servCategoryId" name="servCategoryId" ignore="ignore"   value="${servicePage.servCategoryId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">服务大类名字:</label>
		      <input class="inputxt" id="servCategoryName" name="servCategoryName" ignore="ignore"   value="${servicePage.servCategoryName}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">业务类型ID:</label>
		      <input class="inputxt" id="busTypeId" name="busTypeId" ignore="ignore"   value="${servicePage.busTypeId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">业务类型名字:</label>
		      <input class="inputxt" id="busTypeName" name="busTypeName" ignore="ignore"   value="${servicePage.busTypeName}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">服务缩略图url:</label>
		      <input class="inputxt" id="iconUrl" name="iconUrl" ignore="ignore"   value="${servicePage.iconUrl}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">状态:</label>
		      <input class="inputxt" id="status" name="status" ignore="ignore"   value="${servicePage.status}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">创建时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="createdTime" name="createdTime" ignore="ignore"     value="<fmt:formatDate value='${servicePage.createdTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>