package com.sht.entity.localactivity;

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
 * @Description: 本地活动
 * @author zhangdaihao
 * @date 2018-06-15 11:04:01
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_local_activity", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class LocalActivityEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**时间*/
	private java.util.Date time;
	/**地点*/
	private java.lang.String address;
	/**目的*/
	private java.lang.String aim;
	/**形式*/
	private java.lang.String form;
	/**peopleNum*/
	private java.lang.String peopleNum;
	/**参加对象*/
	private java.lang.String participatePeople;
	/**状态*/
	private java.lang.Integer status;
	/**会议议程*/
	private java.lang.String agenda;
	/**是否允许发言*/
	private java.lang.String allowShare;
	/**嘉宾介绍*/
	private java.lang.String guestIntroduce;
	/**合作商机*/
	private java.lang.String cooperOpportunity;
	/**活动报道链接*/
	private java.lang.String articalUrl;
	
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地点
	 */
	@Column(name ="ADDRESS",nullable=true,length=2000)
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地点
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  目的
	 */
	@Column(name ="AIM",nullable=true,length=1000)
	public java.lang.String getAim(){
		return this.aim;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  目的
	 */
	public void setAim(java.lang.String aim){
		this.aim = aim;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  形式
	 */
	@Column(name ="FORM",nullable=true,length=1000)
	public java.lang.String getForm(){
		return this.form;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  形式
	 */
	public void setForm(java.lang.String form){
		this.form = form;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  peopleNum
	 */
	@Column(name ="PEOPLE_NUM",nullable=true,length=1000)
	public java.lang.String getPeopleNum(){
		return this.peopleNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  peopleNum
	 */
	public void setPeopleNum(java.lang.String peopleNum){
		this.peopleNum = peopleNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参加对象
	 */
	@Column(name ="PARTICIPATE_PEOPLE",nullable=true,length=1000)
	public java.lang.String getParticipatePeople(){
		return this.participatePeople;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参加对象
	 */
	public void setParticipatePeople(java.lang.String participatePeople){
		this.participatePeople = participatePeople;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  会议议程
	 */
	@Column(name ="AGENDA",nullable=true,length=65535)
	public java.lang.String getAgenda(){
		return this.agenda;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  会议议程
	 */
	public void setAgenda(java.lang.String agenda){
		this.agenda = agenda;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否允许发言
	 */
	@Column(name ="ALLOW_SHARE",nullable=true,length=10)
	public java.lang.String getAllowShare(){
		return this.allowShare;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否允许发言
	 */
	public void setAllowShare(java.lang.String allowShare){
		this.allowShare = allowShare;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  嘉宾介绍
	 */
	@Column(name ="GUEST_INTRODUCE",nullable=true,length=65535)
	public java.lang.String getGuestIntroduce(){
		return this.guestIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  嘉宾介绍
	 */
	public void setGuestIntroduce(java.lang.String guestIntroduce){
		this.guestIntroduce = guestIntroduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合作商机
	 */
	@Column(name ="COOPER_OPPORTUNITY",nullable=true,length=65535)
	public java.lang.String getCooperOpportunity(){
		return this.cooperOpportunity;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合作商机
	 */
	public void setCooperOpportunity(java.lang.String cooperOpportunity){
		this.cooperOpportunity = cooperOpportunity;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动报道链接
	 */
	@Column(name ="ARTICAL_URL",nullable=true,length=1000)
	public java.lang.String getArticalUrl(){
		return this.articalUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动报道链接
	 */
	public void setArticalUrl(java.lang.String articalUrl){
		this.articalUrl = articalUrl;
	}
}
