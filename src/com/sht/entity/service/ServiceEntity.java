package com.sht.entity.service;

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
 * @Description: 服务
 * @author zhangdaihao
 * @date 2018-05-29 22:04:22
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_service", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ServiceEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**业务表ID*/
	private java.lang.String busId;
	/**服务名字*/
	private java.lang.String servName;
	/**公司名*/
	private java.lang.String company;
	/**地址*/
	private java.lang.String location;
	/**服务大类ID*/
	private java.lang.String servCategoryId;
	/**服务大类名字*/
	private java.lang.String servCategoryName;
	/**业务类型ID*/
	private java.lang.String busTypeId;
	/**业务类型名字*/
	private java.lang.String busTypeName;
	/**服务缩略图url*/
	private java.lang.String iconUrl;
	/**状态*/
	private java.lang.String status;
	/**创建时间*/
	private java.util.Date createdTime;


	
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
	 *@return: java.lang.String  业务表ID
	 */
	@Column(name ="BUS_ID",nullable=true,length=32)
	public java.lang.String getBusId(){
		return this.busId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务表ID
	 */
	public void setBusId(java.lang.String busId){
		this.busId = busId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务名字
	 */
	@Column(name ="SERV_NAME",nullable=true,length=2000)
	public java.lang.String getServName(){
		return this.servName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务名字
	 */
	public void setServName(java.lang.String servName){
		this.servName = servName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司名
	 */
	@Column(name ="COMPANY",nullable=true,length=500)
	public java.lang.String getCompany(){
		return this.company;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司名
	 */
	public void setCompany(java.lang.String company){
		this.company = company;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址
	 */
	@Column(name ="LOCATION",nullable=true,length=1000)
	public java.lang.String getLocation(){
		return this.location;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址
	 */
	public void setLocation(java.lang.String location){
		this.location = location;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务大类ID
	 */
	@Column(name ="SERV_CATEGORY_ID",nullable=true,length=32)
	public java.lang.String getServCategoryId(){
		return this.servCategoryId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务大类ID
	 */
	public void setServCategoryId(java.lang.String servCategoryId){
		this.servCategoryId = servCategoryId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务大类名字
	 */
	@Column(name ="SERV_CATEGORY_NAME",nullable=true,length=500)
	public java.lang.String getServCategoryName(){
		return this.servCategoryName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务大类名字
	 */
	public void setServCategoryName(java.lang.String servCategoryName){
		this.servCategoryName = servCategoryName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务类型ID
	 */
	@Column(name ="BUS_TYPE_ID",nullable=true,length=32)
	public java.lang.String getBusTypeId(){
		return this.busTypeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务类型ID
	 */
	public void setBusTypeId(java.lang.String busTypeId){
		this.busTypeId = busTypeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务类型名字
	 */
	@Column(name ="BUS_TYPE_NAME",nullable=true,length=500)
	public java.lang.String getBusTypeName(){
		return this.busTypeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务类型名字
	 */
	public void setBusTypeName(java.lang.String busTypeName){
		this.busTypeName = busTypeName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务缩略图url
	 */
	@Column(name ="ICON_URL",nullable=true,length=1500)
	public java.lang.String getIconUrl(){
		return this.iconUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务缩略图url
	 */
	public void setIconUrl(java.lang.String iconUrl){
		this.iconUrl = iconUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */
	@Column(name ="STATUS",nullable=true,length=10)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
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
}
