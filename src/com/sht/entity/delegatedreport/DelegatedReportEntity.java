package com.sht.entity.delegatedreport;

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
 * @Description: 委托调研报告表
 * @author zhangdaihao
 * @date 2018-06-13 17:00:46
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_delegated_report", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class DelegatedReportEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**概要*/
	private java.lang.String content;
	/**联系电话*/
	private java.lang.String telphone;
	/**邮箱*/
	private java.lang.String email;
	/**微信*/
	private java.lang.String wechat;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
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
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  概要
	 */
	@Column(name ="CONTENT",nullable=true,length=65535)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  概要
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	@Column(name ="TELPHONE",nullable=true,length=20)
	public java.lang.String getTelphone(){
		return this.telphone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setTelphone(java.lang.String telphone){
		this.telphone = telphone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邮箱
	 */
	@Column(name ="EMAIL",nullable=true,length=255)
	public java.lang.String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邮箱
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信
	 */
	@Column(name ="WECHAT",nullable=true,length=255)
	public java.lang.String getWechat(){
		return this.wechat;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微信
	 */
	public void setWechat(java.lang.String wechat){
		this.wechat = wechat;
	}
}
