package com.sht.entity.cooperationprod;

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
 * @Description: 合作对接
 * @author zhangdaihao
 * @date 2018-06-15 11:00:53
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_cooperation_prod", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class CooperationProdEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**用户ID*/
	private java.lang.String userId;
	/**合作类型*/
	private java.lang.String coopType;
	/**标题*/
	private java.lang.String title;
	/**对接内容*/
	private java.lang.String content;
	/**联系人*/
	private java.lang.String linkman;
	/**联系人信息*/
	private java.lang.String contactInfo;
	/**时间*/
	private java.util.Date time;
	/**状态*/
	private java.lang.Integer status;
	/**排序*/
	private double orders;
	
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
	@Column(name ="USER_ID",nullable=true,length=32)
	public java.lang.String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户ID
	 */
	public void setUserId(java.lang.String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合作类型
	 */
	@Column(name ="COOP_TYPE",nullable=true,length=255)
	public java.lang.String getCoopType(){
		return this.coopType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合作类型
	 */
	public void setCoopType(java.lang.String coopType){
		this.coopType = coopType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=true,length=255)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标题
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  对接内容
	 */
	@Column(name ="CONTENT",nullable=true,length=65535)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  对接内容
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人
	 */
	@Column(name ="LINKMAN",nullable=true,length=255)
	public java.lang.String getLinkman(){
		return this.linkman;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人
	 */
	public void setLinkman(java.lang.String linkman){
		this.linkman = linkman;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人信息
	 */
	@Column(name ="CONTACT_INFO",nullable=true,length=65535)
	public java.lang.String getContactInfo(){
		return this.contactInfo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人信息
	 */
	public void setContactInfo(java.lang.String contactInfo){
		this.contactInfo = contactInfo;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  时间
	 */
	@Column(name ="TIME",nullable=true)
	public java.util.Date getTime(){
		return this.time;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  时间
	 */
	public void setTime(java.util.Date time){
		this.time = time;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态
	 */
	@Column(name ="STATUS",nullable=true,precision=10,scale=0)
	public java.lang.Integer getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态
	 */
	public void setStatus(java.lang.Integer status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  排序
	 */
	@Column(name ="ORDERS",nullable=true,precision=11,scale=0)
	public double getOrders(){
		return this.orders;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  排序
	 */
	public void setOrders(double orders){
		this.orders = orders;
	}
}
