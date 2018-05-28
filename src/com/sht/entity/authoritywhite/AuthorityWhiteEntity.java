package com.sht.entity.authoritywhite;

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
 * @Description: 请求过滤白名单
 * @author zhangdaihao
 * @date 2018-05-26 19:43:38
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_s_authority_white", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class AuthorityWhiteEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**可以免过滤的请求地址*/
	private java.lang.String authorityUri;
	/**创建时间*/
	private java.util.Date createTime;
	
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
	 *@return: java.lang.String  可以免过滤的请求地址
	 */
	@Column(name ="AUTHORITY_URI",nullable=true,length=1000)
	public java.lang.String getAuthorityUri(){
		return this.authorityUri;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  可以免过滤的请求地址
	 */
	public void setAuthorityUri(java.lang.String authorityUri){
		this.authorityUri = authorityUri;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_TIME",nullable=false)
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
}
