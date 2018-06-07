package com.sht.entity.order;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 订单表
 * @author zhangdaihao
 * @date 2018-06-06 20:26:29
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_order", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class OrderEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**用户ID*/
	private java.lang.String userid;
	/**用户名字*/
	private java.lang.String username;
	/**商品ID*/
	private java.lang.String goodsid;
	/**商品类型*/
	private java.lang.Integer ordertype;
	/**订单状态*/
	private java.lang.Integer status;
	/**价格*/
	private BigDecimal price;
	/**单位*/
	private java.lang.String unit;
	/**商品数量*/
	private java.lang.Integer quantity;
	/**下单时间*/
	private java.util.Date placeOrderTime;
	/**支付时间*/
	private java.util.Date payTime;
	/**标记*/
	private java.lang.Integer flag;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户ID
	 */
	@Column(name ="USERID",nullable=true,length=32)
	public java.lang.String getUserid(){
		return this.userid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户ID
	 */
	public void setUserid(java.lang.String userid){
		this.userid = userid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户名字
	 */
	@Column(name ="USERNAME",nullable=true,length=255)
	public java.lang.String getUsername(){
		return this.username;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户名字
	 */
	public void setUsername(java.lang.String username){
		this.username = username;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品ID
	 */
	@Column(name ="GOODSID",nullable=true,length=32)
	public java.lang.String getGoodsid(){
		return this.goodsid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品ID
	 */
	public void setGoodsid(java.lang.String goodsid){
		this.goodsid = goodsid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  商品类型
	 */
	@Column(name ="ORDERTYPE",nullable=true,precision=10,scale=0)
	public java.lang.Integer getOrdertype(){
		return this.ordertype;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  商品类型
	 */
	public void setOrdertype(java.lang.Integer ordertype){
		this.ordertype = ordertype;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  订单状态
	 */
	@Column(name ="STATUS",nullable=true,precision=10,scale=0)
	public java.lang.Integer getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  订单状态
	 */
	public void setStatus(java.lang.Integer status){
		this.status = status;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  价格
	 */
	@Column(name ="PRICE",nullable=true,precision=10,scale=2)
	public BigDecimal getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  价格
	 */
	public void setPrice(BigDecimal price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */
	@Column(name ="UNIT",nullable=true,length=255)
	public java.lang.String getUnit(){
		return this.unit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setUnit(java.lang.String unit){
		this.unit = unit;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  商品数量
	 */
	@Column(name ="QUANTITY",nullable=true,precision=10,scale=0)
	public java.lang.Integer getQuantity(){
		return this.quantity;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  商品数量
	 */
	public void setQuantity(java.lang.Integer quantity){
		this.quantity = quantity;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  下单时间
	 */
	@Column(name ="PLACE_ORDER_TIME",nullable=true)
	public java.util.Date getPlaceOrderTime(){
		return this.placeOrderTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  下单时间
	 */
	public void setPlaceOrderTime(java.util.Date placeOrderTime){
		this.placeOrderTime = placeOrderTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  支付时间
	 */
	@Column(name ="PAY_TIME",nullable=true)
	public java.util.Date getPayTime(){
		return this.payTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  支付时间
	 */
	public void setPayTime(java.util.Date payTime){
		this.payTime = payTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  标记
	 */
	@Column(name ="FLAG",nullable=true,precision=10,scale=0)
	public java.lang.Integer getFlag(){
		return this.flag;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  标记
	 */
	public void setFlag(java.lang.Integer flag){
		this.flag = flag;
	}
}
