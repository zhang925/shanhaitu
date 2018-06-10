<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>文章新闻</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="articleNewsController.do?save">
		<input id="id" name="id" type="hidden" value="${articleNewsPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">标题:</label>
		      <input class="inputxt" id="title" name="title"    value="${articleNewsPage.title}" datatype="*" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">概要:</label>
		      <input class="inputxt" id="summary" name="summary" ignore="ignore"   value="${articleNewsPage.summary}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">内容:</label>
		      <input class="inputxt" id="content" name="content" ignore="ignore"   value="${articleNewsPage.content}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">作者:</label>
		      <input class="inputxt" id="author" name="author" ignore="ignore"   value="${articleNewsPage.author}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">创建者ID:</label>
		      <input class="inputxt" id="creatorId" name="creatorId" ignore="ignore"   value="${articleNewsPage.creatorId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">修改者ID:</label>
		      <input class="inputxt" id="editorId" name="editorId" ignore="ignore"   value="${articleNewsPage.editorId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">创建者名字:</label>
		      <input class="inputxt" id="creator" name="creator" ignore="ignore"   value="${articleNewsPage.creator}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">修改者名字:</label>
		      <input class="inputxt" id="editor" name="editor" ignore="ignore"   value="${articleNewsPage.editor}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">创建时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="createdTime" name="createdTime" ignore="ignore"     value="<fmt:formatDate value='${articleNewsPage.createdTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">分类ID:</label>
		      <input class="inputxt" id="cateId" name="cateId" ignore="ignore"   value="${articleNewsPage.cateId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">状态:</label>
		      <input class="inputxt" id="status" name="status" ignore="ignore"   value="${articleNewsPage.status}" />
		      <span class="Validform_checktip"></span>
		    </div>

			<div class="form">
				<label class="Validform_label">图片路径:</label>
				<input class="inputxt" id="imageUrl" name="imageUrl" ignore="ignore"   value="${articleNewsPage.imageUrl}" />
				<span class="Validform_checktip"></span>
			</div>

			<div class="form">
				<label class="Validform_label">点赞数:</label>
				<input class="inputxt" id="likeCount" name="likeCount" ignore="likeCount"   value="${articleNewsPage.likeCount}" />
				<span class="Validform_checktip"></span>
			</div>

			<div class="form">
				<label class="Validform_label">访问量:</label>
				<input class="inputxt" id="visitCount" name="visitCount" ignore="ignore"   value="${articleNewsPage.visitCount}" />
				<span class="Validform_checktip"></span>
			</div>

	    </fieldset>
  </t:formvalid>
 </body>