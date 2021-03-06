<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>问题</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body  >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="questionController.do?save">
			<input id="id" name="id" type="hidden" value="${questionPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							标题:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="title" name="title" ignore="ignore"  value="${questionPage.title}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>

				<tr>
					<td align="right"><label class="Validform_label"> 标签分类: </label></td>
					<td class="value" nowrap>
						<input id="tagid" name="tagid"  type="hidden"  value="${questionPage.tagid}"/> <!--  从后台读取的 属性值 这是 加了 临时变量为temp -->
						<input name="tagName" id="tagName" class="inputxt" value="${questionPage.tagName }" readonly="readonly" />
						<t:choose hiddenName="tagid" hiddenid="id" textname="tagName" url="questionTagController.do?list2" name="questionTagList2" icon="icon-search" title="问题标签" isclear="true" isInit="true"></t:choose>
						<span class="Validform_checktip"><t:mutiLang langKey="可多选"/></span>
					</td>
				</tr>


				<tr>
					<td align="right">
						<label class="Validform_label">
							概要:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="summary" name="summary" ignore="ignore"  value="${questionPage.summary}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							内容:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="content" name="content" ignore="ignore"  value="${questionPage.content}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="createdTime" name="createdTime" ignore="ignore"    value="<fmt:formatDate value='${questionPage.createdTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							访问量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="visitCount" name="visitCount" ignore="ignore"  value="${questionPage.visitCount}" datatype="n" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>