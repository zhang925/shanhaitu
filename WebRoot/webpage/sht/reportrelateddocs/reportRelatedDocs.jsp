<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>调研报告相关资料</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="reportRelatedDocsController.do?save">
		<input id="id" name="id" type="hidden" value="${reportRelatedDocsPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">调研报告ID:</label>
		      <input class="inputxt" id="investReportId" name="investReportId" ignore="ignore"   value="${reportRelatedDocsPage.investReportId}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">资料title:</label>
		      <input class="inputxt" id="title" name="title" ignore="ignore"   value="${reportRelatedDocsPage.title}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">文件格式:</label>
		      <input class="inputxt" id="format" name="format" ignore="ignore"   value="${reportRelatedDocsPage.format}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">资源路径:</label>
		      <input class="inputxt" style="width: 350px;" id="url" name="url" ignore="ignore"   value="${reportRelatedDocsPage.url}" />


				<span id="shownfile"  style="cursor: pointer;color: blue;" > </span>
				<br/>
				<input class="Validform_label" type="button" value="选择文件" id="fileTemp" name="fileTemp" />
				<span id="showFileName"></span>
				&nbsp;&nbsp;&nbsp;&nbsp;<input class="Validform_label" id="uploadFile" type="button" value="上传附件" />


				<span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">状态:</label>
		      <input class="inputxt" id="status" name="status" ignore="ignore"   value="${reportRelatedDocsPage.status}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>





 <div style="display: none"> <!--  上传附件的 隐藏 表单 -->
	 <form id="uploadFileForm" action="#" enctype="multipart/form-data" >
		 <input type="file"   id="file" name="file">
	 </form>
 </div>
 <script>

     $("#fileTemp").on('click',function(e){//监听 临时按钮是否 点击，点击了的话 选择文件的input 跟着点击
         document.getElementById("file").click();//选择文件
     });

     $("#file").on('input',function(e){//监听 临时按钮是否 点击，点击了的话 选择文件的input 跟着点击
         var fileName = $("#file").val();
         if(fileName){
             fileName = fileName.substring((fileName.lastIndexOf("\\")+1),fileName.length);
         }
         $("#showFileName").text(fileName);
     });


     $("#uploadFile").on("click",function () {
         //判断是否已经上传了。
         /*var isUplod = $("#showFileName").html();
         if(isUplod){//说明已经上传了
             if(!confirm("是否覆盖已经上传的附件")){
                 return;
             }
         }*/

         uploadFile();

     });
     function uploadFile(){
         var formData = new FormData($( "#uploadFileForm" )[0]);
         var fileName = $("#file").val();
         if(!fileName){
             $.messager.alert("提示","请选择要上传的文件");
             return;
         }
         var ajaxUrl = "api/file/upload/report/doc";
         //alert(ajaxUrl);
         //$('#uploadPic').serialize() 无法序列化二进制文件，这里采用formData上传
         //需要浏览器支持：Chrome 7+、Firefox 4+、IE 10+、Opera 12+、Safari 5+。
         $.ajax({
             type: "POST",
             //dataType: "text",
             url: ajaxUrl,
             data: formData,
             async: true,
             cache: false,
             contentType: false,
             processData: false,
             success: function (data) {
                 console.log(data)
                 var src = data;
                 //找到服务起的文件名。
                 var fileName = src.substring(src.lastIndexOf("/"),src.length);
                 var originname  = fileName.substring(15,src.length);

                 $("#url").val(src);//保存附件地址 originname +
                 $("#shownfile").html( "  <span onclick='delfile(\""+src+"\")'>删除</span>   <a onclick='downfile(\""+src+"\")'>下载</a> ");


             },
             error: function(data) {
                 console.log("上传出错：")
                 console.log(data)
             }
         });
         return false;
     }

     function delfile(src){
         $.dialog({
             content: '<div>是否删除?</div>',
             title: '提示',
             width: '80px',
             height: 50,
             okVal:'确定',
             zIndex:2099,//层的顺序最低是1976
             ok:function(){
                 $("#shownfile").html("");
                 $("#url").val("");//附件地址 清空
                 doDelete(src);//执行删除文件的真实操作
             },
             cancelVal: '关闭',
             cancel: function(){}
         });
     }

     function  doDelete(src) {
         var ajaxUrl = "api/file/delete";
         $.ajax({
             type: "POST",
             url: ajaxUrl,
             dataType:"json",
             data: {"src":src},
             async: true,
             success: function (data) {
                 console.log(data);

             },
             error: function(data) {
                 console.log("出错："+data);
             }
         });
     }
     function downfile(src){
         location.href = "api/file/down/src?src="+src;
     }

 </script>