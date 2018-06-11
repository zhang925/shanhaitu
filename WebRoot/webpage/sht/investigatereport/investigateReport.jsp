<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>调研报告</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body  >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="investigateReportController.do?save">
		<input id="id" name="id" type="hidden" value="${investigateReportPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">摘要:</label>
		      <input class="inputxt" id="title" name="title" ignore="ignore"   value="${investigateReportPage.title}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">分类ID:</label>
		      <input class="inputxt" id="categoryId" name="categoryId" ignore="ignore"   value="${investigateReportPage.categoryId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">交付方式:</label>
		      <input class="inputxt" id="delivery" name="delivery" ignore="ignore"   value="${investigateReportPage.delivery}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">摘要:</label>
		      <input class="inputxt" id="summary" name="summary" ignore="ignore"   value="${investigateReportPage.summary}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">价格:</label>
		      <input class="inputxt" id="price" name="price" ignore="ignore"   value="${investigateReportPage.price}" datatype="d" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">价格单位:</label>
		      <input class="inputxt" id="unit" name="unit" ignore="ignore"   value="${investigateReportPage.unit}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">总页数:</label>
		      <input class="inputxt" id="totalPage" name="totalPage" ignore="ignore"   value="${investigateReportPage.totalPage}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">附件数:</label>
		      <input class="inputxt" id="attchCount" name="attchCount" ignore="ignore"   value="${investigateReportPage.attchCount}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">创建时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="createdTime" name="createdTime" datatype="*"     value="<fmt:formatDate value='${investigateReportPage.createdTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">更新时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="updatedTime" name="updatedTime" ignore="ignore"     value="<fmt:formatDate value='${investigateReportPage.updatedTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">格式:</label>
		      <input class="inputxt" id="format" name="format" ignore="ignore"   value="${investigateReportPage.format}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label"> 状态:</label>
		      <input class="inputxt" id="status" name="status" ignore="ignore"   value="${investigateReportPage.status}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">排序:</label>
				<input class="inputxt" id="orders" name="orders" datatype="*"  <c:if test="${investigateReportPage.orders==null || investigateReportPage.orders=='' }"> value="0"</c:if>   value="${investigateReportPage.orders}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>