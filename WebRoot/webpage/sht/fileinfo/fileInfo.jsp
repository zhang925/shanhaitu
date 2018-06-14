<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>山海图文件信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="fileInfoController.do?save">
		<input id="id" name="id" type="hidden" value="${fileInfoPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">附件原始名称:</label>
		      <input class="inputxt" id="fileOriginName" name="fileOriginName" ignore="ignore"   value="${fileInfoPage.fileOriginName}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">附件名称:</label>
		      <input class="inputxt" id="fileName" name="fileName" ignore="ignore"   value="${fileInfoPage.fileName}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">附件大小:</label>
		      <input class="inputxt" id="fileSize" name="fileSize" ignore="ignore"   value="${fileInfoPage.fileSize}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">附件大小的单位:</label>
		      <input class="inputxt" id="fileSizeUnit" name="fileSizeUnit" ignore="ignore"   value="${fileInfoPage.fileSizeUnit}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">扩展名:</label>
		      <input class="inputxt" id="extend" name="extend" ignore="ignore"   value="${fileInfoPage.extend}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">附件路径:</label>
		      <input class="inputxt" id="realpath" name="realpath" ignore="ignore"   value="${fileInfoPage.realpath}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">用户ID:</label>
		      <input class="inputxt" id="userid" name="userid" ignore="ignore"   value="${fileInfoPage.userid}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">用户名字:</label>
		      <input class="inputxt" id="user" name="user" ignore="ignore"   value="${fileInfoPage.user}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">对应模块:</label>
		      <input class="inputxt" id="modular" name="modular" ignore="ignore"   value="${fileInfoPage.modular}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">实体类名字，一定要和实体照应:</label>
		      <input class="inputxt" id="className" name="className" ignore="ignore"   value="${fileInfoPage.className}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">对应表的名字:</label>
		      <input class="inputxt" id="tableName" name="tableName" ignore="ignore"   value="${fileInfoPage.tableName}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">对应数据的id:</label>
		      <input class="inputxt" id="columnid" name="columnid" ignore="ignore"   value="${fileInfoPage.columnid}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>