<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>测试公告</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="snoticeController.do?save">
		<input id="id" name="id" type="hidden" value="${snoticePage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">标题:</label>
		      <input class="inputxt" id="title" name="title" ignore="ignore"   value="${snoticePage.title}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">内容:</label>
		      <input class="inputxt" id="content" name="content" ignore="ignore"   value="${snoticePage.content}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">通知公告类型:</label>
		      <input class="inputxt" id="type" name="type" ignore="ignore"   value="${snoticePage.type}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">公开范围:</label>
		      <input class="inputxt" id="level" name="level" ignore="ignore"   value="${snoticePage.level}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">链接地址:</label>
		      <input class="inputxt" id="linkurl" name="linkurl" ignore="ignore"   value="${snoticePage.linkurl}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">有效日期:</label>
		      <input class="inputxt" id="expirydate" name="expirydate" ignore="ignore"   value="${snoticePage.expirydate}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form" style="display: none;" >
		      <label class="Validform_label">创建者ID:</label>
		      <input class="inputxt" id="createuserid" name="createuserid" ignore="ignore"   value="${snoticePage.createuserid}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">创建者名字:</label>
		      <input class="inputxt" id="createusername" name="createusername" ignore="ignore"   value="${snoticePage.createusername}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">创建时间:</label>
		      <input class="inputxt" id="createtime" name="createtime" ignore="ignore"   value="${snoticePage.createtime}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>