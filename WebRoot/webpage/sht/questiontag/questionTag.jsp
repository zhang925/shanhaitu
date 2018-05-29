<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>问题标签表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="questionTagController.do?save">
		<input id="id" name="id" type="hidden" value="${questionTagPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">标签名字:</label>
		      <input class="inputxt" id="tagName" name="tagName" ignore="ignore"   value="${questionTagPage.tagName}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">问题分类ID:</label>
		      <input class="inputxt" id="questionCategoryId" name="questionCategoryId" ignore="ignore"   value="${questionTagPage.questionCategoryId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">访问次数:</label>
		      <input class="inputxt" id="visitCount" name="visitCount" ignore="ignore"   value="${questionTagPage.visitCount}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>