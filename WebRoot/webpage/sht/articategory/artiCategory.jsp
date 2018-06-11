<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>文章分类</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="artiCategoryController.do?save">
		<input id="id" name="id" type="hidden" value="${artiCategoryPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">分类名字:</label>
		      <input class="inputxt" id="categoryName" name="categoryName" ignore="ignore"   value="${artiCategoryPage.categoryName}" />


                <span class="Validform_checktip"></span>
		    </div>

            <div class="form">
                <label class="Validform_label">排序:</label>

                <input class="inputxt" id="orders" name="orders" datatype="*"  <c:if test="${artiCategoryPage.orders==null || artiCategoryPage.orders=='' }"> value="0"</c:if>   value="${artiCategoryPage.orders}" />
                <span class="Validform_checktip"></span>
            </div>

	    </fieldset>

  </t:formvalid>
 </body>
