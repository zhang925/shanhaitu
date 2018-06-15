package com.sht.entity.activityapply;

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
 * @Description: 活动报名
 * @author zhangdaihao
 * @date 2018-06-15 11:04:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_activity_apply", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ActivityApplyEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**活动表ID*/
	private java.lang.String activityId;
	/**目的*/
	private java.lang.String aim;
	/**是否允许发言*/
	private java.lang.String needShare;
	
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
	 *@return: java.lang.String  活动表ID
	 */
	@Column(name ="ACTIVITY_ID",nullable=true,length=32)
	public java.lang.String getActivityId(){
		return this.activityId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动表ID
	 */
	public void setActivityId(java.lang.String activityId){
		this.activityId = activityId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  目的
	 */
	@Column(name ="AIM",nullable=true,length=65535)
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
	 *@return: java.lang.String  是否允许发言
	 */
	@Column(name ="NEED_SHARE",nullable=true,length=10)
	public java.lang.String getNeedShare(){
		return this.needShare;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否允许发言
	 */
	public void setNeedShare(java.lang.String needShare){
		this.needShare = needShare;
	}
}
