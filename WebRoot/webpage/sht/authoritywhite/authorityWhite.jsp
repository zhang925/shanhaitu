<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>请求过滤白名单</title>
	<t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
<body >
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="authorityWhiteController.do?save">
<input id="id" name="id" type="hidden" value="${authorityWhitePage.id }">
<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
	<tr>
		<td align="right">
			<label class="Validform_label">
				可以免过滤的请求地址:
			</label>
		</td>
		<td class="value">
			<input class="inputxt" style="width: 350px;" id="authorityUri" name="authorityUri" ignore="ignore"  value="${authorityWhitePage.authorityUri}" />
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
			<input class="Wdate" disabled="disabled"  style="width: 150px" id="createTime" name="createTime"     value="<fmt:formatDate value='${authorityWhitePage.createTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" datatype="*" />
			<span class="Validform_checktip"></span>
		</td>
	</tr>
</table>
</t:formvalid>
<script type="text/javascript">
    function today(){
        var today=new Date();
        var h=today.getFullYear();
        var m=today.getMonth()+1;
        var d=today.getDate();
        var s=today.getHours();
        var f=today.getMinutes();
        var mm=today.getSeconds();
        m= m<10?"0"+m:m;
        d= d<10?"0"+d:d;
        s= s<10?"0"+s:s;
        f= f<10?"0"+f:f;
        mm= mm<10?"0"+mm:mm;
        return h+"-"+m+"-"+d +" "+s+":"+f+":"+mm;
    }
    document.getElementById("createTime").value = today();
</script>
    </body>