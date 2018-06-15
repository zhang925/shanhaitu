<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>本地活动</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body  >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="localActivityController.do?save">
		<input id="id" name="id" type="hidden" value="${localActivityPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="time" name="time" ignore="ignore"     value="<fmt:formatDate value='${localActivityPage.time}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">地点:</label>
		      <input class="inputxt" id="address" name="address" ignore="ignore"   value="${localActivityPage.address}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">目的:</label>
		      <input class="inputxt" id="aim" name="aim" ignore="ignore"   value="${localActivityPage.aim}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">形式:</label>
		      <input class="inputxt" id="form" name="form" ignore="ignore"   value="${localActivityPage.form}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">peopleNum:</label>
		      <input class="inputxt" id="peopleNum" name="peopleNum" ignore="ignore"   value="${localActivityPage.peopleNum}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">参加对象:</label>
		      <input class="inputxt" id="participatePeople" name="participatePeople" ignore="ignore"   value="${localActivityPage.participatePeople}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">状态:</label>
		      <input class="inputxt" id="status" name="status" ignore="ignore"   value="${localActivityPage.status}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">会议议程:</label>
		      <input class="inputxt" id="agenda" name="agenda" ignore="ignore"   value="${localActivityPage.agenda}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">是否允许发言:</label>
		      <input class="inputxt" id="allowShare" name="allowShare" ignore="ignore"   value="${localActivityPage.allowShare}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">嘉宾介绍:</label>
		      <input class="inputxt" id="guestIntroduce" name="guestIntroduce" ignore="ignore"   value="${localActivityPage.guestIntroduce}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">合作商机:</label>
		      <input class="inputxt" id="cooperOpportunity" name="cooperOpportunity" ignore="ignore"   value="${localActivityPage.cooperOpportunity}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">活动报道链接:</label>
		      <input class="inputxt" id="articalUrl" name="articalUrl" ignore="ignore"   value="${localActivityPage.articalUrl}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>