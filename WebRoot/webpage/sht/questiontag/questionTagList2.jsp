<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
    <title>角色集合</title>
    <t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
  <t:datagrid name="questionTagList2" pagination="false" title="问题标签表" checkbox="true"  actionUrl="questionTagController.do?datagrid" showRefresh="false"  fit="true"  queryMode="group" onLoadSuccess="initCheck">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="标签名字" field="tagName"   width="120"></t:dgCol>
  </t:datagrid>
</body>
</html>

<script type="text/javascript">
    function initCheck(){
        var ids = "${ids}";
        var idArr = ids.split(",");
        for(var i=0;i<idArr.length;i++){
            if(idArr[i]!=""){
                $("#questionTagList2").datagrid("selectRecord",idArr[i]);
            }
        }
    }
</script>