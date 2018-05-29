package com.sht.entity.questiontag;

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
 * @Description: 问题标签表
 * @author zhangdaihao
 * @date 2018-05-29 22:01:20
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sht_question_tag", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class QuestionTagEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**标签名字*/
	private java.lang.String tagName;
	/**问题分类ID*/
	private java.lang.String questionCategoryId;
	/**访问次数*/
	private java.lang.Integer visitCount;
	
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
	 *@return: java.lang.String  标签名字
	 */
	@Column(name ="TAG_NAME",nullable=true,length=512)
	public java.lang.String getTagName(){
		return this.tagName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标签名字
	 */
	public void setTagName(java.lang.String tagName){
		this.tagName = tagName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  问题分类ID
	 */
	@Column(name ="QUESTION_CATEGORY_ID",nullable=true,length=32)
	public java.lang.String getQuestionCategoryId(){
		return this.questionCategoryId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  问题分类ID
	 */
	public void setQuestionCategoryId(java.lang.String questionCategoryId){
		this.questionCategoryId = questionCategoryId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  访问次数
	 */
	@Column(name ="VISIT_COUNT",nullable=true,precision=10,scale=0)
	public java.lang.Integer getVisitCount(){
		return this.visitCount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  访问次数
	 */
	public void setVisitCount(java.lang.Integer visitCount){
		this.visitCount = visitCount;
	}
}
