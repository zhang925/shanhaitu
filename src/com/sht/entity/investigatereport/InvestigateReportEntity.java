package com.sht.entity.investigatereport;

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
 * @Description: 调研报告
 * @author zhangdaihao
 * @date 2018-05-29 21:50:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_investigate_report", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class InvestigateReportEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**摘要*/
	private java.lang.String title;
	/**分类ID*/
	private java.lang.String categoryId;
	/**交付方式*/
	private java.lang.String delivery;
	/**摘要*/
	private java.lang.String summary;
	/**价格*/
	private java.lang.Float price;
	/**价格单位*/
	private java.lang.String unit;
	/**总页数*/
	private java.lang.Integer totalPage;
	/**附件数*/
	private java.lang.Integer attchCount;
	/**创建时间*/
	private java.util.Date createdTime;
	/**更新时间*/
	private java.util.Date updatedTime;
	/**格式*/
	private java.lang.String format;
	/** 状态*/
	private java.lang.String status;
	/**排序*/
	private java.lang.String orders;
	
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
	 *@return: java.lang.String  摘要
	 */
	@Column(name ="TITLE",nullable=true,length=512)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  摘要
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分类ID
	 */
	@Column(name ="CATEGORY_ID",nullable=true,length=32)
	public java.lang.String getCategoryId(){
		return this.categoryId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分类ID
	 */
	public void setCategoryId(java.lang.String categoryId){
		this.categoryId = categoryId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交付方式
	 */
	@Column(name ="DELIVERY",nullable=true,length=32)
	public java.lang.String getDelivery(){
		return this.delivery;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交付方式
	 */
	public void setDelivery(java.lang.String delivery){
		this.delivery = delivery;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  摘要
	 */
	@Column(name ="SUMMARY",nullable=true,length=50000)
	public java.lang.String getSummary(){
		return this.summary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  摘要
	 */
	public void setSummary(java.lang.String summary){
		this.summary = summary;
	}
	/**
	 *方法: 取得java.lang.Float
	 *@return: java.lang.Float  价格
	 */
	@Column(name ="PRICE",nullable=true,precision=12)
	public java.lang.Float getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.Float
	 *@param: java.lang.Float  价格
	 */
	public void setPrice(java.lang.Float price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  价格单位
	 */
	@Column(name ="UNIT",nullable=true,length=20)
	public java.lang.String getUnit(){
		return this.unit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  价格单位
	 */
	public void setUnit(java.lang.String unit){
		this.unit = unit;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  总页数
	 */
	@Column(name ="TOTAL_PAGE",nullable=true,precision=10,scale=0)
	public java.lang.Integer getTotalPage(){
		return this.totalPage;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  总页数
	 */
	public void setTotalPage(java.lang.Integer totalPage){
		this.totalPage = totalPage;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  附件数
	 */
	@Column(name ="ATTCH_COUNT",nullable=true,precision=10,scale=0)
	public java.lang.Integer getAttchCount(){
		return this.attchCount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  附件数
	 */
	public void setAttchCount(java.lang.Integer attchCount){
		this.attchCount = attchCount;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATED_TIME",nullable=true)
	public java.util.Date getCreatedTime(){
		return this.createdTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreatedTime(java.util.Date createdTime){
		this.createdTime = createdTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新时间
	 */
	@Column(name ="UPDATED_TIME",nullable=true)
	public java.util.Date getUpdatedTime(){
		return this.updatedTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setUpdatedTime(java.util.Date updatedTime){
		this.updatedTime = updatedTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  格式
	 */
	@Column(name ="FORMAT",nullable=true,length=100)
	public java.lang.String getFormat(){
		return this.format;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  格式
	 */
	public void setFormat(java.lang.String format){
		this.format = format;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String   状态
	 */
	@Column(name ="STATUS",nullable=true,length=11)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String   状态
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  排序
	 */
	@Column(name ="ORDERS",nullable=true,length=11)
	public java.lang.String getOrders(){
		return this.orders;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  排序
	 */
	public void setOrders(java.lang.String orders){
		this.orders = orders;
	}
}
