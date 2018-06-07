<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="orderList" title="订单表" actionUrl="orderController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="用户ID" field="userid"   width="120"></t:dgCol>
   <t:dgCol title="订单ID" field="orderid"   width="120"></t:dgCol>
   <t:dgCol title="用户名字" field="username"   width="120"></t:dgCol>
   <t:dgCol title="商品ID" field="goodsid"   width="120"></t:dgCol>
   <t:dgCol title="商品类型" field="ordertype"   width="120"></t:dgCol>
   <t:dgCol title="订单状态" field="status"   width="120"></t:dgCol>
   <t:dgCol title="价格" field="price"   width="120"></t:dgCol>
   <t:dgCol title="单位" field="unit"   width="120"></t:dgCol>
   <t:dgCol title="商品数量" field="quantity"   width="120"></t:dgCol>
   <t:dgCol title="下单时间" field="placeOrderTime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="支付时间" field="payTime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="标记" field="flag"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="orderController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="orderController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="orderController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="orderController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>