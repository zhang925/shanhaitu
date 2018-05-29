package com.sht.entity.businspection;

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
 * @Description: 商务考察
 * @author zhangdaihao
 * @date 2018-05-29 22:46:59
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_bus_inspection", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class BusInspectionEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**概要*/
	private java.lang.String summary;
	/**考察时间*/
	private java.lang.String period;
	/**团员人数*/
	private java.lang.Integer memCount;
	/**档期*/
	private java.lang.String departureDate;
	/**价格*/
	private java.lang.Float price;
	/**价格单位*/
	private java.lang.String unit;
	/**活动说明*/
	private java.lang.String inspectDetail;
	/**行程安排*/
	private java.lang.String schedule;
	/**创建时间*/
	private java.util.Date createdTime;
	/**状态*/
	private java.lang.Integer status;
	
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
	 *@return: java.lang.String  概要
	 */
	@Column(name ="SUMMARY",nullable=true,length=50000)
	public java.lang.String getSummary(){
		return this.summary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  概要
	 */
	public void setSummary(java.lang.String summary){
		this.summary = summary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  考察时间
	 */
	@Column(name ="PERIOD",nullable=true,length=256)
	public java.lang.String getPeriod(){
		return this.period;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  考察时间
	 */
	public void setPeriod(java.lang.String period){
		this.period = period;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  团员人数
	 */
	@Column(name ="MEM_COUNT",nullable=true,precision=10,scale=0)
	public java.lang.Integer getMemCount(){
		return this.memCount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  团员人数
	 */
	public void setMemCount(java.lang.Integer memCount){
		this.memCount = memCount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  档期
	 */
	@Column(name ="DEPARTURE_DATE",nullable=true,length=512)
	public java.lang.String getDepartureDate(){
		return this.departureDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  档期
	 */
	public void setDepartureDate(java.lang.String departureDate){
		this.departureDate = departureDate;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动说明
	 */
	@Column(name ="INSPECT_DETAIL",nullable=true,length=50000)
	public java.lang.String getInspectDetail(){
		return this.inspectDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动说明
	 */
	public void setInspectDetail(java.lang.String inspectDetail){
		this.inspectDetail = inspectDetail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行程安排
	 */
	@Column(name ="SCHEDULE",nullable=true,length=50000)
	public java.lang.String getSchedule(){
		return this.schedule;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行程安排
	 */
	public void setSchedule(java.lang.String schedule){
		this.schedule = schedule;
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
}
