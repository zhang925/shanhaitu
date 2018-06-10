<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>订单表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="orderController.do?save">
		<input id="id" name="id" type="hidden" value="${orderPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">用户ID:</label>
		      <input class="inputxt" id="userid" name="userid" ignore="ignore"   value="${orderPage.userid}" />
		      <span class="Validform_checktip"></span>
		    </div>

			<div class="form">
				<label class="Validform_label">订单ID:</label>
				<input class="inputxt" id="orderid" name="orderid" ignore="ignore"   value="${orderPage.orderid}" />
				<span class="Validform_checktip"></span>
			</div>


			<div class="form">
		      <label class="Validform_label">用户名字:</label>
		      <input class="inputxt" id="username" name="username" ignore="ignore"   value="${orderPage.username}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">商品ID:</label>
		      <input class="inputxt" id="goodsid" name="goodsid" ignore="ignore"   value="${orderPage.goodsid}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">商品类型:</label>
		      <input class="inputxt" id="ordertype" name="ordertype" ignore="ignore"   value="${orderPage.ordertype}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">订单状态:</label>
		      <input class="inputxt" id="status" name="status" ignore="ignore"   value="${orderPage.status}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">价格:</label>
		      <input class="inputxt" id="price" name="price" ignore="ignore"   value="${orderPage.price}" datatype="d" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">单位:</label>
		      <input class="inputxt" id="unit" name="unit" ignore="ignore"   value="${orderPage.unit}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">商品数量:</label>
		      <input class="inputxt" id="quantity" name="quantity" ignore="ignore"   value="${orderPage.quantity}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">下单时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="placeOrderTime" name="placeOrderTime" ignore="ignore"     value="<fmt:formatDate value='${orderPage.placeOrderTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">支付时间:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="payTime" name="payTime" ignore="ignore"     value="<fmt:formatDate value='${orderPage.payTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">标记:</label>
		      <input class="inputxt" id="flag" name="flag" ignore="ignore"   value="${orderPage.flag}" datatype="n" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>