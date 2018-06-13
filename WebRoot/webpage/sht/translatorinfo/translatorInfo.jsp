<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>翻译人员信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="translatorInfoController.do?save">
		<input id="id" name="id" type="hidden" value="${translatorInfoPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">姓名:</label>
		      <input class="inputxt" id="name" name="name" ignore="ignore"   value="${translatorInfoPage.name}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">性别:</label>
		      <input class="inputxt" id="sex" name="sex" ignore="ignore"   value="${translatorInfoPage.sex}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">地址:</label>
		      <input class="inputxt" id="address" name="address" ignore="ignore"   value="${translatorInfoPage.address}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">身份证号:</label>
		      <input class="inputxt" id="identityId" name="identityId" ignore="ignore"   value="${translatorInfoPage.identityId}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">电话1:</label>
		      <input class="inputxt" id="phone1" name="phone1" ignore="ignore"   value="${translatorInfoPage.phone1}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">电话2:</label>
		      <input class="inputxt" id="phone2" name="phone2" ignore="ignore"   value="${translatorInfoPage.phone2}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">邮箱:</label>
		      <input class="inputxt" id="email" name="email" ignore="ignore"   value="${translatorInfoPage.email}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">一种交流工具whatsapp:</label>
		      <input class="inputxt" id="whatsapp" name="whatsapp" ignore="ignore"   value="${translatorInfoPage.whatsapp}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">微信:</label>
		      <input class="inputxt" id="wechat" name="wechat" ignore="ignore"   value="${translatorInfoPage.wechat}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">头像地址:</label>
		      <input class="inputxt" id="pictureUrl" name="pictureUrl" ignore="ignore"   value="${translatorInfoPage.pictureUrl}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">学校:</label>
		      <input class="inputxt" id="college" name="college" ignore="ignore"   value="${translatorInfoPage.college}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">学历:</label>
		      <input class="inputxt" id="educationBg" name="educationBg" ignore="ignore"   value="${translatorInfoPage.educationBg}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">工作年限:</label>
		      <input class="inputxt" id="workYears" name="workYears" ignore="ignore"   value="${translatorInfoPage.workYears}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">工作经历:</label>
		      <input class="inputxt" id="workExper" name="workExper" ignore="ignore"   value="${translatorInfoPage.workExper}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">中文水平:</label>
		      <input class="inputxt" id="chineseLevel" name="chineseLevel" ignore="ignore"   value="${translatorInfoPage.chineseLevel}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">印度语水平:</label>
		      <input class="inputxt" id="indonesianLevel" name="indonesianLevel" ignore="ignore"   value="${translatorInfoPage.indonesianLevel}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">英语水平:</label>
		      <input class="inputxt" id="englishLevel" name="englishLevel" ignore="ignore"   value="${translatorInfoPage.englishLevel}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">其他语言:</label>
		      <input class="inputxt" id="otherLang" name="otherLang" ignore="ignore"   value="${translatorInfoPage.otherLang}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">评定等级:</label>
		      <input class="inputxt" id="ratings" name="ratings" ignore="ignore"   value="${translatorInfoPage.ratings}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>