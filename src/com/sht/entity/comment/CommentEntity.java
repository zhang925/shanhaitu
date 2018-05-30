package com.sht.entity.comment;

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
 * @Description: 评论
 * @author zhangdaihao
 * @date 2018-05-29 22:03:12
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_comment", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class CommentEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**创建者ID*/
	private java.lang.String useId;
	/**创建者姓名*/
	private java.lang.String useName;
	/**服务ID*/
	private java.lang.String serviceId;
	/**印象ID*/
	private java.lang.String impressId;
	/**评论内容*/
	private java.lang.String content;
	/**订单ID*/
	private java.lang.String orderId;
	/**评分*/
	private java.lang.String score;
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
	 *@return: java.lang.String  创建者ID
	 */
	@Column(name ="USE_ID",nullable=true,length=32)
	public java.lang.String getUseId(){
		return this.useId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建者ID
	 */
	public void setUseId(java.lang.String useId){
		this.useId = useId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建者姓名
	 */
	@Column(name ="USE_NAME",nullable=true,length=32)
	public java.lang.String getUseName(){
		return this.useName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建者姓名
	 */
	public void setUseName(java.lang.String useName){
		this.useName = useName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务ID
	 */
	@Column(name ="SERVICE_ID",nullable=true,length=32)
	public java.lang.String getServiceId(){
		return this.serviceId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务ID
	 */
	public void setServiceId(java.lang.String serviceId){
		this.serviceId = serviceId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  印象ID
	 */
	@Column(name ="IMPRESS_ID",nullable=true,length=32)
	public java.lang.String getImpressId(){
		return this.impressId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  印象ID
	 */
	public void setImpressId(java.lang.String impressId){
		this.impressId = impressId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  评论内容
	 */
	@Column(name ="CONTENT",nullable=true,length=50000)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评论内容
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订单ID
	 */
	@Column(name ="ORDER_ID",nullable=true,length=32)
	public java.lang.String getOrderId(){
		return this.orderId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单ID
	 */
	public void setOrderId(java.lang.String orderId){
		this.orderId = orderId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  评分
	 */
	@Column(name ="SCORE",nullable=true,length=10)
	public java.lang.String getScore(){
		return this.score;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评分
	 */
	public void setScore(java.lang.String score){
		this.score = score;
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
