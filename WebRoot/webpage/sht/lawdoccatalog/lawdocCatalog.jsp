<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>政策法规目录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body  >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="lawdocCatalogController.do?save">
		<input id="id" name="id" type="hidden" value="${lawdocCatalogPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">父级ID:</label>
		      <input class="inputxt" id="parentId" name="parentId" ignore="ignore"   value="${lawdocCatalogPage.parentId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">标题:</label>
		      <input class="inputxt" id="title" name="title" ignore="ignore"   value="${lawdocCatalogPage.title}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">所属层级:</label>
		      <input class="inputxt" id="level" name="level" ignore="ignore"   value="${lawdocCatalogPage.level}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">是否有子节点:</label>
		      <input class="inputxt" id="haveLeaf" name="haveLeaf" ignore="ignore"   value="${lawdocCatalogPage.haveLeaf}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">排序:</label>
		      <input class="inputxt" id="orders" name="orders" ignore="ignore"   value="${lawdocCatalogPage.orders}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>