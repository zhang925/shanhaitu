package com.sht.entity.question;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: Entity
 * @Description: 问题
 * @author zhangdaihao
 * @date 2018-05-29 21:57:48
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_question", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class QuestionEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**标题*/
	private java.lang.String title;
	/**概要*/
	private java.lang.String summary;
	/**内容*/
	private java.lang.String content;
	/**创建时间*/
	private java.util.Date createdTime;
	/**访问量*/
	private java.lang.Integer visitCount;

	/**临时字段*/
	private java.lang.String tagid;
	/**临时字段2*/
	private java.lang.String tagName;
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
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=true,length=512)
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
	 *@return: java.lang.String  内容
	 */
	@Column(name ="CONTENT",nullable=true,length=50000)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容
	 */
	public void setContent(java.lang.String content){
		this.content = content;
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
	 *@return: java.lang.Integer  访问量
	 */
	@Column(name ="VISIT_COUNT",nullable=true,precision=10,scale=0)
	public java.lang.Integer getVisitCount(){
		return this.visitCount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  访问量
	 */
	public void setVisitCount(java.lang.Integer visitCount){
		this.visitCount = visitCount;
	}

	@Transient
	public String getTagid() {
		return tagid;
	}

	public void setTagid(String tagid) {
		this.tagid = tagid;
	}




	@Transient
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
}
